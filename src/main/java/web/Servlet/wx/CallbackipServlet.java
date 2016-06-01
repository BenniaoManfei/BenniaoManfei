package web.Servlet.wx;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.wx.WxService;
import service.wx.impl.WxServiceImpl;

/**
 * Servlet implementation class CallbackipServlet
 */
public class CallbackipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---------获取微信服务器地址 start---------------");
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		WxService wxService = new WxServiceImpl();
		String[] ips = wxService.getCallbackip();
		
		if(ips == null){
			System.out.println("---------获取微信服务器地址 end---------------");
			response.getWriter().write("获取微信服务器地址失败:\n");
		}else {
			System.out.println("---------获取微信服务器地址 end---------------");
			System.out.println("ips:\n"+ips+"\n");
			response.getWriter().write("ips:\n"+ips);
		}
		
	}

}
