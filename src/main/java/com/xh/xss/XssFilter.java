package com.xh.xss;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * XSS过滤
 *
 *
 */
@WebFilter(urlPatterns = "/*")
@Slf4j
public class XssFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//跨域设置
			if(response instanceof HttpServletResponse){
				HttpServletResponse httpServletResponse=(HttpServletResponse)response;
				//通过在响应 header 中设置 ‘*’ 来允许来自所有域的跨域请求访问。
				httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
				//通过对 Credentials 参数的设置，就可以保持跨域 Ajax 时的 Cookie
				//设置了Allow-Credentials，Allow-Origin就不能为*,需要指明具体的url域
				//httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
				//请求方式
				httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
				//（预检请求）的返回结果（即 Access-Control-Allow-Methods 和Access-Control-Allow-Headers 提供的信息） 可以被缓存多久
				httpServletResponse.setHeader("Access-Control-Max-Age", "86400");
				//首部字段用于预检请求的响应。其指明了实际请求中允许携带的首部字段
				httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
			}
			//sql,xss过滤
			HttpServletRequest httpServletRequest=(HttpServletRequest)request;
			log.info("开始过滤 url:{},ParameterMap:{}",httpServletRequest.getRequestURI(), JSONObject.toJSONString(httpServletRequest.getParameterMap()));
			XssHttpServletRequestWrapper xssHttpServletRequestWrapper=new XssHttpServletRequestWrapper(httpServletRequest);
			chain.doFilter(xssHttpServletRequestWrapper, response);
			log.info("过滤完成..........doFilter url:{},ParameterMap:{}",xssHttpServletRequestWrapper.getRequestURI(), JSONObject.toJSONString(xssHttpServletRequestWrapper.getParameterMap()));


		/*

		String requestURI = req.getRequestURI();
		log.info(requestURI);

		ArrayList<String> list = new ArrayList<>();
		//添加不过滤的url

		for (String url: list) {
			if(requestURI.contains(url)){
				chain.doFilter(request, response);
				return;
			}
		}

		*/

	}

	@Override
	public void destroy() {

	}

	/**
	 * 过滤json类型的
	 * @param builder
	 * @return
	 */
	@Bean
	@Primary
	public ObjectMapper xssObjectMapper(Jackson2ObjectMapperBuilder builder) {
		//解析器
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		//注册xss解析器
		SimpleModule xssModule = new SimpleModule("XssStringJsonSerializer");
		xssModule.addSerializer(new XssStringJsonSerializer());
		objectMapper.registerModule(xssModule);
		//返回
		return objectMapper;
	}

}