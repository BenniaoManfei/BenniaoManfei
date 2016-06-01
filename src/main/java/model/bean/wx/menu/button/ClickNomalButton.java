package model.bean.wx.menu.button;

/**
 * click类型的普通按钮
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月28日
 */
public class ClickNomalButton extends NomalButton {

	private String key;

	public ClickNomalButton(){
		super.type = NomalButton.BUTTON_TYPE_CLICK;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
