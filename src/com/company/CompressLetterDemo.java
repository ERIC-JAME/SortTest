package com.company;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 压缩字符
 * 如：aaabbbccef 打印出a3b2c2ef
 */
public class CompressLetterDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符");
        String s = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ch) {
                count++;
            } else {
                sb.append(ch);
                sb.append(count);
                ch = s.charAt(i);
                count = 1;
            }
        }
        sb.append(ch);
        sb.append(count);
        System.out.println(sb.toString());
    }
}
