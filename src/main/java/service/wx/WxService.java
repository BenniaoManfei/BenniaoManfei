package service.wx;

import java.io.File;
import java.util.Map;

import model.bean.wx.MaterialNews;
import model.bean.wx.WxAccessToken;
import ResultInfo.ResultInfo;

/**
 * 微信基础的接口
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年4月22日
 */
public interface WxService {

	/**
	 * <pre>
	 * 验证推送过来的消息的正确性
	 * </pre>
	 *
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @return 验证成功返回true，防止返回false
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月21日
	 */
	public boolean checkSignature(String timestamp, String nonce, String signature);
	
	/**
	 * 获取token
	 * 
	 * @description 如果token在有效期内，则直接返回，防止会重新请求获取一个
	 * 
	 * @return
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月22日
	 */
	public WxAccessToken getToken();
	
	/**
	 * 获取微信器IP地址
	 *
	 * @return
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月22日
	 */
	public String[] getCallbackip();
	
	/**
	 * 创建自定义菜单
	 *
	 * @param menu
	 * @return
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月28日
	 */
	public ResultInfo<Object> createMenu(String menu);
	

}
