package model.bean.wx.message.out;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import common.constant.WxConstants;
import common.util.xml.XStreamCDataConverter;
import common.util.xml.XStreamInitializer;

/**
 * 回复消息:视频消息
 *
 * @description
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月25日
 */
@XStreamAlias("xml")
public class MsgOutVideo extends MsgOut {

	private static final long serialVersionUID = 5807433916799185575L;

	@XStreamAlias("Video")
	protected final Video video = new Video();

	public MsgOutVideo() {
		this.msgType = WxConstants.MSG_VIDEO;
	}

	public String getMediaId() {
		return video.getMediaId();
	}

	public void setMediaId(String mediaId) {
		video.setMediaId(mediaId);
	}

	public String getTitle() {
		return video.getTitle();
	}

	public void setTitle(String title) {
		video.setTitle(title);
	}

	public String getDescription() {
		return video.getDescription();
	}

	public void setDescription(String description) {
		video.setDescription(description);
	}

	@XStreamAlias("Video")
	public static class Video {

		@XStreamAlias("MediaId")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String mediaId;

		@XStreamAlias("Title")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String title;

		@XStreamAlias("Description")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String description;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

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
	}

	@Override
	public String toXML() {
		XStream xstream = XStreamInitializer.getInstance();
	    xstream.processAnnotations(MsgOut.class);
	    xstream.processAnnotations(MsgOutVideo.class);
	    xstream.processAnnotations(Video.class);
	    return xstream.toXML(this);
	}

	public static void main(String[] args) {
		MsgOutVideo text = new MsgOutVideo() ;
		text.setFromUserName("fromsfsd");
		text.setToUserName("touserOpenid");
		text.setCreateTime(System.currentTimeMillis());
		
		text.setMediaId("sfsdfsdfmediaId");
		text.setTitle("视频标题");
		text.setDescription("视频视频视频");
		
		System.out.println(text.toXML());
	}
	
}
