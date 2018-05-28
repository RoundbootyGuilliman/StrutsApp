package com.epam.javalab.strutsapp.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {

	private static final String MD5 = "MD5";
	private static final String FORMAT_032X = "%032x";

	private MD5Encoder() {
	}

	public static String encode(String base) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance(MD5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.update(StandardCharsets.UTF_8.encode(base));
		return String.format(FORMAT_032X, new BigInteger(1, md5.digest()));
	}
}
