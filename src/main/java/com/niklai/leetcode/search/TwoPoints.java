package com.niklai.leetcode.search;

import com.niklai.leetcode.tree.two.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoPoints {

    /**
     * @param nums
     * @param target
     * @return
     * @see TwoPointsTest#searchTest()
     */
    //    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    //
    //
    //    示例 1:
    //
    //        输入: nums = [-1,0,3,5,9,12], target = 9
    //        输出: 4
    //        解释: 9 出现在 nums 中并且下标为 4
    //
    //    示例 2:
    //
    //        输入: nums = [-1,0,3,5,9,12], target = 2
    //        输出: -1
    //        解释: 2 不存在 nums 中因此返回 -1
    //
    //
    //
    //    提示：
    //
    //        你可以假设 nums 中的所有元素是不重复的。
    //        n 将在 [1, 10000]之间。
    //        nums 的每个元素都将在 [-9999, 9999]之间。
    public static int search(int[] nums, int target) {
        return searchItem(nums, 0, nums.length - 1, target);
    }

    private static int searchItem(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            return nums[end] == target ? end : -1;
        }

        int midd = (start + end) / 2;
        if (nums[midd] > target) {
            return searchItem(nums, start, midd - 1, target);
        } else if (nums[midd] < target) {
            return searchItem(nums, midd + 1, end, target);
        } else {
            return midd;
        }
    }

    /**
     * @param x
     * @return
     * @see TwoPointsTest#mySqrtTest()
     */
    //    实现 int sqrt(int x) 函数。
    //
    //    计算并返回 x 的平方根，其中 x 是非负整数。
    //
    //    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    //
    //    示例 1:
    //
    //        输入: 4
    //        输出: 2
    //
    //    示例 2:
    //
    //        输入: 8
    //        输出: 2
    //        说明: 8 的平方根是 2.82842...,
    //        由于返回类型是整数，小数部分将被舍去。
    public static int mySqrt(int x) {
        int start = 0;
        int end = x / 2 + 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid > x) {
                end = (int) (mid - 1);
            } else if (mid * mid < x) {
                start = (int) (mid + 1);
            } else {
                return (int) mid;
            }
        }

        return end;
    }

    /**
     * @param nums
     * @param target
     * @return
     * @see TwoPointsTest#rotateSearchTest()
     */
    //    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //
    //    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //
    //    你可以假设数组中不存在重复的元素。
    //
    //    你的算法时间复杂度必须是 O(log n) 级别。
    //
    //    示例 1:
    //
    //      输入: nums = [4,5,6,7,0,1,2], target = 0
    //      输出: 4
    //
    //    示例 2:
    //
    //      输入: nums = [4,5,6,7,0,1,2], target = 3
    //      输出: -1
    public static int rotateSearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] < nums[mid]) {
                // 左侧顺序
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[start] > nums[mid]) {
                // 右侧顺序
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] == target) {
                    return start;
                } else {
                    start = mid + 1;
                }
            }
        }

        return nums[end] == target ? end : -1;
    }

    /**
     * @param nums
     * @return
     * @see TwoPointsTest#findPeakElementTest()
     */
    //    峰值元素是指其值大于左右相邻值的元素。
    //
    //    给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
    //
    //    数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
    //
    //    你可以假设 nums[-1] = nums[n] = -∞。
    //
    //    示例 1:
    //
    //    输入: nums = [1,2,3,1]
    //    输出: 2
    //    解释: 3 是峰值元素，你的函数应该返回其索引 2。
    //
    //    示例 2:
    //
    //    输入: nums = [1,2,1,3,5,6,4]
    //    输出: 1 或 5
    //    解释: 你的函数可以返回索引 1，其峰值元素为 2；
    //    或者返回索引 5， 其峰值元素为 6。
    //
    //    说明:
    //
    //    你的解法应该是 O(logN) 时间复杂度的。
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == left) {
                return nums[left] > nums[right] ? left : right;
            }
            if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid;
            }
        }

        return 0;
    }

    /**
     * @param nums
     * @return
     * @see TwoPointsTest#findMinTest()
     */
    //    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //
    //    请找出其中最小的元素。
    //
    //    你可以假设数组中不存在重复元素。
    //
    //    示例 1:
    //
    //    输入: [3,4,5,1,2]
    //    输出: 1
    //
    //    示例 2:
    //
    //    输入: [4,5,6,7,0,1,2]
    //    输出: 0
    public static int findMin(int[] nums) {
        return findMinItem(nums, 0, nums.length - 1);
    }

    private static int findMinItem(int[] nums, int left, int right) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (left + 1 == right) {
            return nums[left] < nums[right] ? nums[left] : nums[right];
        }

        int mid = (left + right) / 2;
        int leftMin = findMinItem(nums, left, mid);
        int rightMin = findMinItem(nums, mid, right);
        return leftMin < rightMin ? leftMin : rightMin;
    }

    /**
     * @param nums
     * @param target
     * @return
     * @see TwoPointsTest#searchRangeTest()
     */
    //    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //
    //    你的算法时间复杂度必须是 O(log n) 级别。
    //
    //    如果数组中不存在目标值，返回 [-1, -1]。
    //
    //    示例 1:
    //
    //    输入: nums = [5,7,7,8,8,10], target = 8
    //    输出: [3,4]
    //
    //    示例 2:
    //
    //    输入: nums = [5,7,7,8,8,10], target = 6
    //    输出: [-1,-1]
    public static int[] searchRange(int[] nums, int target) {
        int[] r = new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        int m = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                m = mid;
                break;
            }
        }

        if (m == -1) {
            return r;
        }

        for (int i = m; i >= 0; i--) {
            if (nums[i] == target) {
                r[0] = i;
            } else {
                break;
            }
        }

        for (int i = m; i < nums.length; i++) {
            if (nums[i] == target) {
                r[1] = i;
            } else {
                break;
            }
        }

        return r;
    }

    /**
     * @param arr
     * @param k
     * @param x
     * @return
     * @see TwoPointsTest#findClosestElementsTest()
     */
    //    给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
    //
    //    示例 1:
    //
    //    输入: [1,2,3,4,5], k=4, x=3
    //    输出: [1,2,3,4]
    //
    //
    //
    //    示例 2:
    //
    //    输入: [1,2,3,4,5], k=4, x=-1
    //    输出: [1,2,3,4]
    //
    //
    //
    //    说明:
    //
    //    k 的值为正数，且总是小于给定排序数组的长度。
    //    数组不为空，且长度不超过 104
    //    数组里的每个元素与 x 的绝对值不超过 104
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr[0] >= x) {
            return Arrays.stream(Arrays.copyOfRange(arr, 0, k > arr.length ? arr.length : k)).boxed().collect(Collectors.toList());
        }

        if (arr[arr.length - 1] <= x) {
            return Arrays.stream(Arrays.copyOfRange(arr, arr.length - k <= 0 ? 0 : arr.length - k, arr.length)).boxed().collect(Collectors.toList());
        }

        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                left = mid;
                break;
            }

            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        int idx = Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
        left = idx;
        right = idx;
        while (Math.abs(right - left) < (k - 1) && (left != 0 || right != arr.length - 1)) {
            if (left - 1 < 0) {
                right++;
                continue;
            }

            if (right + 1 >= arr.length) {
                left--;
                continue;
            }

            if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
                left--;
            } else {
                right++;
            }
        }

        return Arrays.stream(Arrays.copyOfRange(arr, left, right + 1)).boxed().collect(Collectors.toList());
    }

    /**
     * @param root
     * @param target
     * @return
     * @see TwoPointsTest#closestValueTest()
     */
    //    给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
    //
    //    注意：
    //
    //    给定的目标值 target 是一个浮点数
    //            题目保证在该二叉搜索树中只会存在一个最接近目标值的数
    //
    //    示例：
    //
    //    输入: root = [4,2,5,1,3]，目标值 target = 3.714286
    //
    //              4
    //             / \
    //            2   5
    //           / \
    //          1   3
    //
    //    输出: 4
    public static int closestValue(TreeNode root, double target) {
        Integer left = null;
        Integer right = null;

        TreeNode n = root;
        while (n != null) {
            if (n.val > target) {
                right = n.val;
                n = n.left;
            } else if (n.val < target) {
                left = n.val;
                n = n.right;
            } else {
                return n.val;
            }
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return right - target < target - left ? right : left;
    }

    /**
     * @param reader
     * @param target
     * @return
     * @see TwoPointsTest#searchTese()
     */
    //    给定一个升序整数数组，写一个函数搜索 nums 中数字 target。如果 target 存在，返回它的下标，否则返回 -1。注意，这个数组的大小是未知的。你只可以通过 ArrayReader 接口访问这个数组，ArrayReader.get(k) 返回数组中第 k 个元素（下标从 0 开始）。
    //
    //    你可以认为数组中所有的整数都小于 10000。如果你访问数组越界，ArrayReader.get 会返回 2147483647。
    //
    //
    //
    //    样例 1：
    //
    //    输入: array = [-1,0,3,5,9,12], target = 9
    //    输出: 4
    //    解释: 9 存在在 nums 中，下标为 4
    //
    //    样例 2：
    //
    //    输入: array = [-1,0,3,5,9,12], target = 2
    //    输出: -1
    //    解释: 2 不在数组中所以返回 -1
    //
    //
    //
    //    注释 ：
    //
    //    你可以认为数组中所有元素的值互不相同。
    //    数组元素的值域是 [-9999, 9999]。
    public static int search(ArrayReader reader, int target) {
        int mid = 0;
        while (reader.get(mid) != Integer.MAX_VALUE && reader.get(mid * 2 + 2) != Integer.MAX_VALUE) {
            mid++;
        }

        int length = reader.get(mid * 2 + 1) != Integer.MAX_VALUE ? mid * 2 + 2 : mid * 2 + 1;

        int left = 0;
        int right = length - 1;
        while (left <= right) {
            if (reader.get(mid) == target) {
                return mid;
            }

            if (reader.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        return -1;
    }

    public static class Solution extends VersionControl {
        /**
         * @param n
         * @return
         * @see TwoPointsTest#firstBadVersionTest()
         */
        //    你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
        //
        //    假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
        //
        //    你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
        //
        //    示例:
        //
        //        给定 n = 5，并且 version = 4 是第一个错误的版本。
        //
        //        调用 isBadVersion(3) -> false
        //        调用 isBadVersion(5) -> true
        //        调用 isBadVersion(4) -> true
        //
        //    所以，4 是第一个错误的版本。
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            while (left < right) {
                int mid = Math.toIntExact(((long) left + (long) right) / 2);
                if (isBadVersion(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

    static class ArrayReader {
        private int[] arr;

        public ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int key) {
            if (key < 0 || key >= arr.length) {
                return Integer.MAX_VALUE;
            }

            return arr[key];
        }
    }

    /**
     * @param x
     * @param n
     * @return
     * @see TwoPointsTest#myPowTest()
     */
    //    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    //
    //    示例 1:
    //
    //    输入: 2.00000, 10
    //    输出: 1024.00000
    //
    //    示例 2:
    //
    //    输入: 2.10000, 3
    //    输出: 9.26100
    //
    //    示例 3:
    //
    //    输入: 2.00000, -2
    //    输出: 0.25000
    //    解释: 2-2 = 1/22 = 1/4 = 0.25
    //
    //    说明:
    //
    //            -100.0 < x < 100.0
    //    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0.0;
        }

        if (n == 0) {
            return 1.0;
        }

        long nn = n;
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }

        return myPowItem(x, nn);
    }

    private static double myPowItem(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = myPowItem(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }

    /**
     * @param num
     * @return
     * @see TwoPointsTest#isPerfectSquareTest()
     */
    //    给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
    //
    //    说明：不要使用任何内置的库函数，如  sqrt。
    //
    //    示例 1：
    //
    //    输入：16
    //    输出：True
    //
    //    示例 2：
    //
    //    输入：14
    //    输出：False
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long left = 2;
        long right = num / 2;

        while (left <= right) {
            long mid = (left + right) / 2;
            long n = mid * mid;
            if (n > num) {
                right = mid - 1;
            } else if (n < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * @param letters
     * @param target
     * @return
     * @see TwoPointsTest#nextGreatestLetterTest()
     */
    //    给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
    //
    //    在比较时，字母是依序循环出现的。举个例子：
    //
    //    如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
    //
    //
    //
    //    示例：
    //
    //    输入:
    //    letters = ["c", "f", "j"]
    //    target = "a"
    //    输出: "c"
    //
    //    输入:
    //    letters = ["c", "f", "j"]
    //    target = "c"
    //    输出: "f"
    //
    //    输入:
    //    letters = ["c", "f", "j"]
    //    target = "d"
    //    输出: "f"
    //
    //    输入:
    //    letters = ["c", "f", "j"]
    //    target = "g"
    //    输出: "j"
    //
    //    输入:
    //    letters = ["c", "f", "j"]
    //    target = "j"
    //    输出: "c"
    //
    //    输入:
    //    letters = ["c", "f", "j"]
    //    target = "k"
    //    输出: "c"
    //
    //
    //
    //    提示：
    //
    //    letters长度范围在[2, 10000]区间内。
    //    letters 仅由小写字母组成，最少包含两个不同的字母。
    //    目标字母target 是一个小写字母。
    public static char nextGreatestLetter(char[] letters, char target) {
        if (target < letters[0] || letters[letters.length - 1] <= target) {
            return letters[0];
        }

        int left = 0;
        int right = letters.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (letters[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return letters[right];
    }

    /**
     * @param nums
     * @return
     * @see TwoPointsTest#findMinRepeatTest()
     */
    //    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //
    //    请找出其中最小的元素。
    //
    //    注意数组中可能存在重复的元素。
    //
    //    示例 1：
    //
    //    输入: [1,3,5]
    //    输出: 1
    //
    //    示例 2：
    //
    //    输入: [2,2,2,0,1]
    //    输出: 0
    //
    //    说明：
    //
    //    这道题是 寻找旋转排序数组中的最小值 的延伸题目。
    //    允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
    public static int findMinRepeat(int[] nums) {
        return findMinRepeatItem(nums, 0, nums.length - 1);
    }

    private static int findMinRepeatItem(int[] nums, int left, int right) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (left == right) {
            return nums[left];
        }

        if (left + 1 == right) {
            return nums[left] < nums[right] ? nums[left] : nums[right];
        }

        int mid = (left + right) / 2;
        int leftRight = mid;
        int rightLeft = mid;
        while (leftRight - 1 >= left && nums[leftRight - 1] == nums[leftRight]) {
            leftRight = leftRight - 1;
        }

        while (rightLeft + 1 <= right && nums[rightLeft + 1] == nums[rightLeft]) {
            rightLeft = rightLeft + 1;
        }

        int leftNum = findMinRepeatItem(nums, left, leftRight);
        int rightNum = findMinRepeatItem(nums, rightLeft, right);
        return leftNum < rightNum ? leftNum : rightNum;
    }

    /**
     * @param numbers
     * @param target
     * @return
     * @see TwoPointsTest#twoSumTest()
     */
    //    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    //
    //    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    //
    //    说明:
    //
    //    返回的下标值（index1 和 index2）不是从零开始的。
    //    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
    //
    //    示例:
    //
    //    输入: numbers = [2, 7, 11, 15], target = 9
    //    输出: [1,2]
    //    解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int r = numbers[left] + numbers[right];
            if (r == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }

            if (r < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
