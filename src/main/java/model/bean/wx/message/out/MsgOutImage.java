package model.bean.wx.message.out;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import common.constant.WxConstants;
import common.util.xml.XStreamCDataConverter;
import common.util.xml.XStreamInitializer;

/**
 * 回复消息:图片消息
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月25日
 */
@XStreamAlias("xml")
public class MsgOutImage extends MsgOut {


	private static final long serialVersionUID = -4247762290743914005L;
	
	@XStreamAlias("MediaId")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public MsgOutImage() {
		this.msgType = WxConstants.MSG_IMAGE;
	}

	@Override
	public String toXML() {
		XStream xstream = XStreamInitializer.getInstance();  
		xstream.processAnnotations(MsgOut.class);
		xstream.processAnnotations(MsgOutImage.class);
		return xstream.toXML(this);
	}

	
	public static void main(String[] args) {
		MsgOutImage image = new MsgOutImage() ;
		image.setFromUserName("fromsfsd");
		image.setToUserName("touserOpenid");
		image.setCreateTime(System.currentTimeMillis());
		image.setMediaId("aIl9-eU7rmNc35A6Og4AfrZYpxGOgeNWvQGJPNaloQ9yvR8FbSSdpuaZz6JVlOP9");
		
		System.out.println(image.toXML());
	}
}
