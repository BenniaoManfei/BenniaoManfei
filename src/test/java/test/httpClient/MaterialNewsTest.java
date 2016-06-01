package test.httpClient;

import model.bean.wx.MaterialNews;
import model.bean.wx.MaterialNews.MaterialNewsArticle;

import org.junit.Before;
import org.junit.Test;

public class MaterialNewsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		MaterialNews news =new MaterialNews();
		
		MaterialNewsArticle article = new MaterialNewsArticle();
		news.addMaterialNewsArticle(article);
		article.setTitle("测试的图文消息");
		article.setThumbMediaId("THUMB_MEDIA_ID");
		article.setAuthor("戴征淼");
		article.setDigest("消息摘要");
		article.setShowCoverPic(true);
		article.setContent("图文消息具体内容");//外部图片连接没有用的
		article.setContentSourceUrl("http://www.baidu.com");
		
		System.out.println(news.toJSONString());
	}

}
