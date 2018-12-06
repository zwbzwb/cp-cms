package com.copy.common.constants;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.function.BinaryOperator;

/**
 * @Author: zwb
 * @Date: 2018/12/6 16:47
 * Constants
 */
public class Constants {
	/**
	 * Json Mapper
	 */
	public static final ObjectMapper objectMapper = new ObjectMapper();
	/**
	 * Default Request Config
	 */
	public static  RequestConfig defaultRequestcofig  = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
			.setConnectionRequestTimeout(5000).build();
	/**
	 * 随机数
	 *
	 * Random
	 */
	public static final Random random = new Random();
	/**
	 * 默认字符串编码名称
	 *
	 * Default CharSet Name
	 */
	public static final String DEFAULT_CHARSET_NAME = "UTF-8";
	/**
	 * 默认字符编码
	 *
	 * Default CharSet
	 */
	public static final Charset DEFAULT_CHARSET = Charset.forName(DEFAULT_CHARSET_NAME);
	/**
	 * 间隔符
	 *
	 * separator
	 */
	public static final String SEPARATOR = "/";
	/**
	 * 空白字符串
	 * blank
	 */
	public static final String BLANK = "";
	/**
	 * 点
	 * dot
	 */
	public static final String DOT = ".";
	/**
	 * 下划线
	 * underline
	 */
	public static final String UNDERLINE = "_";
	/**
	 * 空格
	 * blank space
	 */
	public static final String BLANK_SPACE = " ";
	/**
	 * 逗号分隔符
	 * comma delimited
	 */
	public static final String COMMA_DELINITED = ",";
	/**
	 * @return default meger function
	 */
	public static <T> BinaryOperator<T> defaultMegerFunction (){
		return (first,second) -> first;
	}

}
