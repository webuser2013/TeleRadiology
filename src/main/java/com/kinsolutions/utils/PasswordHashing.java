package com.kinsolutions.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.kinsolutions.constants.AppConstants;

public class PasswordHashing {

	public static String getEnryptedPassword(String password) {
 		String md5 = null;
 		if (null == password)
			return null;
 		try {
 			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance(AppConstants.ALG_PWD_HASH);
 			// Update input string in message digest
			digest.update(password.getBytes(), 0, password.length());
 			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
 		} catch (NoSuchAlgorithmException e) {
 			e.printStackTrace();
		}
		return md5;
	}

}
