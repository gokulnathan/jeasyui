package cn.javass.commons.pagination;

/**
 * 分布标签接口
 * @author AB029789
 *
 */
public interface INavigationProvider {

	 public String build(Page<?> page, String url);
	 
	 
}
