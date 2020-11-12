package com.xuefeng.algorithm;

import java.util.ArrayList;
import java.util.List;

import static com.xuefeng.algorithm.Util.printArr;
import static com.xuefeng.algorithm.Util.randomArr;
import static com.xuefeng.algorithm.Util.swap;

public class ShellSort {

    public static void main(String[] args) {
        shellSort1(randomArr(10, 100));
        shellSort2(randomArr(10, 100));

    }

    /**
     * 作者： dreamcatcher-cx
     *
     * 出处： <http://www.cnblogs.com/chengxiao/>
     *
     * 希尔排序：交换法
     * @param arr
     * @return
     */
    public static int[] shellSort1(int[] arr) {

        /*int a = 0;*/
        // 设置增量，将数组分组[i,i+gap]一组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            /*System.out.println("gap = " + gap);*/

            int j;
            for (int i = gap; i < arr.length; i++) {
                j = i;

                /*System.out.print("i = " + i);
                System.out.print("\t");
                System.out.print("j = " + j);
                System.out.print("\t");
                System.out.print("j-gap = " + (j-gap));*/

                while (j - gap >= 0 && arr[j] < arr[j - gap]) {

                    /*System.out.print("\t");
                    System.out.print("j = " + j);
                    System.out.print("\t");
                    System.out.print("j-gap = " + (j-gap));*/

                    swap(arr, j, j - gap);
                    j -= gap;
                }
                /*System.out.println();*/

            }
            /*printArr(arr, a++);*/
        }

        return arr;
    }

    /**
     *
     * 作者： dreamcatcher-cx
     *
     * 出处： <http://www.cnblogs.com/chengxiao/>
     *
     *
     * 希尔排序：移动法
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
