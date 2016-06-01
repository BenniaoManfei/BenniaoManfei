package model.bean.wx.menu.button;

public class LocationSelectNomalButton extends NomalButton {

	private String key;

	public LocationSelectNomalButton() {
		super.type = NomalButton.BUTTON_TYPE_LOCATION_SELECT;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
