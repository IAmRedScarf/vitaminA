package com.qiuyu.leetcode.editor.cn.util;

/**
 * @author qiuyu13
 * @date 2022/2/23
 */
public class NumUtil {
    public static String mySqrt(double x) {
        double cur = x;
        while (Math.abs(cur * cur - x) > 0.00001) {
            cur = (cur + x / cur) / 2;
        }
        return String.format("%.5f", cur);

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1.44));
    }
}
