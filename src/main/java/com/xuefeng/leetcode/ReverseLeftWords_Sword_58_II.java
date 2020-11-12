package com.xuefeng.leetcode;

public class ReverseLeftWords_Sword_58_II {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 示例 1：
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 示例 2：
     *
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     *  
     *
     * 限制：
     *
     * 1 <= k < s.length <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        // 字符串截取拼接
        String substring = s.substring(0, n);
        String remain = s.substring(n);
        return remain.concat(substring);
    }




    /**
     * 3次翻转
     *     作者：chuang-bian-gu-shi
     *     链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/yuan-di-suan-fa-san-ci-fan-zhuan-zi-fu-chuan-ji-ke/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords2(String s, int n) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        s = swapChar(s, 0, n-1);
        s = swapChar(s, n, length - 1);
        s = swapChar(s, 0, length -1);
        return s;
    }

    public static String swapChar(String s, int a, int b) {
        char[] chars = s.toCharArray();
        char c;
        while (a < b) {
            c = chars[a];
            chars[a] = chars[b];
            chars[b] = c;
            a++;
            b--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String words;
//        words = reverseLeftWords("abcdefg", 3);
        words = reverseLeftWords2("abcdefg", 3);
        System.out.println(words);
    }
}
