package model.bean.wx.menu.button;

public class PicPhotoAlbumNomalButton extends NomalButton {

	private String key;

	public PicPhotoAlbumNomalButton() {
		super.type = NomalButton.BUTTON_TYPE_PIC_PHOTO_OR_ALBUM;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
