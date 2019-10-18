package com.xh.service.serviceImpl;

import com.xh.dao.UserDao;
import com.xh.entity.User;
import com.xh.service.UserService;
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

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



    @Override
    public Map<String, Object> queryUserLogin(User user) {
        HashMap<String, Object> map = new HashMap<>();
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory();
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
      //  DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);
            map.put("code",200);
            return map;
        }catch (UnknownAccountException e){
            map.put("code",303);
            map.put("message","用户不存在");
            return map;
        }catch (IncorrectCredentialsException e){
            map.put("code",304);
            map.put("message","密码错误");
            return map;
        }
    }

    @Override
    public void userOut() {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory();
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @Override
    public void registerUser(User user) {
        String uuid = UUID.randomUUID().toString();
        SimpleHash md5 = new SimpleHash("MD5", user.getPassword(), uuid, 1024);
    }
}
