package cn.javass.commons.pagination;

/**
 * 抽象
 * 
 * @author Jerry
 * 
 */
public abstract class AbstractNavigationProvider implements INavigationProvider {

	protected String append(String url, String key, int value) {
		return append(url, key, String.valueOf(value));
	}

	private String append(String url, String key, String value) {
		if (url == null || url.length() == 0) {
			return "";
		}
		if (url.indexOf("?") == -1) {
			url = url + "?" + key + "=" + value;
		} else {
			url = url + "&amp;" + key + "=" + value;
		}
		return url;
	}

}
