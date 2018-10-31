package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(byteArrayOutputStream.toByteArray());
        String md5Calculate = new BigInteger(1, m.digest()).toString(16);

        StringBuilder sb = new StringBuilder(32);

        for (int i = 0, count = 32 - md5Calculate.length(); i < count; i++) {
            sb.append("0");
        }
        sb.append(md5Calculate);

        return md5.equals(sb.toString());
    }
}
