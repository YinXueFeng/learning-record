package com.xuefeng.algorithm;

public class QuickSort {
    /**
     * （分治法）
     * 快速排序：每一轮选取一个基准元素，将比基准元素大的移到一边，而将比基准元素小的移到另一边，把数列分成两个部分
     * 实现有两种方法：
     *
     */

    /**
     * 双边循环法(递归法)
     *
     * <p>
     * I）双边循环法（两边递归）
     *    1.选定基准元素pivot，设置两个指针索引 left right分别指向数列的最左和最右两个元素
     *    2.进行第一次循环，从right指针开始，让指针所指向的元素和基准元素比较。
     *      当大于或等于pivot时，指针左移，否则，right停止移动，切换到left指针。
     *    3.已切换到left指针，让left指针所指向的元素与基准元素比较，
     *      当小雨或等于pivot时，指针右移，否则，left停止移动。
     *    4.重复上述步骤 1，2，3，直到left大于等于right结束。
     * <p>
     *
     * @param arr 待排序数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     */
    public static void quickSortDouble(int[] arr, int startIndex, int endIndex) {
        // 当 startIndex 大于或等于 endIndex 时，结束递归
        if (startIndex >= endIndex) {
            return;
        }
        // 获取基准元素下标索引
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSortDouble(arr, startIndex, pivotIndex - 1);
        quickSortDouble(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {

        // 基准元素的选择可以随机选择，尽量避免选到最大或最小的值
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制right指针比较并左移
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 交换left和right指针所指向的元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // pivot 和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     * II）单边循环法(基准元素选择第一个元素)
     * 1.选定基准元素pivot，设置mark指针指向数列的起始位置，mark指针代表小于基准元素的区域边界
     * 2.从基准元素的下一个元素开始遍历，
     *      a）如果遍历到的元素大于基准元素，继续向后遍历
     *      b）如果遍历到的元素小于基准元素，则，首先，将mark指针右移一位，因为小于pivot的区域边界增大了，
     *          然后，让最新遍历到的元素和mark指针所在的位置的元素交换位置，因为最新遍历的元素归属于小于pivot的区域。
     * 3.重复上述步骤1,2，直到
     *
     */
    public static void quickSortSingle(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex 大于或等于 endIndex 时
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partitionV2(arr, startIndex, endIndex);
        quickSortSingle(arr, startIndex, pivotIndex - 1);
        quickSortSingle(arr, pivotIndex + 1, endIndex);
    }

    private static int partitionV2(int[] arr, int startIndex, int endIndex) {

        // 取第一个位置元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        int temp;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot){
                mark++;
                temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
