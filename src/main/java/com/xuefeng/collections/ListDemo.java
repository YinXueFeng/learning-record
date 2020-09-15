package com.xuefeng.collections;

import java.util.Collection;
import java.util.Map;

public class ListDemo {


    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,4},{2,5},{7,8}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }

    // 稀疏数组进行棋盘复位
    //  0 0 0 0 1 0 1
    //  0 1 0 0 1 0 1
    //  0 0 1 0 1 0 1
    //  0 0 1 0 1 0 0
    //  1 0 0 1 1 0 0
    //  0 0 0 0 1 0 0
    //  0 1 0 0 1 0 0
    // 稀疏数组 第一行表示总共有多少行，多少列，多少个有意义的值
    // row col value
    //  7   7   16
    //  0   4   1
    //  0   6   1
    //  1   1   1
    //  1   4   1
    //  1   6   1
    //  2   2   1
    //  2   4   1
    //  2   6   1
    //  3   2   1
    //  3   4   1

    public int[][] example(int[][] arr) {
//        int col = arr[0][].length;
//        int row = arr[][1].le

        return arr;
    }
}
