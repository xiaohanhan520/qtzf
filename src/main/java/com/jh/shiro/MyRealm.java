package com.jh.shiro;


import com.jh.dao.UserDao;
import com.jh.entity.User;
import com.jh.utils.SpringContextUtil;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;



public class MyRealm extends AuthorizingRealm {

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UserDao userDao = (UserDao) SpringContextUtil.getBean(UserDao.class);
        String username = (String) authenticationToken.getPrincipal();
        User user = userDao.selectByUsername(username);
        if (user == null){
            return null;
        }else{
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes(user.getSale()),this.getName());
            return simpleAuthenticationInfo;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

/*

    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进行授权=====================");
        String username = (String) principalCollection.getPrimaryPrincipal();
        AdminDao adminDao = (AdminDao) SpringContextUtil.getBean(AdminDao.class);
        Admin admin = adminDao.selectAdmin(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roles = admin.getRoles();
        for (Role role : roles) {
            simpleAuthorizationInfo.addRole(role.getRoleName());
            List<Authority> authorities = role.getAuthorities();
            for (Authority authority : authorities) {
                simpleAuthorizationInfo.addStringPermission(authority.getAuthorityName());
            }
        }

        return simpleAuthorizationInfo;
    }





 */



}


