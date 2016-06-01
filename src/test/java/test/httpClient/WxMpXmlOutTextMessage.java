package test.httpClient;

import model.bean.wx.message.out.MsgOutText;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import common.constant.WxConstants;
import common.util.xml.XStreamCDataConverter;
import common.util.xml.XStreamInitializer;

@XStreamAlias("xml")
public class WxMpXmlOutTextMessage extends WxMpXmlOutMessage {
  
  @XStreamAlias("Content")
  @XStreamConverter(value=XStreamCDataConverter.class)
  private String content;

  public WxMpXmlOutTextMessage() {
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
	    xstream.processAnnotations(WxMpXmlOutMessage.class);
	    xstream.processAnnotations(WxMpXmlOutTextMessage.class);
	    return xstream.toXML(this);
	}

	public static void main(String[] args) {
		WxMpXmlOutTextMessage text = new WxMpXmlOutTextMessage() ;
		text.setFromUserName("fromsfsd");
		text.setToUserName("touserOpenid");
		text.setCreateTime(System.currentTimeMillis());
		text.setContent("消息徐啥地方了圣诞节饭手动连接");
		
		System.out.println(text.toXML());
	}
}
