package com.xuefeng.leetcode;

public class LookupInTwoDimensionalArray {
    /**
     * 面试题4. 二维数组中的查找
     * 在一个 n * m 的二维数组中，
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *  
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     *  
     *
     * 限制：
     *
     * 0 <= n <= 1000
     *
     * 0 <= m <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    /**
     * 1.判断二维数组行为空
     * 2.判断二维数组列为空
     * 3.遍历每一行的第一个 ，
     *      若 matrix[i][0] => target，
     *          若该行最后一个元素 matrix[i][matrix[0].length] <= target，则遍历该行
     *          否则进入下一行，再判断该行最后一个元素
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int length1 = matrix.length;
        if (length1 == 0) {
            return false;
        }
        int len = matrix[0].length;
        if (len == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][len - 1]) {
                for (int j = 0; j < len; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * 使用折半（二分）查找
     *
     * 1.判断二维数组行为空：length1 = matrix.length  ,  length1 == 0 ?
     * 2.判断二维数组列为空: length2 = matrix[0].length  ,  length2 == 0 ?
     * 3.判断二维数组第一个元素与最后一个元素与target的大小，
     *      若 target > matrix[0][0] 或者 target < matrix[length1][length2] ,return false;
     * 3.对二维数组的每行第一列使用 二分查找，找到 matrix[i][0] <= target 的行 i
     * 4.对二维数组的最后一列使用 二分查找（从 matrix[i][length2-1]开始），
     *      找到 matrix[j][length2-1] >= target 的
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArrayByBinarySearch(int[][] matrix, int target) {
        int length1 = matrix.length;
        if (length1 == 0) {
            return false;
        }
        int len = matrix[0].length;
        if (len == 0) {
            return false;
        }
        int start, end, mid;
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][len - 1]) {
                start = 0;
                end = len - 1;
                while (end >= start) {
                    mid = (end + start) / 2;
                    if (matrix[i][mid] == target) return true;
                    else if (matrix[i][mid] < target) start = mid + 1;
                    else end = mid - 1;
                }
            }
        }
        return false;
    }


    /**
     * 由于给定的二维数组具备每行从左到右递增以及每列从上到下递增的特点，当访问到一个元素时，可以排除数组中的部分元素。
     *
     *  从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
     *  如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     *
     * 可以证明这种方法不会错过目标值。
     * 如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，
     *  因此往下查找不可能找到目标值，往左查找可能找到目标值。
     * 如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。
     *
     * 若数组为空，返回 false
     * 初始化行下标为 0，列下标为二维数组的列数减 1
     * 重复下列步骤，直到行下标或列下标超出边界
     * 获得当前下标位置的元素 num
     *  如果 num 和 target 相等，返回 true
     *  如果 num 大于 target，列下标减 1
     *  如果 num 小于 target，行下标加 1
     * 循环体执行完毕仍未找到元素等于 target ，说明不存在这样的元素，返回 false`
     * Java
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-b-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{5},{6}};

        System.out.println(findNumberIn2DArrayByBinarySearch(matrix, 6));

    }

}
