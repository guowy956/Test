package com.cn.filter;

import com.cn.model.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 管理当前当前登录对象
 * @author lance
 * 2014-06-14
 */
public class CurrentUserUtils {
	private final String CUR_USER = "api";
	public static CurrentUserUtils INSTANCE = null;
	
	private CurrentUserUtils(){

	}
	
	/**
	 * 获取实例
	 * @return
	 */
	public static CurrentUserUtils getInstance(){
		if(INSTANCE == null){
			synchronized (CurrentUserUtils.class) {
				if(INSTANCE == null) {
					INSTANCE = new CurrentUserUtils();
				}
			}
		}
		
		return INSTANCE;
	}
	/**
	 * 获取当前Request
	 * @return
	 */
	private HttpServletRequest getRequest() {  
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();  
        return requestAttributes.getRequest();  
    } 
	
	/**
	 * 获取当前Session
	 * @return
	 */
	private HttpSession getSession() {  
        return getRequest().getSession(true);  
    }
	
	/**
	 * 获取当前session里面放置的User对象
	 * @return
	 */
	public User getUser(){
		return (User)getSession().getAttribute(CUR_USER);
	}

	public Object getUser(String key){
		return getSession().getAttribute(key);
	}

	public Map<String,Object> getMapUser(){
		return (Map<String, Object>) getSession().getAttribute(CUR_USER);
	}

	
	/**
	 * 把当前User对象放置到session里面
	 * @param user
	 */
	public void setUser(User user){
		getSession().setAttribute(CUR_USER, user);
	}

	public void setUser(Map<String,Object> map){
		getSession().setAttribute(CUR_USER, map);
		getSession().setMaxInactiveInterval(900);
	}

	public void setUser(String keyName,String key){
		getSession().setAttribute(keyName, key);
		getSession().setMaxInactiveInterval(900);
	}

	public void delUser() {
		getSession().removeAttribute(CUR_USER);
	}
}
