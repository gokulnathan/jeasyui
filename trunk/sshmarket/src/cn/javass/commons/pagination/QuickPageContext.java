package cn.javass.commons.pagination;

import java.util.List;

/**
 * 分页实现，每次查询返回一页使用
 * 
 * @author Jerry
 * 
 * @param <T>
 */
public class QuickPageContext<T> implements IPageContext<T> {

	private List<T> items;// 查询总记录数

	private int totalCount;// 总记录数

	private int pageSize;// 每页返回记录数

	/**
	 *  构造函数
	 */
	public QuickPageContext() {
		super();
	}

	/**
	 * 有参构造函数
	 * @param totalCount
	 * @param pageSize
	 * @param items
	 */
	public QuickPageContext(int totalCount, int pageSize, List<T> items) {
		super();
		this.items = items;
		this.totalCount = totalCount;
		this.pageSize = pageSize == 0 ? DEFAULT_PAGE_SIZE : pageSize;
	}
	
	public Page<T> getPage(int index) {
		
		Page<T> page = new Page<T>();
	
		int indexNext = index > getPageCount() ? 1 : index;
		
		page.setHasNext(indexNext < getPageCount());//如果大于总页面，则无下一页
		
		page.setHasPre(indexNext > 1);//如果小于等于1，表示为第一页面，则无前一页面
		
		page.setItems(items);
		
		page.setIndex(indexNext);//设置当前页
		
		return page;
	}

	/**
	 * 返回查询的总页数
	 */
	@Override
	public int getPageCount() {

		int division = totalCount / pageSize;
		int result = totalCount % pageSize == 0 ? division : division + 1;

		return result;
	}

	@Override
	public int getPageSize() {

		return this.pageSize;
	}

	@Override
	public int getTotalCount() {

		return this.totalCount;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
