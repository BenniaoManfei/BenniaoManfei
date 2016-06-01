package web.Servlet.wx;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.wx.MaterialNews;
import model.bean.wx.MaterialNews.MaterialNewsArticle;
import service.wx.MaterialService;
import service.wx.impl.MaterialServiceImpl;
import ResultInfo.ResultInfo;

public class UploadMaterialNewsServlet extends HttpServlet {

	private static final long serialVersionUID = 2200035385569880131L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("\n---------上传永久图文素材 start---------------\n");
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MaterialService wxService = new MaterialServiceImpl();
		
		MaterialNews news =new MaterialNews();
		
		MaterialNewsArticle article = new MaterialNewsArticle();
		news.addMaterialNewsArticle(article);
		article.setTitle("测试的图文消息");
		article.setThumbMediaId("V0Jifw014GN3YcX-XeAqftcBAeWMo9N9q7dSChblGr0");
		article.setAuthor("戴征淼");
		article.setDigest("消息摘要");
		article.setShowCoverPic(true);
		article.setContent("图文消息具体内容了积分卡咖啡加拉克谁加福禄寿健康福利框架拉升房价");//外部图片连接没有用的
		article.setContentSourceUrl("http://p2p9.ys.xf.cc/information/informationdetail.html?id=45");
		
		ResultInfo<String> flag = wxService.uploadMaterialNews(news);
		System.out.println(flag);
		System.out.println("\n---------上传永久图文素材 end---------------\n");
		response.getWriter().write(flag+"");
	}

	
	
}
