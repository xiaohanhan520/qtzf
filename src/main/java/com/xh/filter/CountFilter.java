package com.xh.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听上线多少人
 */
@WebListener
@Slf4j
public class CountFilter implements HttpSessionListener {

    static int count=0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        count++;
        se.getSession().getServletContext().setAttribute("count", count);
        log.info("");
    }
    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        count--;
        se.getSession().getServletContext().setAttribute("count", count);
        log.info("count--  减少");
    }
}
