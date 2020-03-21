package com.niklai.leetcode.array;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Arrays {
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

    public static List<Integer> spiralOrder(int[][] matrix) {
        return null;
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
