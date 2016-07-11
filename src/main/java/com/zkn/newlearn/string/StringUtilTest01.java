package com.zkn.newlearn.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringUtilTest01 {

	public static String[] split(String str, String separatorChars, int max) {
		if (str == null) {
			return null;
		}

		int length = str.length();

		if (length == 0) {
			return new String[0];
		}

		List<String> list = new LinkedList<String>();
		int sizePlus1 = 1;
		int i = 0;
		int start = 0;
		boolean match = false;

		if (separatorChars == null) {
			// null表示使用空白作为分隔符
			while (i < length) {
				if (Character.isWhitespace(str.charAt(i))) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		} else if (separatorChars.length() == 1) {
			// 优化分隔符长度为1的情形
			char sep = separatorChars.charAt(0);

			while (i < length) {
				if (str.charAt(i) == sep) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		} else {
			// 一般情形
			while (i < length) {
				if (separatorChars.indexOf(str.charAt(i)) >= 0) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		}

		if (match) {
			list.add(str.substring(start, i));
		}

		return list.toArray(new String[list.size()]);
	}
	
	public static void main(String[] args) {
		
		String[] str = "sddasda1s/*".split("s");
		String[] str1 = StringUtilTest01.split("sddasda1s/*", "s",-1);
		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString(str1));
	}
}
