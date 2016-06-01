package ResultInfo;


/**
 * 自定义的结果集
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2015年12月4日
 */
public class ResultInfo<T> {
	
	/** 
	 * 消息码。
	 * 默认：code = 0
	 * 成功：code > 0
	 * 失败：code < 1
	 */
	public int code = 0;
	
	/** 提示信息 */
	public String msg = "亲，系统繁忙！";
	
	/** 结果集中的对象 */
	public T obj;

	@Override
	public String toString() {
		return "ResultInfo [code=" + code + ", msg=" + msg + ", object="
				+ obj + "]";
	}
	
}
