package com.kw.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class getEncodTool {
	
	public static String encodeHexTest(String str){

		try {

		str = Hex.encodeHexString(str.getBytes("UTF-8"));

		} catch (UnsupportedEncodingException e) {

		e.printStackTrace();

		}
		return str;

		}

		 

		public  static String decodeHexTest(String str){

		Hex hex = new Hex();

		try {

		str = new String((byte[])hex.decode(str));

		} catch (DecoderException e) {

		e.printStackTrace();

		}
		return str;

		}
		
}
