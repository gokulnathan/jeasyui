package cn.javass.point.exception;

/**
 * 购买失败异常,表示没有足够的兑换码
 * 
 * @author Jerry
 * 
 */
public class NotCodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String string;

	public NotCodeException() {

	}

	public NotCodeException(String string) {
		this.setString(string);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
