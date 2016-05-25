package ru.tustrip.portal.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by antonorlov on 26/05/16.
 */
public class PortalRandomUtils {


    public static String generatePassword() {

        return RandomStringUtils.random(5, true, true);
    }


    public static String generateCouponNum() {

        String random = RandomStringUtils.random(12, false, true);
        String[] parts = getParts(random, 3);
        String result = parts[0];

        for (int i = 1; i < parts.length; i++) {
            result += "-" + parts[i];
        }

        return result;
    }

    private static String[] getParts(String string, int partitionSize) {
        int parts = string.length() / partitionSize;
        String[] arr = new String[parts];
        int len = string.length();
        for (int i = 0; i < parts; i++  ) {
            arr[i] = string.substring(i * partitionSize, (i* partitionSize) + partitionSize);
        }
        return arr;
    }
}
