package com.min.jvm.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk1.6配置：VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk1.7配置：-Xmx10m -Xms10m -XX:-UseGCOverheadLimit
 * 
 * jdk1.6字符串常量池放在方法区，jdk1.7字符串常量池放在堆
 * jdk1.8方法区(运行时常量池)放在元数据空间，字符串常量池放在堆空间。
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		compareString();
		outOfMemPermGen();
	}
	
	public static void compareString() {
		String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
	
	public static void outOfMemPermGen() {
		// 使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		// 10MB的PermSize在integer范围内足够产生OOM了
		int i = 0; 
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
