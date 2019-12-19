/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: StreamUtil.java 
 * @Prject: yangjiachen-common
 * @Package: com.yangjiachen.common.utils 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年12月19日 上午8:21:32 
 */
package com.yangjiachen.common.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: StreamUtil
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年12月19日 上午8:21:32
 */
public class StreamUtil {
	/*
	 * 方法1：批量关闭流，参数能传入无限个。(10分)
	 * 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	 */
	public static void closeAll(Closeable... closeable) {
		if (closeable != null && closeable.length > 0) {
			for (Closeable closeable2 : closeable) {
				try {
					closeable2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	 */
	public static String readTextFile(InputStream src) {
		byte[] b = new byte[1024];
		int i = 0;
		String str = "";
		try {
			while ((i = src.read(b)) > 0) {
				str += new String(b, 0, i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(src);
		}
		return str;
	}

	/*
	 * 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */
	public static String readTextFile(File txtFile) throws FileNotFoundException {
		InputStream is = new FileInputStream(txtFile);
		String string = readTextFile(is);
		return string;
	}

	public static void main(String[] args) throws FileNotFoundException {

		String string = readTextFile(new File("C:\\Users\\丑小鸭\\Desktop\\复习.txt"));
		System.out.println(string);
	}

}
