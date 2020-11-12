package com.xuefeng.leetcode;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OrderArraySearch_Sword_53_I {


    /**
     * 有序数组查找：
     *      1.折半查找
     *      2.暴力循环O(N)
     * @param nums
     * @param target
     * @return
     */

    /**
     * 暴力循环
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return total;
            }
            if (nums[i] == target) {
                total++;
            }
        }
        return total;
    }


    /**
     * 折半查找：
     *      1.数组中有target这个数，找到之后前后遍历一下
     *      2.数组中没有target这个数，则一直折半到底
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {

        int total = 0;
        int min = 0;
        int max = nums.length - 1;
        int middle = (min+max) / 2;
        for (int i = middle; max >= min; i = (max+min) / 2 ) {
            if (nums[i] > target) {
                max = i - 1;
            }
            if (nums[i] < target) {
                min = i + 1;
            }
            if (nums[i] == target) {
                total++;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == target) {
                        total++;
                    } else {
                        break;
                    }
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target) {
                        total++;
                    } else {
                        break;
                    }
                }
                return total;
            }
        }

        return total;
    }


    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }




    public static void main(String[] args) {
        int[] a = {5,7,7,8,8,10};
        int target = 6;


//        System.out.println(search1(a, target));
        System.out.println(search2(a, target));
    }
}
