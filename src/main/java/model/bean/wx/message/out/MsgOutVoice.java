package model.bean.wx.message.out;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import common.constant.WxConstants;
import common.util.xml.XStreamInitializer;
import common.util.xml.XStreamMediaIdConverter;

/**
 * 回复消息:语音消息
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月25日
 */
@XStreamAlias("xml")
public class MsgOutVoice extends MsgOut {

	private static final long serialVersionUID = 2566096368640560951L;

	@XStreamAlias("Voice")
	@XStreamConverter(value=XStreamMediaIdConverter.class)
	private String mediaId;

	public MsgOutVoice() {
		this.msgType = WxConstants.MSG_VOICE;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toXML() {
		XStream xstream = XStreamInitializer.getInstance();
	    xstream.processAnnotations(MsgOut.class);
	    xstream.processAnnotations(MsgOutVoice.class);
	    return xstream.toXML(this);
	}

	public static void main(String[] args) {
		MsgOutVoice text = new MsgOutVoice() ;
		text.setFromUserName("fromsfsd");
		text.setToUserName("touserOpenid");
		text.setCreateTime(System.currentTimeMillis());
		
		text.setMediaId("sfsdfsdfmediaId");
		
		System.out.println(text.toXML());
	}
	


}
