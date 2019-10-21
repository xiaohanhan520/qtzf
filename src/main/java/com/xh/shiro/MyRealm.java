package com.xh.shiro;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("开始身份认证");
        //获取用户名
        String username = (String) authenticationToken.getPrincipal();
        log.info("用户名为："+username);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        List<User> users = userDao.selectList(userQueryWrapper);
        if (users.get(0) == null){
            return null;
        }else{
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, users.get(0).getPassword(), ByteSource.Util.bytes(users.get(0).getSale()),this.getName());
            return simpleAuthenticationInfo;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("开始授权");
        //获取用户名
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        log.info("用户名为："+primaryPrincipal);


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


