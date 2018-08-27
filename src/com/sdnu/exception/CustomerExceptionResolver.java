package com.sdnu.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//打印下错误的堆栈信息 
		ex.printStackTrace();
		CustomerException customerException=null;
		//如果是自定义异常直接转换
		if(ex instanceof CustomerException){
			customerException = (CustomerException) ex;
		}else{
			customerException=new CustomerException("系统错误，请尽快与系统管理员联系！");
		}
		//封装错误信息，设置响应视图
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message", customerException.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
