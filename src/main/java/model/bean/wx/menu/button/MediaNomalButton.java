package model.bean.wx.menu.button;

public class MediaNomalButton extends NomalButton {

	private String media_id;

	public MediaNomalButton() {
		super.type = NomalButton.BUTTON_TYPE_MEDIA_ID;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}


}
