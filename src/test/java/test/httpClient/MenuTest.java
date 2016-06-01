package test.httpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.bean.wx.menu.button.Button;
import model.bean.wx.menu.button.ClickNomalButton;
import model.bean.wx.menu.button.Menu;
import model.bean.wx.menu.button.ScancodePushNomalButton;
import model.bean.wx.menu.button.SubButton;
import model.bean.wx.menu.button.ViewNomalButton;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class MenuTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
List<Button> menus = new ArrayList<Button>();
		
		ClickNomalButton button1 = new ClickNomalButton();
		button1.setName("项目管理");
		button1.setKey("button_1_key");
		menus.add(button1);
		
		SubButton subButton = new SubButton();
		ClickNomalButton button_2_1 = new ClickNomalButton();
		button_2_1.setName("点击");
		button_2_1.setKey("button_2_1_key");
		
		ViewNomalButton button_2_2 = new ViewNomalButton();
		button_2_2.setName("百度");
		button_2_2.setUrl("http://www.baidu.com");
		
		ScancodePushNomalButton button_2_3 = new ScancodePushNomalButton();
		button_2_3.setName("扫一扫");
		button_2_3.setKey("button_2_3_key");
		
		subButton.addButton(button_2_1);
		subButton.addButton(button_2_2);
		subButton.addButton(button_2_3);
		
		subButton.setName("关于我们");
		menus.add(subButton);
		
		
		Menu wxMenubutton = new Menu();
		wxMenubutton.setButton(menus);
		System.out.println(JSONObject.toJSONString(wxMenubutton));
		
	}

}
