package cn.javass.commons.pagination.provider;

import java.util.HashMap;
import java.util.Map;

import cn.javass.commons.pagination.INavigationProvider;

/**
 * 单例模式
 * 
 * @author Jerry
 * 
 */
public class NavigationProviderFactory {

	private static final Map<String, INavigationProvider> map = new HashMap<String, INavigationProvider>();

	static {
		map.put("v1", new NavigationProviderV1());
		map.put("v2", new NavigationProviderV2());
	}

	public static INavigationProvider getNavigationProvider(String version) {
		INavigationProvider provider = map.get(version);
		if(provider == null) {
			provider = map.get("v1");
		}
		return provider ;
	}
}
