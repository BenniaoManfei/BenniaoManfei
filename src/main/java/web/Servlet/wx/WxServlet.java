package web.Servlet.wx;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.wx.message.in.MsgIn;
import model.bean.wx.message.out.MsgOut;
import model.bean.wx.message.out.MsgOutNews;
import model.bean.wx.message.out.MsgOutText;
import model.bean.wx.message.out.MsgOutNews.Item;
import service.wx.WxService;
import service.wx.impl.WxServiceImpl;
import common.constant.WxConstants;
import common.util.TulingText;
import common.util.xml.MsgXmlUtil;

/**
 * 微信接入
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月20日
 */
public class WxServlet extends HttpServlet {

	private static final long serialVersionUID = 3780829182749161524L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Writer out = response.getWriter();

		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		System.out.println("signature:" + signature);
		System.out.println("timestamp:" + timestamp);
		System.out.println("nonce:" + nonce);
		System.out.println("echostr:" + echostr);

		// 4）验证传递过来的消息是否争取，成功后返回随机字符串
		WxService wxService = new WxServiceImpl();
		if (wxService.checkSignature(timestamp, nonce, signature)) {
			System.out.println("微信接入成功");
			out.write(echostr);
		} else {
			System.out.println("微信接入不成功");
		}

		try {
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("\n/--------接收到消息：Start----------------------/");
		
		try {
			MsgIn msgIn  = MsgXmlUtil.parseXml(request);
			System.out.println("接收到的消息:【"+msgIn.toString()+"】");
			MsgOut msgOut  = null;
			
			if (WxConstants.MSG_TEXT.equals(msgIn.getMsgType())) {
				msgOut = new MsgOutText();
				msgOut.setFromUserName(msgIn.getToUserName());
				msgOut.setToUserName(msgIn.getFromUserName());
				msgOut.setCreateTime(System.currentTimeMillis());
				String responseStr = TulingText.getTulingReponse(msgIn.getContent(), msgIn.getFromUserName());
				((MsgOutText) msgOut).setContent(responseStr);
			} else if(WxConstants.MSG_IMAGE.equals(msgIn.getMsgType())){
				msgOut = new MsgOutNews();
				msgOut.setFromUserName(msgIn.getToUserName());
				msgOut.setToUserName(msgIn.getFromUserName());
				msgOut.setCreateTime(System.currentTimeMillis());
				
				Item item1 = new Item();
				item1.setUrl("www.baidu.com");
				item1.setTitle("百度LOGO");
				item1.setDescription("点击图片试试?");
				item1.setPicUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
				Item item2 = new Item();
				item2.setUrl("www.baidu.com");
				item2.setTitle("百度LOGO");
				item2.setDescription("点击图片试试?");
				item2.setPicUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
				((MsgOutNews) msgOut).getArticles().add(item1);
				((MsgOutNews) msgOut).getArticles().add(item2);
				((MsgOutNews) msgOut).setArticleCount(((MsgOutNews) msgOut).getArticles().size());
			}else {
				if(WxConstants.MSG_EVENT.equals(msgIn.getMsgType()) && "button_3_4_key".equals(msgIn.getEventKey())){
					msgOut = new MsgOutText();
					msgOut.setFromUserName(msgIn.getToUserName());
					msgOut.setToUserName(msgIn.getFromUserName());
					msgOut.setCreateTime(System.currentTimeMillis());
					String responseStr = TulingText.getTulingReponse("讲个笑话吧", msgIn.getFromUserName());
					((MsgOutText) msgOut).setContent(responseStr);
				} else{
					msgOut = new MsgOutText();
					msgOut.setFromUserName(msgIn.getToUserName());
					msgOut.setToUserName(msgIn.getFromUserName());
					msgOut.setCreateTime(System.currentTimeMillis());
					((MsgOutText) msgOut).setContent("非常抱歉，公众号暂时不能处理该消息");
				}
			}
			
			String msgOutStr = msgOut.toXML();
			System.out.println("\n"+msgOutStr+"\n");
			System.out.println("/--------响应消息：end----------------------/\n");
			response.getWriter().write(msgOutStr);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("/--------系统错误：end----------------------/\n");
		}
		
	}

}
