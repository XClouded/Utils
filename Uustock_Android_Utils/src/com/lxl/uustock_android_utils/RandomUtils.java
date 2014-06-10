package com.lxl.uustock_android_utils;

import java.util.Random;

/**
 * Random Utils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2012-5-12
 */
public class RandomUtils {

	public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMBERS = "0123456789";
	public static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * 得到一个固定长度的随机字符串,其混合的大写字母,小写字母和数字
	 * 
	 * @param length
	 * @return
	 * @see RandomUtils#getRandom(String source, int length)
	 */
	public static String getRandomNumbersAndLetters(int length) {
		return getRandom(NUMBERS_AND_LETTERS, length);
	}

	/**
	 * 得到一个固定长度的随机字符串,其混合的数字
	 * 
	 * 
	 * @param length
	 * @return
	 * @see RandomUtils#getRandom(String source, int length)
	 */
	public static String getRandomNumbers(int length) {
		return getRandom(NUMBERS, length);
	}

	/**
	 * 得到一个固定长度的随机字符串,其混合的大写和小写字母的。
	 * 
	 * @param length
	 * @return
	 * @see RandomUtils#getRandom(String source, int length)
	 */
	public static String getRandomLetters(int length) {
		return getRandom(LETTERS, length);
	}

	/**
	 * 得到一个固定长度的随机字符串,其混合的大写字母的
	 * 
	 * @param length
	 * @return
	 * @see RandomUtils#getRandom(String source, int length)
	 */
	public static String getRandomCapitalLetters(int length) {
		return getRandom(CAPITAL_LETTERS, length);
	}

	/**
	 * 得到一个固定长度的随机字符串,其混合小写字母的
	 * 
	 * @param length
	 * @return
	 * @see RandomUtils#getRandom(String source, int length)
	 */
	public static String getRandomLowerCaseLetters(int length) {
		return getRandom(LOWER_CASE_LETTERS, length);
	}

	/**
	 * 得到一个固定长度的随机的字符串,其字符的混合物在源
	 * 
	 * @param source
	 * @param length
	 * @return <ul>
	 *         <li>if source is null or empty, return null</li>
	 *         <li>else see
	 *         {@link RandomUtils#getRandom(char[] sourceChar, int length)}</li>
	 *         </ul>
	 */
	public static String getRandom(String source, int length) {
		return StringUtils.isEmpty(source) ? null : getRandom(
				source.toCharArray(), length);
	}

	/**
	 * 得到一个固定长度的随机字符串,其混合在sourceChar识字课
	 * 
	 * @param sourceChar
	 * @param length
	 * @return <ul>
	 *         <li>if sourceChar is null or empty, return null</li>
	 *         <li>if length less than 0, return null</li>
	 *         </ul>
	 */
	public static String getRandom(char[] sourceChar, int length) {
		if (sourceChar == null || sourceChar.length == 0 || length < 0) {
			return null;
		}

		StringBuilder str = new StringBuilder(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			str.append(sourceChar[random.nextInt(sourceChar.length)]);
		}
		return str.toString();
	}
}
