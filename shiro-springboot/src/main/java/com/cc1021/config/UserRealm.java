package com.cc1021.config;

import com.cc1021.pojo.User;
import com.cc1021.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义的 UserRealm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权 doGetAuthorizationInfo");

        // SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        // 拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();   // 拿到User对象

        // 设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证 doGetAuthenticationInfo");

        // 用户名，密码～
//        String name = "root";
//        String password = "123456";


        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        // 连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null) { // 没有这个人
            return null; // 抛出异常 UnknownAccountException
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser", user);

        // 可以加密，MD5，MD5盐值加密
        // 密码认证，shiro做
        return new SimpleAuthenticationInfo(user, user.getPwd(), "");
    }
}
