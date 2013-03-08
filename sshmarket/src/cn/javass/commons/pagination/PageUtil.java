package cn.javass.commons.pagination;

import java.util.List;

/**
 * 分页工具类
 * 
 * @author Jerry
 * 
 */
public class PageUtil {

	/**
	 * 根据页面和每页记录数，确定起始记录位置
	 * 
	 * @param pageNumber
	 *            页码
	 * @param pageSize
	 *            每页大小
	 * @return 起始位置
	 */
	public static int getPageStart(int pageNumber, int pageSize) {
		// 传入int最大值，确保记录数不会超过这个值,这里隐藏BUG，如果记录数大于这个值，则分页不能显示到全部 2的31次方-1
		return getPageStart(Integer.MAX_VALUE, pageNumber, pageSize);
	}

	/**
	 * 
	 * @param totalCount
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	private static int getPageStart(int totalCount, int pageNumber, int pageSize) {
		int start = (pageNumber - 1) * pageSize;
		if (start >= totalCount) {
			start = 0;
		}
		return start;
	}
	
	/**
	 * 构造分页对象
	 * @param totalCount
	 * 		总的记录数
	 * @param pageNumber
	 * 		本次分页的页码
	 * @param items
	 * 		查询返回的记录数
	 * @param pageSize
	 * 		每页数
	 * @return
	 */
	public static <E> Page<E> getPage(int totalCount, int pageNumber, List<E> items, int pageSize) {
		
		IPageContext<E> pageContext = new QuickPageContext<E>(totalCount,pageSize, items); 
		
		return pageContext.getPage(pageNumber);
		
	}

}
