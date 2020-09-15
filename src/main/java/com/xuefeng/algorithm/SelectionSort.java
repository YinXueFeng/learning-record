package com.xuefeng.algorithm;

import static com.xuefeng.algorithm.Util.randomArr;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = randomArr(80000, 80000);

//        int[] arr = {2,1};
        Long start = System.currentTimeMillis();
        selectionSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * 选择排序： 从小到大排序
     *  算法描述：
     *      1.第一次遍历数组，找到数组中最小的数，将第一位的数据与最小的值交换位置
     *      2.从第二个元素开始，找到剩余数组中最小的数，将其与第二个元素交换位置
     *      3.重复以上操作
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int temp;
        int min;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            // 输出
//            printArr(arr, i);
            System.out.println("第" + i + "次排序");
        }
        return arr;
    }

    /**
     * TODO
     * 选择排序算法改进： 从小到大排序
     *  每趟找到当前趟的最大值和最小值
     * @param arr
     * @return
     */
    public static int[] selectionSortImprove1(int[] arr) {

//        int minIndex, maxIndex;
//        for (int i = 0; i < arr.length / 2; i++) {
//            minIndex = i;
//            maxIndex = arr.length - 1 - i;
//            for (int j = 0; j < ; j++) {
//
//            }
//        }

        return arr;
    }

}
