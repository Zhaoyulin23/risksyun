package com.xj.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.security.MessageDigest;

public final class PubFunction {
	 //SHA-1 160为算�?
    public static String getSHA(String spara) {
        String sRtn = null;
        try {
            byte[] plainText = spara.getBytes("UTF8");

            // 使用getInstance("算法")来获得消息摘�?这里使用SHA-1�?60位算�?
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            // �?��使用算法
            messageDigest.update(plainText);
            // 输出算法运算结果
            sRtn = new BASE64Encoder().encode(messageDigest.digest());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sRtn;
    }
}
