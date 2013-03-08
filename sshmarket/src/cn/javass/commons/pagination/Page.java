package cn.javass.commons.pagination;

import java.util.List;

public class Page<T> {

	private boolean hasPre; //是否有上一页
	
	private boolean hasNext; //是否有下一页
	
	private List<T> items; //当前页包含的记录列表
	
	private int index; //当前页页码,起始为1;

	public boolean isHasPre() {
		return hasPre;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
