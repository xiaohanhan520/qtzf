package com.xh.shiro;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

import java.util.Map;

@Configuration
@Slf4j
public class ShiroFilterConf {
    /**
     *ShiroFilterFactoryBean 处理拦截资源文件问题。
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager){
        //必须设置 SecurityManager
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String,String> map = new HashMap<>();
        map.put("/**","authc");
        map.put("/admin/**","anon");
        map.put("/jqGrid/**","anon");
        map.put("/jquery/**","anon");
        map.put("/bootstrap/**","anon");
        map.put("/img/**","anon");
        map.put("/manage/manage_login.jsp","anon");
        map.put("/index.jsp","anon");
        map.put("/tool/**","anon");
        map.put("/login","anon");
        map.put("/out","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/manage_login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/index.jsp");
        log.info("shiro开启成功");
        return shiroFilterFactoryBean;
    }


    @Bean
    public SecurityManager getSecurityManager(MyRealm myRealm, CacheManager cacheManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        defaultWebSecurityManager.setCacheManager(cacheManager);
        return defaultWebSecurityManager;
    }


    @Bean
    public MyRealm getMyRealm(CredentialsMatcher credentialsMatcher){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }


    @Bean
    public CredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
    @Bean
    public CacheManager getCacheManager(){
        return new EhCacheManager();
    }
}

