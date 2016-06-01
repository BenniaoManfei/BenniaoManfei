package service.wx;

import java.io.File;
import java.util.Map;

import model.bean.wx.MaterialNews;
import ResultInfo.ResultInfo;

/**
 * 素材管理接口
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2016年5月3日
 */
public interface MaterialService {

	/**
	 * 新增临时素材(微信服务器会保存3天)
	 *
	 * @param file
	 * @param mediaType 素材类型(image,voice,video,thumb)
	 * @return
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月29日
	 */
	public ResultInfo<Map<String, Object>> uploadMedia(File file,String mediaType);
	
	/**
	 * 新增永久素材
	 * 
	 * @description 本接口仅支持上传图片(image)、缩略图(thumb)、音频(voice)。图文类型和视频类型素材有其他专门的接口
	 *
	 * @param file
	 * @param mediaType素材类型(image,voice,thumb)
	 * @return
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月29日
	 */
	public ResultInfo<Map<String, String>> uploadMaterial(File file,String mediaType);
	
	/**
	 * 上传图文消息内的图片获取URL 
	 * 
	 * @description 请注意，在图文消息的具体内容中，将过滤外部的图片链接，开发者可以通过下述接口上传图片得到URL，放到图文内容中使用。<br>
			上传图文消息内的图片获取URL 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 *
	 * @param file
	 * @return
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月29日
	 */
	public ResultInfo<String> uploadNewsImg(File file);
	
	/**
	 * 新增永久素材(图文素材)
	 *
	 * @param news
	 * @return
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月29日
	 */
	public ResultInfo<String> uploadMaterialNews(MaterialNews news);
	
	/**
	 * 获取公众号永久素材的总数
	 *
	 * @return <b>voice_count</b>音频总数<br>
	 *  <b>video_count</b>视频总数<br>
	 *  <b>image_count</b>图片总数<br>
	 *  <b>news_count</b>图文总数<br>
	 *
	 * @author DaiZhengmiao
	 * @createDate 2016年4月28日
	 */
	public ResultInfo<Map<String, Integer>> getMaterialcount();
}
