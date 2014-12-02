package com.mofang.framework.web.server.reactor.parse.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.mofang.framework.web.server.reactor.parse.PostDataParser;

/**
 * 
 * @author zhaodx
 *
 */
public class TextPostDataParser implements PostDataParser
{
	@Override
	public Map<String, String> parse(String postData) throws Exception
	{
		if(null == postData || "".equals(postData))
			return null;
		
		Map<String, String> paramMap = new HashMap<String, String>();
		String[] params = postData.split("&");
		for(String param : params)
		{
			String[] keyval = param.split("=");
			String paramKey = keyval[0];
			String paramValue = "";
			if(keyval.length == 2)
				paramValue = URLDecoder.decode(keyval[1], "UTF-8");
			paramMap.put(paramKey, paramValue);
		}
    	return paramMap;
	}
}