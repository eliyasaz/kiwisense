package com.kiwisense.common.utils;


public class StrUtil {

	public static boolean isEmpty(String str) {
		return isNull(str) || (str.isEmpty());
	}

	public static boolean isNull(String str) {
		return (null == str) || ("null".equalsIgnoreCase(str));
	}

}
