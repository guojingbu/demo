package com.jingbu.androidutils;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * String类相关操作
 *
 * @author wangbo
 */
public class StringUtils {

    /**
     * 将字符串用分隔符分割为字符串列表
     *
     * @param string    字符串
     * @param delimiter 分隔符
     * @return 分割后的字符串数组.
     */
    public static List<String> splitToStringList(String string, String delimiter) {
        List<String> stringList = new ArrayList<String>();
        if (!TextUtils.isEmpty(string)) {
            int length = string.length();
            int pos = 0;

            do {
                int end = string.indexOf(delimiter, pos);
                if (end == -1) {
                    end = length;
                }
                stringList.add(string.substring(pos, end));
                pos = end + 1;
            } while (pos < length);
        }
        return stringList;
    }

    /**
     * InputSteam 转换到 String，会把输入流关闭
     *
     * @param inputStream 输入流
     * @return String 如果有异常则返回null
     */
    public static String stringFromInputStream(InputStream inputStream) {
        try {
            byte[] readBuffer = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int readLen = inputStream.read(readBuffer, 0, readBuffer.length);
                if (readLen <= 0) {
                    break;
                }

                byteArrayOutputStream.write(readBuffer, 0, readLen);
            }

            return byteArrayOutputStream.toString("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 判断是否为空串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}