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
     * 随机生成一个包含10个元素的数组
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
}
