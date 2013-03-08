package cn.javass.commons.pagination;

import cn.javass.commons.Constants;

/**
 * 分页上下文环境
 * @author Jerry
 *
 * @param <T>
 */
public interface IPageContext<T> {

	/**设置默认分页大小 **/
	public static final int DEFAULT_PAGE_SIZE = Constants.DEFAULT_PAGE_SIZE;
	
	/**获取总页数**/
	public int getPageCount();
	
	/**每页显示的记录数量**/
	public int getPageSize();
	
	/**计算总的记录数**/
	public int getTotalCount();
	
	/**返回分页对象**/
	public Page<T> getPage(int pageNum);
	
	
}
