package model.bean.wx.menu.button;

public class ScancodeWaitmsgNomalButton extends NomalButton {

	private String key ;
	
	public ScancodeWaitmsgNomalButton(){
		super.type = NomalButton.BUTTON_TYPE_SCANCODE_WAITMSG;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
