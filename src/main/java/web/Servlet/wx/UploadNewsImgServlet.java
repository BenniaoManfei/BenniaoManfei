package web.Servlet.wx;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.wx.MaterialService;
import service.wx.impl.MaterialServiceImpl;
import ResultInfo.ResultInfo;

public class UploadNewsImgServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454276791226772541L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("\n---------上传图文图片到微信 start---------------\n");
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MaterialService wxService = new MaterialServiceImpl();
		
		File file = new File("F://http-404.png");
		
		ResultInfo<String> flag = wxService.uploadNewsImg(file);
		request.setAttribute("newImg", flag.obj);
		System.out.println(flag);
		System.out.println("\n---------上上传图文图片到微信 end---------------\n");
		
		request.getRequestDispatcher("news.jsp");
		
	}

}
