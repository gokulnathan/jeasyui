package cn.javass.commons.pagination;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import cn.javass.commons.Constants;
import cn.javass.commons.pagination.provider.NavigationProviderFactory;

public class NavigationTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ValueStack中的Page<?>翻页对象变量名
	 */
	private String pageName = Constants.DEFAULT_PAGE_NAME;

	/**
	 * 分页跳转地址的URL，必须
	 */
	private String url = "";

	/**
	 * 分页提供者版本
	 */
	private String version = "v1";

	@Override
	public int doStartTag() throws JspException {

		Page<?> page = (Page<?>) getValueStack().findValue(this.getPageName());

		if (page == null) {
			return SKIP_BODY;
		}

		JspWriter jspWriter = pageContext.getOut();
		try {

			jspWriter.write("<form action='" + url + "' method='post'>");

			String link = NavigationProviderFactory.getNavigationProvider(
					version).build(page, url);

			jspWriter.print(link);

			jspWriter.print("&nbsp;<input name='pn' size='3'/>");
			jspWriter.print("<input type='submit' value='跳转'/>");
			// writer.print("&nbsp;[共" + page.getContext().getPageCount() +
			// "页]");
			jspWriter.print("</form>");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	private ValueStack getValueStack() {
		return ActionContext.getContext().getValueStack();
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
