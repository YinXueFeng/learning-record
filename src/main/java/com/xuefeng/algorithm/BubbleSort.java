package com.xuefeng.algorithm;

import static com.xuefeng.algorithm.Util.randomArr;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = randomArr(80000, 80000);

        Long start = System.currentTimeMillis();
        bubbleSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    /**
     * 冒泡算法： 从小到大排序 （例）
     *  算法描述：
     *  1.比较相邻的两个元素，如果较大的排在前面，则交换两个元素的位置，否则位置不变
     *  2.对每一对相邻的元素都进行比较
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 冒泡算法改进1：
     *      增加一个标识，当整个数组完成排序之后结束多余的遍历,
     *      完全排完序后，会多遍历一遍
     * @param arr
     * @return
     */
    public static int[] bubbleSortImprove(int[] arr) {
        boolean sorted;
        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    sorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            // 改进
            if (sorted) {
                return arr;
            }
        }
        return arr;
    }

    /**
     * 冒泡排序算法改进2：
     *  分析：第一趟排序，最后一个数是所有数中最大的一个，所以在第二趟排序时，最后一个数不需要比较
     *      同样，第二趟排序之后，倒数第二个数一定是数组中第二大的数，所以第三趟排序时，最后两个数都不需要比较
     * @param arr
     * @return
     */
    public static int[] bubbleSortImprove2(int[] arr) {
        boolean sorted;
        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - (i+1); j++) {
                if (arr[j] > arr[j + 1]) {
                    sorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            // 改进
            if (sorted) {
                return arr;
            }
        }
        return arr;
    }
}
