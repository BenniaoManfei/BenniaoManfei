package model.bean.wx;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import model.bean.wx.MaterialNews.MaterialNewsArticle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 图文类型素材
 *
 * @description
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月29日
 */
public class MaterialNews implements Serializable {

	private static final long serialVersionUID = -5628681067657937490L;

	public static final GsonBuilder INSTANCE = new GsonBuilder();
	static{
		INSTANCE.disableHtmlEscaping();
		INSTANCE.registerTypeAdapter(MaterialNews.class, new MaterialNewsGsonAdapter());
		INSTANCE.registerTypeAdapter(MaterialNews.MaterialNewsArticle.class, new MaterialNewsArticleGsonAdapter());
	}
	
	public List<MaterialNewsArticle> articles = new ArrayList<MaterialNewsArticle>();

	public void addMaterialNewsArticle(MaterialNewsArticle materialNewsArticle) {
		articles.add(materialNewsArticle);
	}

	public List<MaterialNewsArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<MaterialNewsArticle> articles) {
		this.articles = articles;
	}

	public String toJSONString(){
		return create().toJson(this);
	}
	/**
	 * <pre>
	 * 群发图文消息article
	 * 1. thumbMediaId  (必填) 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
	 * 2. author          图文消息的作者
	 * 3. title           (必填) 图文消息的标题
	 * 4. contentSourceUrl 在图文消息页面点击“阅读原文”后的页面链接
	 * 5. content (必填)  图文消息页面的内容，支持HTML标签
	 * 6. digest          图文消息的描述
	 * 7. showCoverPic  是否显示封面，true为显示，false为不显示
	 * 8. url           点击图文消息跳转链接
	 * </pre>
	 *
	 * @author chanjarster
	 */
	public static class MaterialNewsArticle {
		/**
		 * (必填) 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
		 */
		private String thumbMediaId;
		/**
		 * 图文消息的作者
		 */
		private String author;
		/**
		 * (必填) 图文消息的标题
		 */
		private String title;
		/**
		 * 在图文消息页面点击“阅读原文”后的页面链接
		 */
		private String contentSourceUrl;
		/**
		 * (必填) 图文消息页面的内容，支持HTML标签
		 */
		private String content;
		/**
		 * 图文消息的描述
		 */
		private String digest;
		/**
		 * 是否显示封面，true为显示，false为不显示
		 */
		private boolean showCoverPic;

		public String getThumbMediaId() {
			return thumbMediaId;
		}

		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContentSourceUrl() {
			return contentSourceUrl;
		}

		public void setContentSourceUrl(String contentSourceUrl) {
			this.contentSourceUrl = contentSourceUrl;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getDigest() {
			return digest;
		}

		public void setDigest(String digest) {
			this.digest = digest;
		}

		public boolean isShowCoverPic() {
			return showCoverPic;
		}

		public void setShowCoverPic(boolean showCoverPic) {
			this.showCoverPic = showCoverPic;
		}

		@Override
		public String toString() {
			return "WxMpMassNewsArticle [" + "thumbMediaId=" + thumbMediaId
					+ ", author=" + author + ", title=" + title
					+ ", contentSourceUrl=" + contentSourceUrl + ", content="
					+ content + ", digest=" + digest + ", showCoverPic="
					+ showCoverPic + ", url=" + "]";
		}
		
	}
	public static Gson create() {
	    return INSTANCE.create();
	  }
}

class MaterialNewsGsonAdapter implements JsonSerializer<MaterialNews>,
		JsonDeserializer<MaterialNews> {

	public JsonElement serialize(MaterialNews wxMpMaterialNews, Type typeOfSrc,
			JsonSerializationContext context) {
		JsonObject newsJson = new JsonObject();

		JsonArray articleJsonArray = new JsonArray();
		for (MaterialNews.MaterialNewsArticle article : wxMpMaterialNews.getArticles()) {
			JsonObject articleJson = MaterialNews.create().toJsonTree(article,MaterialNews.MaterialNewsArticle.class).getAsJsonObject();
			
			articleJsonArray.add(articleJson);
		} 
		newsJson.add("articles", articleJsonArray);

		return newsJson;
	}

	@Override
	public MaterialNews deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		// TODO Auto-generated method stub
		return null;
	}

}

class MaterialNewsArticleGsonAdapter implements JsonSerializer<MaterialNews.MaterialNewsArticle>, JsonDeserializer<MaterialNews.MaterialNewsArticle> {

	public JsonElement serialize(MaterialNews.MaterialNewsArticle article,
			Type typeOfSrc, JsonSerializationContext context) {
		JsonObject articleJson = new JsonObject();

		articleJson.addProperty("thumb_media_id", article.getThumbMediaId());
		articleJson.addProperty("title", article.getTitle());
		articleJson.addProperty("content", article.getContent());
		if (null != article.getAuthor()) {
			articleJson.addProperty("author", article.getAuthor());
		}
		if (null != article.getContentSourceUrl()) {
			articleJson.addProperty("content_source_url",
					article.getContentSourceUrl());
		}
		if (null != article.getDigest()) {
			articleJson.addProperty("digest", article.getDigest());
		}
		articleJson.addProperty("show_cover_pic", article.isShowCoverPic() ? "1" : "0");
		return articleJson;
	}

	@Override
	public MaterialNewsArticle deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
