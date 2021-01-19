package com.xuefeng.leetcode;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot100_136 {
    public static void main(String[] args) {
        int[] nums = {5,1,2,1,2};
        System.out.println(singleNumber3Set(nums));
    }

    /**
     * 解法一：使用HashMap
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            } else {
                map.put(nums[i],2);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }


    /**
     * 解法二：使用异或运算，位运算
     *      1.何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     *      2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     *      3.异或运算满足交换律和结合律，即 a⊕b⊕a = b⊕a⊕a = b⊕(a⊕a) = b⊕0 = b
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int singleNumber2List(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 解法三：将数组放入set，set集合求和*2，数组求和，相减
     */
    public static int singleNumber3Set(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length / 2 + 1);
        int sum = 0;
        int setSum = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            sum += nums[i];
        }

        for (Integer s : set) {
            setSum += s;
        }
        return setSum * 2 - sum;
    }


}
