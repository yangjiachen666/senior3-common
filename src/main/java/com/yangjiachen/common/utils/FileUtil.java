/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: FileUtil.java 
 * @Prject: yangjiachen-common
 * @Package: com.yangjiachen.common.utils 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年12月19日 上午8:19:40 
 */
package com.yangjiachen.common.utils;

/**
 * @ClassName: FileUtil
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年12月19日 上午8:19:40
 */
public class FileUtil {
	/*
	 * 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	 */
	public static String getExtendName(String fileName) {
		
		return fileName.substring(fileName.lastIndexOf("."));
		
	}

	
	
	
	public static void main(String[] args) {
		String extendName = getExtendName("aaaa.jpg");
		System.out.println(extendName);
	}
}
