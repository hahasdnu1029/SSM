package com.sdnu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {
	/**
	 * 处理器执行后，且返回了结果视图执行该方法
	 * 作用：记录登录日志，登录ip等信息
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("在处理器之后，结果视图返回后执行==============");
	}
	/**
	 * 处理器执行后还没有返回结果视图时执行
	 * 作用：可以在返回用户前对模型数据进行加工，比如加入公司信息等
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("在处理器之后，结果视图未返回之前执行==============");

	}
	/**
	 * 在处理器执行前调用此方法
	 * 作用：做登录校验、权限拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("在处理器之前执行==============");
		return true;
	}

}
