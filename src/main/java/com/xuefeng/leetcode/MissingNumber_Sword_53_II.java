package com.xuefeng.leetcode;

public class MissingNumber_Sword_53_II {

    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: [0,1,3]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= 数组长度 <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 分析：数组 递增有序，数字唯一，且数字都在范围0～n-1之内
     * 所以使用 二分查找（折半查找），找到数组中下标与值不相等的第一个位置
     * 可以使用递归
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        return search(nums, 0, nums.length-1);
    }


    public int search(int[] nums, int start, int end) {
        int mid;
        if (nums[0] == 1) {
            return 0;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else if (nums[mid] != mid && nums[mid-1] != mid -1){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return 1;
    }


    /**
     * 算法解析：
     * 排序数组中的搜索问题，首先想到 二分法 解决。
     * 根据题意，数组可以按照以下规则划分为两部分。
     * 左子数组： nums[i] = i；
     * 右子数组： nums[i] ≠ i ；
     * 
     * 缺失的数字等于 “右子数组的首位元素” 对应的索引；因此考虑使用二分法查找 “右子数组的首位元素”
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


}
