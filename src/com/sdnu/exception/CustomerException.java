package com.sdnu.exception;

/**
 * 客户信息异常
 * @author yangpengyu
 *
 */
public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3993209659094728479L;

	private String message;
	//有参构造方法
	public CustomerException(String message){
		super(message);
		this.message=message;
	}
	//无参构造
	public CustomerException(){
		super();
	}
	//设置错误信息
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
