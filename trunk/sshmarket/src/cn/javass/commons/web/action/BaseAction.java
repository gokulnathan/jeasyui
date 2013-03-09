package cn.javass.commons.web.action;

import cn.javass.commons.Constants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 表现层
 * 
 * @author Jerry
 * 
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 通用结果 **/
	public static final String List = "result";

	public static final String REDIRECT = "redirect";

	public static final String ADD = "add";

	/*** 模型对象属性名 **/
	public static final String MODEL = "model";

	public static final int DEFAULT_PAGE_SIZE = Constants.DEFAULT_PAGE_SIZE;

	public static final String PAGE = Constants.DEFAULT_PAGE_NAME;

	private int pn = 1;// 默认页码

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

	public ActionContext getActionContext() {
		return ActionContext.getContext();
	}

	public ValueStack getValueStack() {
		return getActionContext().getValueStack();
	}

}
