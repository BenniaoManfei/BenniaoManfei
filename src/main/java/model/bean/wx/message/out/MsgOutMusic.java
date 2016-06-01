package model.bean.wx.message.out;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import common.constant.WxConstants;
import common.util.xml.XStreamCDataConverter;
import common.util.xml.XStreamInitializer;

@XStreamAlias("xml")
public class MsgOutMusic extends MsgOut {

	private static final long serialVersionUID = 4243077226153919757L;

	@XStreamAlias("Music")
	protected final Music music = new Music();

	public MsgOutMusic() {
		this.msgType = WxConstants.MSG_MUSIC_RESPONSE;
	}

	public String getTitle() {
		return music.getTitle();
	}

	public void setTitle(String title) {
		music.setTitle(title);
	}

	public String getDescription() {
		return music.getDescription();
	}

	public void setDescription(String description) {
		music.setDescription(description);
	}

	public String getThumbMediaId() {
		return music.getThumbMediaId();
	}

	public void setThumbMediaId(String thumbMediaId) {
		music.setThumbMediaId(thumbMediaId);
	}

	public String getMusicUrl() {
		return music.getMusicUrl();
	}

	public void setMusicUrl(String musicUrl) {
		music.setMusicUrl(musicUrl);
	}

	public String getHqMusicUrl() {
		return music.getHqMusicUrl();
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		music.setHqMusicUrl(hqMusicUrl);
	}

	@XStreamAlias("Music")
	public static class Music {

		@XStreamAlias("Title")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String title;

		@XStreamAlias("Description")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String description;

		@XStreamAlias("MusicUrl")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String musicUrl;

		@XStreamAlias("HqMusicUrl")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String hqMusicUrl;

		@XStreamAlias("ThumbMediaId")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String thumbMediaId;

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

		public String getThumbMediaId() {
			return thumbMediaId;
		}

		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}

		public String getMusicUrl() {
			return musicUrl;
		}

		public void setMusicUrl(String musicUrl) {
			this.musicUrl = musicUrl;
		}

		public String getHqMusicUrl() {
			return hqMusicUrl;
		}

		public void setHqMusicUrl(String hqMusicUrl) {
			this.hqMusicUrl = hqMusicUrl;
		}

	}

	@Override
	public String toXML() {
		XStream xstream = XStreamInitializer.getInstance();
		xstream.processAnnotations(MsgOut.class);
		xstream.processAnnotations(MsgOutMusic.class);
		xstream.processAnnotations(Music.class);
		return xstream.toXML(this);
	}
	
	public static void main(String[] args) {
		MsgOutMusic text = new MsgOutMusic() ;
		text.setFromUserName("fromsfsd");
		text.setToUserName("touserOpenid");
		text.setCreateTime(System.currentTimeMillis());
		
		text.setTitle("回复音乐消息");
		text.setDescription("音乐小细OA酸辣粉了");
		text.setMusicUrl("低品质音乐url");
		text.setHqMusicUrl("高品质音乐url,wifi环境优先使用");
		text.setThumbMediaId("缩略图mediaID");
		
		System.out.println(text.toXML());
	}

}
