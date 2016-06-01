package model.bean.wx.menu.button;

public class PicSysphotoNomalButton extends NomalButton {

	private String key ;
	
	public PicSysphotoNomalButton(){
		super.type = NomalButton.BUTTON_TYPE_PIC_SYSPHOTO;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
