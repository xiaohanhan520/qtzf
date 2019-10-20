/*
package com.xh.redis;

import com.xh.utils.SerializeUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

*/

/**
 * 缓存配置类
 */

/*

@Configuration
@Aspect
public class RedisCache {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Around("execution(* com.xh.service.serviceImpl.*.query*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取实现类作为id
        String id = proceedingJoinPoint.getTarget().getClass().getName();
        //获取方法名
        String name = proceedingJoinPoint.getSignature().getName();
        //获取参数
        Object[] args = proceedingJoinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        for (int i = 0; i < args.length; i++){
            Object arg = args[i];
            stringBuilder.append(args);
        }
        //参数加方法名做key
        String key = stringBuilder.toString();
        String value = (String) stringRedisTemplate.opsForHash().get(id, key);
        if(value == null){
            //如果取不到值则添加缓存
            Object proceed = proceedingJoinPoint.proceed();
            stringRedisTemplate.opsForHash().put(id,key, SerializeUtils.serialize(proceed));
            return proceed;
        }else {
            //取到值返回
            return SerializeUtils.serializeToObject(value);
        }

    }



    @AfterReturning
    //@AfterReturning("execution(* com.xh.service.serviceImpl.*.*(..)) && !execution(* com.xh.service.serviceImpl.*.query*(..))")
    public void after(JoinPoint joinPoint){
        String id = joinPoint.getTarget().getClass().getName();
        stringRedisTemplate.delete(id);
    }

}
*/
