package model.bean.wx.message.in;


import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 用户消息(包括用户的操作)
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月25日
 */
@XStreamAlias("xml")
public class MsgIn implements Serializable {

	private static final long serialVersionUID = -3389475731102879040L;

	/** 消息类型 */
	private String msgType;
	
	/** 消息id，64位整型 */
	private String msgId;
	
	/** 发送消息的用户OpenId */
	private String fromUserName;//openid
	
	/** 接收消息的OpenId(这里肯定是公众号的openid) */
	private String toUserName;
	
	/** 发送消息的时间 */
	private String createTime;
	
	/** 普通消息 -文本消息(text:content):文本内容 */
	private String content;
	
	
	/** 普通消息 -图片消息(image:picUrl,mediaId):图片的URL地址 */
	private String picUrl;
	
	/** 普通消息 -图片消息(image:picUrl,mediaId):媒体id，可以调用多媒体文件下载接口拉取数据。 */
	private String mediaId;
	
	
	/** 普通消息 -语音消息(voice:MediaId,Format):语音格式，如amr，speex等 */
	private String format;
	
	/** 普通消息 -视频消息(video:MediaId,ThumbMediaId):视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。 */
	private String thumbMediaId;
	
	/** 普通消息 -小视频消息(shortvideo:MediaId,ThumbMediaId)。 */
	
	/** 普通消息 -地理位置消息(location:Location_X,Location_Y,Scale,Label):地理位置纬度。 */
	private String locationX;

	/** 普通消息 -地理位置消息(location:Location_X,Location_Y,Scale,Label):地理位置经度。 */
	private String locationY;

	/** 普通消息 -地理位置消息(location:Location_X,Location_Y,Scale,Label):地图缩放大小。 */
	private String scale;
	
	/** 普通消息 -地理位置消息(location:Location_X,Location_Y,Scale,Label):地理位置信息。 */
	private String label;
	
	/** 普通消息 -连接消息(link:title,Description,Url):消息标题。 */
	private String title;
	
	/** 普通消息 -连接消息(link:title,Description,Url):消息描述。 */
	private String url;
	
	/** 普通消息 -连接消息(link:title,Description,Url):消息链接。 */
	private String description;
	
	/** 事件类型 */
	private String event;
	
	/** 事件KEY值 */
	private String eventKey;
	
	/** 二维码的ticket，可用来换取二维码图片 */
	private String ticket;
	
	/** 地理位置纬度:Location_X */
	private Double latitude;

	/** 地理位置经度:Location_Y */
	private Double longitude;
	
	/** 地理位置精度 */
	private Double precision;


	public String getMsgType() {
		return msgType;
	}

	public String getMsgId() {
		return msgId;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public String getToUserName() {
		return toUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public String getContent() {
		return content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public String getFormat() {
		return format;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public String getLocationX() {
		return locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public String getScale() {
		return scale;
	}

	public String getLabel() {
		return label;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public String getEvent() {
		return event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getPrecision() {
		return precision;
	}


	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setPrecision(Double precision) {
		this.precision = precision;
	}

	@Override
	public String toString() {
		return "MsgIn [msgType=" + msgType + ", msgId=" + msgId
				+ ", fromUserName=" + fromUserName + ", toUserName="
				+ toUserName + ", createTime=" + createTime + ", content="
				+ content + ", picUrl=" + picUrl + ", mediaId=" + mediaId
				+ ", format=" + format + ", thumbMediaId=" + thumbMediaId
				+ ", locationX=" + locationX + ", locationY=" + locationY
				+ ", scale=" + scale + ", label=" + label + ", title=" + title
				+ ", url=" + url + ", description=" + description + ", event="
				+ event + ", eventKey=" + eventKey + "]";
	}
	
}
