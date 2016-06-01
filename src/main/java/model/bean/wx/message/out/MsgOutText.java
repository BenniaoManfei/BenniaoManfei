package model.bean.wx.message.out;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import common.constant.WxConstants;
import common.util.xml.XStreamCDataConverter;
import common.util.xml.XStreamInitializer;

/**
 * 回复消息:文本消息
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月25日
 */
@XStreamAlias("xml")
public class MsgOutText extends MsgOut {

	private static final long serialVersionUID = 9090503842429271548L;
	
	@XStreamAlias("Content")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String content;

	public MsgOutText() {
		this.msgType = WxConstants.MSG_TEXT;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toXML() {
		XStream xstream = XStreamInitializer.getInstance();
	    xstream.processAnnotations(MsgOut.class);
	    xstream.processAnnotations(MsgOutText.class);
	    return xstream.toXML(this);
	}

	public static void main(String[] args) {
		MsgOutText text = new MsgOutText() ;
		text.setFromUserName("fromsfsd");
		text.setToUserName("touserOpenid");
		text.setCreateTime(System.currentTimeMillis());
		text.setContent("消息徐啥地方了圣诞节饭手动连接");
		
		System.out.println(text.toXML());
	}
}
