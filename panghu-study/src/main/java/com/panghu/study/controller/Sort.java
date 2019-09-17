package com.panghu.study.controller;


import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {0, 9, 4, 5, 3};
        //straightInsertSort(array);
        straightSelectSort(array);
    }

    /**
     * 直接插入排序
     */
    private static int[] straightInsertSort(int[] array) {
        int i, j;
        for (i = 2; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                //哨兵,0不存储元素,防止数组越界
                array[0] = array[i];
                for (j = i - 1; array[j] > array[0]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = array[0];
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * 直接选择排序
     */
    private static int[] straightSelectSort(int[] array) {
        int i, j, temp;
        for (i = 0; i < array.length - 1; i++) {
            temp = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[temp]) {
                    temp = j;
                }
            }
            if (temp != i) {
                int flag = array[temp];
                array[temp] = array[i];
                array[i] = flag;
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
