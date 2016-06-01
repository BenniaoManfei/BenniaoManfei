package model.bean.wx.message.out;

import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Field;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import common.util.xml.XStreamCDATA;
import common.util.xml.XStreamCDataConverter;

/**
 * 回复消息的父类
 *
 * @description
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月25日
 */

public abstract class MsgOut implements Serializable {

	private static final long serialVersionUID = 858411877358185162L;

	@XStreamAlias("ToUserName")
	@XStreamConverter(value=XStreamCDataConverter.class)
	protected String toUserName;

	@XStreamAlias("FromUserName")
	@XStreamConverter(value=XStreamCDataConverter.class)
	protected String fromUserName;

	@XStreamAlias("CreateTime")
	protected Long createTime;

	@XStreamAlias("MsgType")
	@XStreamConverter(value=XStreamCDataConverter.class)
	protected String msgType;

	public abstract String toXML();

	public String getToUserName() {
		return toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
