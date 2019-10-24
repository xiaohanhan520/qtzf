package com.xh.service.user.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xh.dao.LoginLogDao;
import com.xh.dao.UserDao;
import com.xh.entity.LoginLog;
import com.xh.entity.User;
import com.xh.service.user.UserService;
import com.xh.utils.IpAddressUtil;
import com.xh.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao logDao;



    @Override
    public Map<String, Object> queryUserLogin(User user, HttpServletRequest servletRequest) {
        HashMap<String, Object> map = new HashMap<>();
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory();
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
      //  DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        //获取uid作为主键
        String uid = Md5Util.getUid();
        LoginLog loginLog = new LoginLog();

        //获取用户的登录ip
        String ipAddress = IpAddressUtil.getIpAddress(servletRequest);
        try {
            subject.login(usernamePasswordToken);
            //用户登录成功
            map.put("code",200);
            log.info("用户登录ip:"+ipAddress);

            //根据用户名更改用户登录时间
            UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
            userUpdateWrapper.set("login_time",new Date()).eq("username",user.getUsername());
            userDao.update(null,userUpdateWrapper);

            //插入用户登录日志
            logDao.insert(loginLog.setId(uid).setLoginName(user.getUsername()).setLoginIp(ipAddress).setStatus("登陆成功").setTime(new Date()));

            return map;
        }catch (UnknownAccountException e){
            //用户不存在
            map.put("code",303);
            map.put("message","用户不存在");
            log.info("登录失败，用户不存在");

            //插入用户登录日志
            logDao.insert(loginLog.setId(uid).setLoginName(user.getUsername()).setLoginIp(ipAddress).setStatus("用户不存在").setTime(new Date()));

            return map;
        }catch (IncorrectCredentialsException e){

            //用户登录失败
            map.put("code",304);
            map.put("message","密码错误");
            log.info("登录失败，密码错误");

            //插入登录日志
            logDao.insert(loginLog.setId(uid).setLoginName(user.getUsername()).setLoginIp(ipAddress).setStatus("密码错误").setTime(new Date()));

            return map;
        }
    }

    @Override
    public void userOut(HttpServletRequest servletRequest) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory();
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        //获取用户名
        String principal = (String) SecurityUtils.getSubject().getPrincipal();

        //插入用户退出日志
        LoginLog loginLog = new LoginLog();
        logDao.insert(loginLog.setId(Md5Util.getUid()).setLoginIp(IpAddressUtil.getIpAddress(servletRequest)).setLoginName(principal).setStatus("退出成功").setTime(new Date()));
        log.info("退出用户:"+principal + "退出时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        //根据用户名更改退出时间
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("username", principal).set("out_time", new Date());
        userDao.update(null, userUpdateWrapper);

        //用户退出
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @Override
    public void registerUser(User user, HttpServletRequest servletRequest) {
        String uid = Md5Util.getUid();
        String sale = Md5Util.getSale();
        SimpleHash md5 = new SimpleHash("MD5", user.getPassword(), uid, 1024);
    }
}
