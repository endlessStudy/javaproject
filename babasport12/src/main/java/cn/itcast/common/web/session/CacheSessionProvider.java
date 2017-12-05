package cn.itcast.common.web.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.danga.MemCached.MemCachedClient;

/**
 * 远程Session
 * 存放在Memcached缓存服务器里的Session
 * @author lx
 *
 */
public class CacheSessionProvider implements SessionProvider{

	@Autowired
	private MemCachedClient memCachedClient;
	
	private int expiry = 30;//分钟
	
	private static final String  JSESSIONID = "JSESSIONID";
	
	//放值
	@Override
	public void setAttribute(HttpServletRequest request,HttpServletResponse response, String name,
			Serializable value) {
/*		HttpSession session = request.getSession();//true    Cookie JSESSIONID
		session.setAttribute(name, value);  */
			  //本地有一份 
		     //另一份Memcached
		Map<String,Serializable> session = new HashMap<String,Serializable>();
		session.put(name, value);
		//保存远程了
		memCachedClient.set(getSessionId(request,response), session, expiry*60);
	}

	//取值
	@SuppressWarnings("unchecked")
	@Override
	public Serializable getAttribute(HttpServletRequest request,HttpServletResponse response, String name) {
		Map<String,Serializable> session = (Map<String, Serializable>) memCachedClient.get(getSessionId(request,response));
		if(null != session){
			return session.get(name);
		}
		return null;
	}

	@Override
	public void logout(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(memCachedClient.keyExists(getSessionId(request, response))){
			memCachedClient.delete(getSessionId(request, response));
		}
		//清理Cookie
		
	}

	@Override
	public String getSessionId(HttpServletRequest request,HttpServletResponse response) {
		//所有的Cookie
		Cookie[] cookies = request.getCookies();
		if(null != cookies && cookies.length > 0){
			for(Cookie c : cookies){
				if(JSESSIONID.equals(c.getName())){
					return c.getValue();
				}
			}
		}
		//生成一个
		String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
		Cookie cookie = new Cookie(JSESSIONID,sessionId);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		return sessionId;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	

}
