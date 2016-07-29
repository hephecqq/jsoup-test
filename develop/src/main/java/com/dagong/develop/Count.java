package com.dagong.develop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 计算文本文档中英文单词的个数
 * 
 * @author DAGONG
 *
 */
public class Count {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		char[] temp = new char[1024];
		int num = 0;
		StringBuilder sb = new StringBuilder();
		while ((num = in.read(temp)) > 0) {
			//一个一个字符读取文件中的字符串
			sb.append(new String(temp, 0, num));
		}
		String str = sb.toString();
		System.out.println(count_2(str));
		in.close();
	}

	private static int count_2(String str) {
		char[] a = str.toCharArray();
		int num = 0;
		String strtemp = "";
		for (int i = 0; i < a.length; i++) {
			//字符在a-z或者A-Z之间的处理计算
			if (a[i] >= 'a' && a[i] <= 'z' || (a[i]) >= 'A' && a[i] <= 'z') {
				num++;
				strtemp += a[i];
				i++;
				for (; i < a.length; i++) {
					//下一个字符在a-z或者A-Z之间的处理计算
					if ((a[i] >= 'a' && a[i] <= 'z' || (a[i]) >= 'A' && a[i] <= 'z')) {
						strtemp += a[i];
						continue;
					} else {
						//不满足下一个字符在a-z或者A-Z之间的处理
						System.out.println(strtemp);
						strtemp = "";
						break;
					}
				}

			} 
			//不满足在a-z或者A-Z之间处理
			else
				continue;

		}
		return num;
	}

}
