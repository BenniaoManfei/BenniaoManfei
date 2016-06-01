package model.bean.wx.menu.button;

public class NewsNomalButton extends NomalButton {

	private String media_id;

	public NewsNomalButton() {
		super.type = NomalButton.BUTTON_TYPE_VIEW_LIMITED;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
}
