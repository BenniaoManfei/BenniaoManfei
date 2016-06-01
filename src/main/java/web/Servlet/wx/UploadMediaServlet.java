package web.Servlet.wx;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.wx.MaterialService;
import service.wx.impl.MaterialServiceImpl;
import ResultInfo.ResultInfo;

import common.constant.WxConstants;

public class UploadMediaServlet extends HttpServlet {

	private static final long serialVersionUID = 926177144796182882L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("\n---------上传临时素材 start---------------\n");
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MaterialService wxService = new MaterialServiceImpl();
		
		File file = new File("F://img3.png");
		
		ResultInfo<Map<String, Object>> flag = wxService.uploadMedia(file, WxConstants.MATERIAL_THUMB);
		System.out.println(flag);
		System.out.println("\n---------上传临时素材 end---------------\n");
		response.getWriter().write(flag+"");
	}

	
}
