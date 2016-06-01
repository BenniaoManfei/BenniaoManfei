package model.bean.wx.menu.button;

import java.util.ArrayList;
import java.util.List;

/**
 * 带二级菜单的按钮
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月28日
 */
public class SubButton extends Button {

	private List<NomalButton> sub_button = new ArrayList<NomalButton>();
	
	public void addButton(NomalButton button){
		sub_button.add(button);
	}
	
	public List<NomalButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<NomalButton> sub_button) {
		this.sub_button = sub_button;
	}
	
}
