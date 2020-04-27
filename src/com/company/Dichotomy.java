package com.company;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

/**
 * 二分法查找
 *
 * @author :
 * @data:
 */
public class Dichotomy {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 7, 9, 4, 5, 1};

       binarySearch(arr,666,0,arr.length-1);
    }

    /**
     *
     * @param arr数组
     * @param i查询的数
     * @param i1最小
     * @param i2最大
     */
    private static void binarySearch(int[] arr, int item, int i1, int i2) {

    }

}
