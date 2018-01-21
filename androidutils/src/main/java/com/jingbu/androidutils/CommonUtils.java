package com.jingbu.androidutils;

import android.text.TextUtils;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用工具类
 * @author guojingbu
 *
 */
public class CommonUtils {

    /**
     * 手机号中间号码替换为*
     * @param phone
     * @return
     */
    public static String getEncryptedPhoneNumber(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        }
        char[] tmpPhone = phone.toCharArray();
        for (int i = 0; i < tmpPhone.length; i++) {
            if (i >= 3 && i <= 6) {
                tmpPhone[i] = '*';
            }
        }
        return new String(tmpPhone);
    }

    /**
     * MD5加密
     * @param s
     * @return
     * @throws NoSuchAlgorithmException
     */
    private final static String MD5(String s) throws NoSuchAlgorithmException {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        byte[] btInput = s.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int length = md.length;
        char str[] = new char[length * 2];
        int k = 0;
        for (int i = 0; i < length; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    /**
     * null 字符串处理
     * @param s
     * @return
     */
    public static String safeString(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

    /**
     * 字符串Base64编码
     * @param s
     * @return
     */
    public static byte[] encode(String s) {
        byte[] data;
        try {
            data = s.getBytes("utf-8");
            byte[] result = Base64.encode(data, Base64.DEFAULT);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验手机号
     * @param phoneNumber
     * @return
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        String regExp = "^(1)\\d{10}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phoneNumber);
        return m.find();
    }

}
