package web.Servlet.wx;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.wx.WxAccessToken;
import service.wx.WxService;
import service.wx.impl.WxServiceImpl;

public class TokenServlet extends HttpServlet {

	private static final long serialVersionUID = 3525479094610503041L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---------获取TOKEN start---------------");
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		WxService wxService = new WxServiceImpl();
		WxAccessToken accessToken = wxService.getToken();
		
		if(accessToken == null){
			System.out.println("token获取失败");
			System.out.println("---------获取TOKEN end---------------");
			response.getWriter().write("token获取失败:\n");
		}else {
			System.out.println("---------获取TOKEN end---------------");
			System.out.println("ACCESS_TOKEN:\n"+accessToken.getAccessToken()+"\n");
			response.getWriter().write("token:\n"+accessToken.getAccessToken());
		}
		
	}

}
