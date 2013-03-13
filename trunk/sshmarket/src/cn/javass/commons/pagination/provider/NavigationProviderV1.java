package cn.javass.commons.pagination.provider;

import cn.javass.commons.Constants;
import cn.javass.commons.pagination.AbstractNavigationProvider;
import cn.javass.commons.pagination.Page;

/**
 * 构造上一页，下一页的形式
 * @author Jerry
 *
 */
public class NavigationProviderV1 extends AbstractNavigationProvider {

	@Override
	public String build(Page<?> page, String url) {

		StringBuilder strBuilder = new StringBuilder();

		if (page.isHasPre()) {
			String preUrl = append(url, Constants.PN, page.getIndex() - 1);
			strBuilder.append("<a href=\"" + preUrl + "\">上一页</a>&nbsp;");
		}

		if (page.isHasNext()) {
			String nextUrl = append(url, "pn", page.getIndex() + 1);
			strBuilder.append("<a href=\"" + nextUrl + "\">下一页</a>");
		}

		return strBuilder.toString();
	}

}
