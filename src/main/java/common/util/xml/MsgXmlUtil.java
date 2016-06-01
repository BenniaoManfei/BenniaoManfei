package common.util.xml;

import java.io.InputStream;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.bean.wx.message.in.MsgIn;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * xml 消息处理工具类
 * 
 */

@SuppressWarnings("unchecked")
public class MsgXmlUtil {

	//将request 消息 转换成 请求消息对象
	public static MsgIn parseXml(HttpServletRequest request) throws Exception {
		MsgIn msgReq = new MsgIn();
		
		// 解析XML
		InputStream inputStream = request.getInputStream();
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		
		// 遍历节点，封装成对象
		for (Element e : elementList) {
			String name = e.getName();
			String text = e.getText();
			
			if ("MsgType".equals(name)) {// 消息类型
				msgReq.setMsgType(text);
			} else if ("MsgId".equals(name)) {
				msgReq.setMsgId(text);
			} else if ("FromUserName".equals(name)) {
				msgReq.setFromUserName(text);
			} else if ("ToUserName".equals(name)) {
				msgReq.setToUserName(text);
			} else if ("CreateTime".equals(name)) {
				msgReq.setCreateTime(text);
			} else if ("Content".equals(name)) {// 文本消息
				msgReq.setContent(text);
			} else if ("PicUrl".equals(name)) {// 图片消息
				msgReq.setPicUrl(text);
			} else if ("MediaId".equals(name)) {// 图片消息
				msgReq.setMediaId(text);
			} else if ("Format".equals(name)) {// 图片消息
				msgReq.setFormat(text);
			} else if ("ThumbMediaId".equals(name)) {// 图片消息
				msgReq.setThumbMediaId(text);
			} else if ("Location_X".equals(name)) {// 地理位置消息
				msgReq.setLocationX(text);
			} else if ("Location_Y".equals(name)) {
				msgReq.setLocationY(text);
			} else if ("Scale".equals(name)) {
				msgReq.setScale(text);
			} else if ("Label".equals(name)) {
				msgReq.setLabel(text);
			} else if ("Event".equals(name)) {// 事件消息
				msgReq.setEvent(text);
			} else if ("EventKey".equals(name)) {
				msgReq.setEventKey(text);
			}
		}
		inputStream.close();
		inputStream = null;
		return msgReq;
	}
	
	
	
	/**
	 * 扩展xstream，让xml节点增加CDATA标记
	 */
	public static XStream xstream = new XStream();
	
}
