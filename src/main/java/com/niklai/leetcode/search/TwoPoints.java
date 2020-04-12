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
}
