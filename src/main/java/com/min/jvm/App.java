package com.min.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Hello world!
 *
 */
public class App 
{
	static String str0="0123456789";
	static String str1="0123456789";
	String str2 = str1.substring(5);
	String str3 = new String(str2);
	String str4 = new String(str3.toCharArray());
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        long i = 0;
        List<String> list = new ArrayList<String>();
        while(true) {
        	list.add(String.valueOf(i++).intern());
        }
    }
}
