package web.Servlet.wx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.wx.menu.button.Button;
import model.bean.wx.menu.button.ClickNomalButton;
import model.bean.wx.menu.button.LocationSelectNomalButton;
import model.bean.wx.menu.button.MediaNomalButton;
import model.bean.wx.menu.button.Menu;
import model.bean.wx.menu.button.PicSysphotoNomalButton;
import model.bean.wx.menu.button.PicWeixinNomalButton;
import model.bean.wx.menu.button.ScancodePushNomalButton;
import model.bean.wx.menu.button.ScancodeWaitmsgNomalButton;
import model.bean.wx.menu.button.SubButton;
import model.bean.wx.menu.button.ViewNomalButton;
import service.wx.WxService;
import service.wx.impl.WxServiceImpl;
import ResultInfo.ResultInfo;

import com.alibaba.fastjson.JSONObject;

public class CreateMenuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5823951622936581768L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("\n---------创建个性化菜单 start---------------\n");
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		WxService wxService = new WxServiceImpl();
		
		List<Button> menus = new ArrayList<Button>();
		
		SubButton subButton1 = new SubButton();
		subButton1.setName("扫一扫");
		menus.add(subButton1);
		
		ScancodePushNomalButton button_1_1 = new ScancodePushNomalButton();
		button_1_1.setName("扫推事件");
		button_1_1.setKey("button_1_1_key");
		subButton1.addButton(button_1_1);
		
		ScancodeWaitmsgNomalButton button_1_2 = new ScancodeWaitmsgNomalButton();
		button_1_2.setName("扫带提示");
		button_1_2.setKey("button_1_2_key");
		subButton1.addButton(button_1_2);
		
		
		SubButton subButton2 = new SubButton();
		subButton2.setName("发图片");
		menus.add(subButton2);
		
		PicSysphotoNomalButton button_2_1 = new PicSysphotoNomalButton();
		button_2_1.setName("拍照发图");
		button_2_1.setKey("button_2_1_key");
		subButton2.addButton(button_2_1);
		
		PicWeixinNomalButton button_2_2 = new PicWeixinNomalButton();
		button_2_2.setName("相册发图");
		button_2_2.setKey("button_2_2_key");
		subButton2.addButton(button_2_2);
		
		PicWeixinNomalButton button_2_3 = new PicWeixinNomalButton();
		button_2_3.setName("拍照/相册");
		button_2_3.setKey("button_2_1_key");
		subButton2.addButton(button_2_3);
		
		SubButton subButton3 = new SubButton();
		subButton3.setName("其他");
		menus.add(subButton3);
		
		LocationSelectNomalButton button_3_1 = new LocationSelectNomalButton();
		button_3_1.setName("上传地址");
		button_3_1.setKey("button_3_1_key");
		subButton3.addButton(button_3_1);
		
		MediaNomalButton button_3_2 = new MediaNomalButton();
		button_3_2.setName("媒体");
		button_3_2.setMedia_id("V0Jifw014GN3YcX-XeAqfvGQlh-RmP5mvBnuNXDQ5jc");
		subButton3.addButton(button_3_2);//要求永久media_id
		
		MediaNomalButton button_3_3 = new MediaNomalButton();
		button_3_3.setName("图文");
		button_3_3.setMedia_id("V0Jifw014GN3YcX-XeAqflV2VB9pyhgbPvMWpAw0p_Y");
		subButton3.addButton(button_3_3);//要求永久media_id
		
		ClickNomalButton button_3_4 = new ClickNomalButton();
		button_3_4.setName("乐一乐");
		button_3_4.setKey("button_3_4_key");
		subButton3.addButton(button_3_4);
		
		ViewNomalButton button_3_5 = new ViewNomalButton();
		button_3_5.setName("跳转");
		button_3_5.setUrl("http://benniao-manfei.vicp.io/");
		subButton3.addButton(button_3_5);
		
		Menu wxMenubutton = new Menu();
		wxMenubutton.setButton(menus);
		
		ResultInfo<Object> flag = wxService.createMenu(JSONObject.toJSONString(wxMenubutton));
		System.out.println("\n---------创建个性化菜单 end---------------\n");
		response.getWriter().write(flag+"");
		
	}

}
