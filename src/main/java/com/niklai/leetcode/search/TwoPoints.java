package com.niklai.leetcode.search;

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
}
