package com.xuefeng.algorithm;

import static com.xuefeng.algorithm.Util.randomArr;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = randomArr(80000, 80000);
        Long start = System.currentTimeMillis();
//        insertionSort(arr);
        insertionSortImprove(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(",");
        }
    }


    /**
     * 插入排序
     *  算法描述：
     *      1.从第一个元素开始，认为该元素已经被排序
     *      2.取下一个元素，在已经排序的元素序列中从后向前扫描
     *      3.如果该元素（已排序）大于新元素，将该元素移到下一位置
     *      4.重复步骤3，直到找到已排序的元素小于或等于新元素的位置
     *      5.将新元素插入到该位置
     *      6.重复2~5
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
//            printArr(arr, i-1);
//            System.out.println("第" + i + "次排序");
        }
        return arr;
    }

    /**
     * 插入排序改进： in-place
     *  使用一个数组以外的空间临时保存数据，然后只需一层遍历数组
     * @param arr
     * @return
     */
    public static int[] insertionSortImprove(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        int preIndex, current;
        for (int i = 0; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex +1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
//        printArr(arr, 1);

        return arr;
    }
}
