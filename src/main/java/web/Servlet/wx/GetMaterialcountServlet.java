package web.Servlet.wx;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.wx.MaterialService;
import service.wx.impl.MaterialServiceImpl;
import ResultInfo.ResultInfo;

public class GetMaterialcountServlet extends HttpServlet {

	private static final long serialVersionUID = 4687619169726938453L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		System.out.println("\n---------获取永久素材 start---------------\n");
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MaterialService wxService = new MaterialServiceImpl();
		
		ResultInfo<Map<String, Integer>> flag = wxService.getMaterialcount();
		System.out.println(flag);
		System.out.println("\n---------获取永久素材 end---------------\n");
		response.getWriter().write(flag+"");
	}

	
	
}
