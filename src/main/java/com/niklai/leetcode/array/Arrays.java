package com.niklai.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Arrays {

    /**
     * @param nums
     * @return
     * @see ArraysTest#pivotIndexTest()
     */
    //    给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
    //
    //    我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
    //
    //    如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
    //
    //    示例 1:
    //
    //    输入:
    //    nums = [1, 7, 3, 6, 5, 6]
    //    输出: 3
    //    解释:
    //    索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
    //    同时, 3 也是第一个符合要求的中心索引。
    //
    //    示例 2:
    //
    //    输入:
    //    nums = [1, 2, 3]
    //    输出: -1
    //    解释:
    //    数组中不存在满足此条件的中心索引。
    //
    //    说明:
    //
    //    nums 的长度范围为 [0, 10000]。
    //    任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }

            if (left == right) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            boolean invalid = true;

            for (int j = 0; j < i; j++) {
                if (target < nums[j] * 2) {
                    invalid = false;
                    break;
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (target < nums[j] * 2) {
                    invalid = false;
                    break;
                }
            }

            if (invalid) {
                return i;
            }
        }

        return -1;
    }

    public static int[] plusOne(int[] digits) {
        Stack<Integer> nums = new Stack<>();
        int a = 1;
        int i = digits.length - 1;
        while (true) {
            int tmp = digits[i] + a;
            if (tmp >= 10) {
                nums.push(tmp % 10);
                a = tmp / 10;
            } else {
                nums.push(tmp);
                a = 0;
            }

            if (i == 0) {
                if (a != 0) {
                    nums.push(a);
                }
                break;
            }

            i--;
        }

        int[] result = new int[nums.size()];
        int j = 0;
        while (!nums.isEmpty()) {
            result[i] = nums.pop();
            i++;
        }

        return result;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        // 行长度
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }

        int n = matrix[0].length;
        if (n == 0) {
            return new int[0];
        }

        int length = m * n;
        int[] result = new int[length];
        int t = 0;
        int i = 0;
        int j = 0;
        while (t < length) {
            result[t] = matrix[i][j];

            if ((i + j) % 2 == 0) {
                // 先判断右边界
                if (j == n - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                // 先判断下边界
                if (i == m - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }

            t++;
        }

        return result;
    }

    /**
     * @param matrix
     * @return
     * @see ArraysTest#spiralOrderTest()
     */
    //    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    //
    //    示例 1:
    //
    //    输入:
    //            [
    //            [ 1, 2, 3 ],
    //            [ 4, 5, 6 ],
    //            [ 7, 8, 9 ]
    //            ]
    //    输出: [1,2,3,6,9,8,7,4,5]
    //
    //    示例 2:
    //
    //    输入:
    //            [
    //            [1, 2, 3, 4],
    //            [5, 6, 7, 8],
    //            [9,10,11,12]
    //            ]
    //    输出: [1,2,3,4,8,12,11,10,9,5,6,7]
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (true) {
            visited[i][j] = true;
            result.add(matrix[i][j]);

            if ((i - 1 < 0 || visited[i - 1][j]) && j + 1 < cols && !visited[i][j + 1]) {
                j++;
            } else if ((j + 1 == cols || visited[i][j + 1]) && i + 1 < rows && !visited[i + 1][j]) {
                i++;
            } else if ((i + 1 == rows || visited[i + 1][j]) && j - 1 >= 0 && !visited[i][j - 1]) {
                j--;
            } else if ((j - 1 < 0 || visited[i][j - 1]) && i - 1 >= 0 && !visited[i - 1][j]) {
                i--;
            } else {
                break;
            }
        }

        return result;
    }

    /**
     * @param numRows
     * @return
     * @see ArraysTest#generateTest()
     */
    //    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    //
    //    在杨辉三角中，每个数是它左上方和右上方的数的和。
    //
    //    示例:
    //
    //    输入: 5
    //    输出:
    //    [
    //         [1],
    //        [1,1],
    //       [1,2,1],
    //      [1,3,3,1],
    //     [1,4,6,4,1]
    //    ]
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < numRows; r++) {
            ArrayList<Integer> item = new ArrayList<>();
            if (r == 0) {
                item.add(1);
            } else {
                for (int c = 0; c < r + 1; c++) {
                    if (c == 0 || c == r) {
                        item.add(c, 1);
                    } else {
                        List<Integer> pre = result.get(r - 1);
                        item.add(c, pre.get(c - 1) + pre.get(c));
                    }
                }
            }
            result.add(item);
        }

        return result;
    }

    /**
     * @param a
     * @param b
     * @return
     * @see ArraysTest#addBinaryTest()
     */
    //    给你两个二进制字符串，返回它们的和（用二进制表示）。
    //
    //    输入为 非空 字符串且只包含数字 1 和 0。
    //
    //
    //
    //    示例 1:
    //
    //    输入: a = "11", b = "1"
    //    输出: "100"
    //
    //    示例 2:
    //
    //    输入: a = "1010", b = "1011"
    //    输出: "10101"
    //
    //
    //
    //    提示：
    //
    //    每个字符串仅由字符 '0' 或 '1' 组成。
    //            1 <= a.length, b.length <= 10^4
    //    字符串如果不是 "0" ，就都不含前导零。
    public static String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        String result = "";
        int n = 0;
        int aIdx = aChar.length - 1;
        int bIdx = bChar.length - 1;
        while (aIdx >= 0 || bIdx >= 0) {
            int i = 0;
            if (aIdx >= 0 && bIdx >= 0) {
                i = Integer.valueOf(String.valueOf(aChar[aIdx])) + Integer.valueOf(String.valueOf(bChar[bIdx])) + n;
                aIdx--;
                bIdx--;
            } else if (aIdx >= 0) {
                i = Integer.valueOf(String.valueOf(aChar[aIdx])) + n;
                aIdx--;
            } else if (bIdx >= 0) {
                i = Integer.valueOf(String.valueOf(bChar[bIdx])) + n;
                bIdx--;
            }

            n = i / 2;
            i = i % 2;
            result = i + result;
        }

        while (n > 0) {
            result = n % 2 + result;
            n = n / 2;
        }

        return result;
    }

    /**
     * @param haystack
     * @param needle
     * @return
     * @see ArraysTest#strStrTest()
     */
    //    实现 strStr() 函数。
    //
    //    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    //
    //    示例 1:
    //
    //    输入: haystack = "hello", needle = "ll"
    //    输出: 2
    //
    //    示例 2:
    //
    //    输入: haystack = "aaaaa", needle = "bba"
    //    输出: -1
    //
    //    说明:
    //
    //    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    //
    //    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        char[] hayStackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        for (int i = 0; i < hayStackChar.length; i++) {
            int j = 0;
            if (hayStackChar[i] == needleChar[j]) {
                int ii = i;
                while (ii + 1 < hayStackChar.length && j + 1 < needleChar.length
                        && hayStackChar[ii + 1] == needleChar[j + 1]) {
                    ii++;
                    j++;
                }

                if (j + 1 == needleChar.length) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * @param strs
     * @return
     * @see ArraysTest#longestCommonPrefixTest()
     */
    //    编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //    如果不存在公共前缀，返回空字符串 ""。
    //
    //    示例 1:
    //
    //    输入: ["flower","flow","flight"]
    //    输出: "fl"
    //
    //    示例 2:
    //
    //    输入: ["dog","racecar","car"]
    //    输出: ""
    //    解释: 输入不存在公共前缀。
    //
    //    说明:
    //
    //    所有输入只包含小写字母 a-z。
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        HashSet<String> set = new HashSet<>();
        int i = 0;
        boolean allMatch = true;
        while (allMatch) {
            for (String str : strs) {
                if (i < str.length()) {
                    set.add(str.substring(i, i + 1));
                } else {
                    allMatch = false;
                    break;
                }
            }

            if (set.size() != 1 || !allMatch) {
                break;
            }

            sb.append(set.stream().findFirst().get());
            set.clear();
            i++;
        }

        return sb.toString();
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 1;
        int j = 1;
        int current = nums[0];
        for (; j < nums.length; ++j) {
            if (current == nums[i]) {
                continue;
            } else {
                current = nums[j];
                nums[i] = current;
                ++i;
            }
        }

        return i;
    }

    public static void rotate(int[] nums, int k) {
        while (k > 0) {
            int n = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }

            nums[0] = n;
            --k;
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }

        return set.size() != nums.length;
    }
}
