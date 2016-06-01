package model.bean.wx.menu.button;



public class ScancodePushNomalButton extends NomalButton {

	private String key ;
	
	public ScancodePushNomalButton(){
		super.type = NomalButton.BUTTON_TYPE_SCANCODE_PUSH;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
