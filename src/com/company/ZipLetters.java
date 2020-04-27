package com.company;

public class ZipLetters {
    public static String compressBetter(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char last = s.charAt(0); //recode the pre char
        int length = s.length();
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                stringBuilder.append(last);
                stringBuilder.append(count ==1 ? "":count);
                last = s.charAt(i);
                count = 1;
            }
        }
        // solve the last char
        stringBuilder.append(last);
        stringBuilder.append(count ==1 ? "":count);
        // judge the length
        // maybe you can judge the length in the start, but it will increase the complexity
        return stringBuilder.length() > length ? s : stringBuilder.toString();
    }

}
class Test{
    public static void main(String[] args) {
        String aaabbbccdddef = ZipLetters.compressBetter("aaabbbccdddef");
        System.out.println(aaabbbccdddef);
    }
}
