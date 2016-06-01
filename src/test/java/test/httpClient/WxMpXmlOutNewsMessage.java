package test.httpClient;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import common.constant.WxConstants;
import common.util.xml.XStreamCDataConverter;
import common.util.xml.XStreamInitializer;

@XStreamAlias("xml")
public class WxMpXmlOutNewsMessage extends WxMpXmlOutMessage {

	@XStreamAlias("ArticleCount")
	protected int articleCount;

	@XStreamAlias("Articles")
	protected final List<Item> articles = new ArrayList<Item>();

	public WxMpXmlOutNewsMessage() {
		this.msgType = WxConstants.MSG_NEWS_RESPONSE;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public void addArticle(Item item) {
		this.articles.add(item);
		this.articleCount = this.articles.size();
	}

	public List<Item> getArticles() {
		return articles;
	}

	@XStreamAlias("item")
	public static class Item {

		@XStreamAlias("Title")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String title;

		@XStreamAlias("Description")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String description;

		@XStreamAlias("PicUrl")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String picUrl;

		@XStreamAlias("Url")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String url;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}

	@Override
	public String toXML() {
		XStream xstream = XStreamInitializer.getInstance();
		xstream.processAnnotations(WxMpXmlOutMessage.class);
		xstream.processAnnotations(WxMpXmlOutNewsMessage.class);
		xstream.processAnnotations(Item.class);
		return xstream.toXML(this);
	}
	public static void main(String[] args) {
		WxMpXmlOutNewsMessage news = new WxMpXmlOutNewsMessage() ;
		news.setFromUserName("fromsfsd");
		news.setToUserName("touserOpenid");
		news.setCreateTime(System.currentTimeMillis());
		
		Item item1 = new Item();
		item1.setUrl("www.baidu.com");
		item1.setTitle("百度LOGO");
		item1.setDescription("点击图片试试?");
		item1.setPicUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
		Item item2 = new Item();
		item2.setUrl("www.baidu.com");
		item2.setTitle("百度LOGO");
		item2.setDescription("点击图片试试?");
		item2.setPicUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
		news.getArticles().add(item1);
		news.getArticles().add(item2);
		news.setArticleCount(news.getArticles().size());
		
		System.out.println(news.toXML());
	}
}
