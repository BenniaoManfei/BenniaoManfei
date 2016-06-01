package model.bean.wx.menu.button;


/**
 * view类型的按钮
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月28日
 */
public class ViewNomalButton extends NomalButton {

	private String url;

	public ViewNomalButton(){
		super.type = NomalButton.BUTTON_TYPE_VIEW;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
