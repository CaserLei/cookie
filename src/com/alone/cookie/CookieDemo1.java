package com.alone.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第一个cookie程序
 * @author Administrator
 *
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.创建Cookie对象
		Cookie cookie1=new Cookie("name","eric");
		Cookie cookie2=new Cookie("email","2234@qq.com");
		
		
		
		/**
		 * 1）设置cookie的有效路径。默认情况：有效路径在当前web应用下  /day11
		 */
		cookie1.setPath("/day11");
		cookie2.setPath("/day12");
		
		cookie1.setMaxAge(0);
		
		//2.把Cookie数据发送到浏览器（通过相应头-set-cookie名称）
		//response.setHeader("set-cookie", "name=eric");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		/*String name=request.getHeader("cookie");
		System.out.println(name);*/
		
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for (Cookie c: cookies) {
				String name=c.getName();
				String value=c.getValue();
				System.out.println(name+"="+value);
			}
		}else{
			System.out.println("没有接受到cookie");
		}
	}

}
