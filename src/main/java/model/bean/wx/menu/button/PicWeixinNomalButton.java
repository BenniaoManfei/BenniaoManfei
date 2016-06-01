package model.bean.wx.menu.button;

public class PicWeixinNomalButton extends NomalButton {

	private String key ;
	
	public PicWeixinNomalButton(){
		super.type = NomalButton.BUTTON_TYPE_PIC_WEIXIN;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
