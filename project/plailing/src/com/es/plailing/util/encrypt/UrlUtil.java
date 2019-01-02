package com.es.plailing.util.encrypt;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

/**
 * 
    * @ClassName: UrlUtil
    * @Description: TODO(BASE64的加密解密)
    * @author 郭秋霞
    * @date 2018年12月12日
    *
 */
public class UrlUtil {

	private static final String KEY = "plailing";
	private static final Logger LOGGER = LoggerFactory.getLogger(UrlUtil.class);

	/**
	 * 
	    * @Title: enCryptAndEncode
	    * @Description: TODO(加密函数)
	    * @param @param content(加密内容)
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String enCryptAndEncode(String content) {
		try {
			byte[] sourceBytes = enCryptAndEncode(content, KEY);
			return Base64.encodeBase64URLSafeString(sourceBytes);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return content;
		}
	}
	
	/**
	 * 
	    * @Title: enCryptAndEncode
	    * @Description: TODO(加密函数)
	    * @param @param content(加密内容)
	    * @param @param strKey(密钥)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return byte[]    返回类型
	    * @throws
	 */
	public static byte[] enCryptAndEncode(String content, String strKey) throws Exception {

		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

		SecretKey desKey = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, desKey);
		return cipher.doFinal(content.getBytes("UTF-8"));
	}

	/**
	 * 
	    * @Title: deCryptAndDecode
	    * @Description: TODO(解密函数)
	    * @param @param content(加密过的字符串)
	    * @param @return
	    * @param @throws Exception    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String deCryptAndDecode(String content) throws Exception {
		byte[] targetBytes = Base64.decodeBase64(content);
		return deCryptAndDecode(targetBytes, KEY);
	}

	/**
	 * 
	    * @Title: deCryptAndDecode
	    * @Description: TODO(解密函数)
	    * @param @param src(加密过的二进制字符数组)
	    * @param @param strKey
	    * @param @return
	    * @param @throws Exception    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String deCryptAndDecode(byte[] src, String strKey) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

		SecretKey desKey = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, desKey);
		byte[] cByte = cipher.doFinal(src);
		return new String(cByte, "UTF-8");
	}

}
