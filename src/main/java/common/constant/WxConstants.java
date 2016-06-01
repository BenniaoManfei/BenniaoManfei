package common.constant;

import java.io.IOException;
import java.util.Properties;

public final class WxConstants {

	public static String TOKEN = null;
	public static String ACCOUNT = null;
	public static String APPID = null;
	public static String APPSECRET = null;

	public static String wxConfProperties = "wxConf.properties";
	static {
		Properties prop = new Properties();
		try {
			prop.load(WxConstants.class.getClassLoader().getResourceAsStream(
					wxConfProperties));
			TOKEN = prop.get("token").toString();
			ACCOUNT = prop.get("account").toString();
			APPID = prop.get("appid").toString();
			APPSECRET = prop.get("appsecret").toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// /////////////////////
	// 微信推送过来的消息的类型，和发送给微信xml格式消息的消息类型
	// /////////////////////
	public static final String MSG_TEXT = "text";
	public static final String MSG_IMAGE = "image";
	public static final String MSG_VOICE = "voice";
	public static final String MSG_VIDEO = "video";
	public static final String MSG_SHORTVIDEO = "shortvideo";
	public static final String MSG_LOCATION = "location";
	public static final String MSG_LINK = "link";
	public static final String MSG_EVENT = "event";

	public static final String MSG_MUSIC_RESPONSE = "music";// 回复音乐消息
	public static final String MSG_NEWS_RESPONSE = "news";// 图文消息

	public static final String EVENT_SUBSCRIBE = "subscribe";// 关注事件(注意区分未关注用户扫码事件)
	public static final String EVENT_UNSUBSCRIBE = "unsubscribe";// 取消关注事件

	public static final String EVENT_SUBSCRIBE_QR = "subscribe";// 未关注用户扫码事件【EventKey不为空】
	public static final String EVENT_SCAN = "SCAN";// 已关注用户扫码事件
	public static final String EVENT_LOCATION = "LOCATION";// 上报地理位置
	public static final String EVENT_CLICK = "CLICK";// 自定义菜单事件:点击菜单拉取消息时的事件推送
	public static final String EVENT_VIEW = "VIEW";// 自定义菜单事件:点击菜单跳转链接时的事件推送
	
	public static final String MATERIAL_IMAGE = "image";
	public static final String MATERIAL_VOICE = "voice";
	public static final String MATERIAL_VIDEO = "video";
	public static final String MATERIAL_THUMB = "thumb";

}
