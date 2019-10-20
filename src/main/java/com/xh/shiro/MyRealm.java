package com.xh.shiro;


import com.xh.dao.UserDao;
import com.xh.entity.User;
import com.xh.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.hibernate.validator.constraints.EAN;

import java.util.List;


@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UserDao userDao = (UserDao) SpringContextUtil.getBean(UserDao.class);
        log.info("开始身份认证");
        //获取用户名
        String username = (String) authenticationToken.getPrincipal();
        log.info("用户名为："+username);
        User user = userDao.selectByUsername(username);
        if (user == null){
            log.info("登录失败");
            return null;
        }else{
            log.info("登录成功");
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes(user.getSale()),this.getName());
            return simpleAuthenticationInfo;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("开始授权");
        //获取用户名
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        log.info("用户名为："+primaryPrincipal);
        //获取Dao层
        UserDao userDao = (UserDao) SpringContextUtil.getBean(UserDao.class);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
      /*
       List<Role> roles = user.getRoles();
        for (Role role : roles) {
            simpleAuthorizationInfo.addRole(role.getRoleName());
            List<Authority> authorities = role.getAuthorities();
            for (Authority authority : authorities) {
                simpleAuthorizationInfo.addStringPermission(authority.getAuthorityName());
            }
        }
        */


        return simpleAuthorizationInfo;
    }




}


