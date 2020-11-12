package com.xuefeng.algorithm;

public class Util {

    public static void printArr(int[] arr, int i) {
        // 输出记录
        String num = "";
        for (int j = 0; j < arr.length; j++) {
            num = num +","+ arr[j];
        }
        System.out.println("第"+(i+1)+"次排序：" + num);
    }

    /**
     * 随机生成一个小于m的包含n个元素的数组
     * @return
     */
    public static int[] randomArr(int n,int m) {
        String init = "";
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.ceil(Math.random() * m);
            init = init +","+ arr[i];
        }
        System.out.println("数组初始化：" + init);
        return arr;
    }

    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        // arr[b] = arr[a]
        arr[b] = arr[a] - arr[b];
        // arr[a] = arr[b]
        arr[a] = arr[a] - arr[b];
    }

    /**
     * 计算对数工具，由数学公式
     *      logx(y) = loge(y) / loge(x)
     * @param value
     * @param base
     * @return
     */
    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }


}
