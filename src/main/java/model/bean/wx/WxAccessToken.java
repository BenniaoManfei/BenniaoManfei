package model.bean.wx;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信的token
 *
 * @description 通过计算token获取的时间点和当前时间点的秒数差异如果在expiresIn即表示当前token<br>
 *   			有效，防止已经失效了，需要重新获取。微信建议在为这个时间预留一个缓冲时间
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月25日
 */
public class WxAccessToken implements Serializable {

	private static final long serialVersionUID = -6491643396377676534L;

	private static WxAccessToken token;
	
	
	/** token字符串 */
	private String accessToken;

	/** token有效时间(单位:秒) */
	private int expiresIn = -1;

	/** 当前token获取的时间点 */
	private Date requestDate;
	
	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	private WxAccessToken() {

	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public static WxAccessToken getToken() {
		System.out.println("WxAccessTOKN获取");
		if (token == null) {
			return null;
		} else {
			Date now = new Date();
			long exIn = (now.getTime() - token.getRequestDate().getTime()) / 1000;
			if (exIn > 7000) {// 现在是7200,剩余的200秒缓冲
				return null;
			} else {
				return token;
			}
		}
	}

	public static WxAccessToken fromJson(String json) {
		JSONObject demoJson = JSONObject.parseObject(json);
		Integer errcode = demoJson.getIntValue("errcode");
		if (errcode != null && errcode.intValue() != 0) {
			return null;
		}
		token = new WxAccessToken();
		token.setAccessToken(demoJson.getString("access_token"));
		token.setExpiresIn(demoJson.getIntValue("expires_in"));
		token.setRequestDate(new Date());
		return token;
	}

}
