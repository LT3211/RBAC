package com.lt.crowdfunding.controller;

import com.lt.crowdfunding.bean.AJAXResult;
import com.lt.crowdfunding.bean.Permission;
import com.lt.crowdfunding.bean.User;
import com.lt.crowdfunding.service.PermissionService;
import com.lt.crowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    /**
     * 退出方法
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //session.removeAttribute("loginUser");
        //session失效
        session.invalidate();
        return "redirect:login";
    }

    /**
     * 执行登陆AJAX方式
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession httpSession) {
        AJAXResult result = new AJAXResult();
        User dbuser = userService.query4Login(user);

        if (dbuser != null) {
            httpSession.setAttribute("loginUser", dbuser);

            //获取用户权限信息
            List<Permission> permissions = permissionService.queryPermissionsByUser(dbuser);

            Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
            Permission root = null;
            Set<String> uriSet=new HashSet<String>();
            for (Permission permission : permissions) {
                permissionMap.put(permission.getId(), permission);
                if (permission.getUrl()!=null||!"".equals(permission.getUrl())){
                    uriSet.add(httpSession.getServletContext().getContextPath()+permission.getUrl());
                }
            }
            httpSession.setAttribute("authUriSet",uriSet);
            for (Permission permission : permissions) {
                Permission child = permission;
                if (child.getPid() == 0) {
                    root = permission;
                }else {
                    Permission parent=permissionMap.get(child.getPid());
                    parent.getChildren().add(child);
                }

            }
            httpSession.setAttribute("rootPermission",root);

            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }


    /**
     * 执行登陆
     *
     * @param user
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model) throws UnsupportedEncodingException {
        //String loginacct=user.getLoginacct();

        //将乱码字符串按照错误的编码方式转换为原始的字符串序列
        //byte[] bs=loginacct.getBytes("ISO8859-1");

        //将原始的字节码序列按照正确的编码转换为正确的文字即可
        //loginacct=new String(bs,"UTF-8");

        //1）获取表单数据
        // 1-1)HttpServletRequest
        // 1-2)在方法参数列表中增加表单对应的参数,名称相同
        // 1-3)将表单数据封装为实体类对象

        //2)查询用户信息
        User dbuser = userService.query4Login(user);

        //3) 判断用户信息是否存在
        if (dbuser != null) {
            //登陆成功,跳转到主页面
            return "main";
        } else {
            //登陆失败，跳转回到登陆页面，提示错误信息
            String errorMsg = "登陆账号或密码不正确,请重新输入";
            model.addAttribute("errorMsg", errorMsg);
            return "redirect:login";
        }
    }
}
