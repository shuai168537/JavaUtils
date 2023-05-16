package com.personal.util.tools;

import java.util.Formatter;
import java.util.UUID;

/**
 * 字节相关工具类
 */
public class ByteUtils {

    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 字符串转字节
     *
     * @param s 16进制字符串
     */
    public static byte[] hexString2Bytes(String s) {
        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    /**
     * 字节数据转换成字符串（无空格分隔）
     *
     * @param bytes 字节数组
     */
    public static String bytes2String(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = DIGITS_LOWER[v >>> 4];
            hexChars[i * 2 + 1] = DIGITS_LOWER[v & 0x0F];

            sb.append(hexChars[i * 2]);
            sb.append(hexChars[i * 2 + 1]);
        }
        return sb.toString();
    }

    /**
     * 字节数据转换成字符串（空格分隔）
     *
     * @param bytes 字节数组
     */
    public static String bytes2StringWithBlank(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = DIGITS_LOWER[v >>> 4];
            hexChars[i * 2 + 1] = DIGITS_LOWER[v & 0x0F];

            sb.append(hexChars[i * 2]);
            sb.append(hexChars[i * 2 + 1]);
            sb.append(' ');
        }
        return sb.toString();
    }

    /**
     * 十六进制字符串高低位转换
     *
     * @param hex 16进制的数据字符串
     *            例：把 02fc 转为 fc02
     */
    public static String reverseHex(String hex) {
        char[] charArray = hex.toCharArray();
        int length = charArray.length;
        int times = length / 2;
        for (int c1i = 0; c1i < times; c1i += 2) {
            int c2i = c1i + 1;
            char c1 = charArray[c1i];
            char c2 = charArray[c2i];
            int c3i = length - c1i - 2;
            int c4i = length - c1i - 1;
            charArray[c1i] = charArray[c3i];
            charArray[c2i] = charArray[c4i];
            charArray[c3i] = c1;
            charArray[c4i] = c2;
        }
        return new String(charArray);
    }

    /**
     * 16位随机字符串
     */
    public static String createNonceStr() {
        return UUID.randomUUID().toString();
    }

    /**
     * 字节转hex字符串
     */
    public static String byteToHex( final  byte [] hash) {
        Formatter formatter =  new  Formatter();
        for  ( byte  b : hash)
        {
            formatter.format( "%02x" , b);
        }
        String result = formatter.toString();
        formatter.close();
        return  result;
    }
}
