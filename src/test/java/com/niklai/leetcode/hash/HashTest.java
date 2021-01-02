package com.niklai.leetcode.hash;

import com.niklai.leetcode.tree.binary.TreeNode;
import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HashTest {
    private Hash hash = new Hash();

    @Test
    @DisplayName("只出现一次的数字")
    public void singleNumberTest() {
        int result = Hash.singleNumber(new int[]{4, 1, 2, 1, 2});
        Assertions.assertEquals(4, result);
    }

    @Test
    @DisplayName("两个数组的交集")
    public void intersectionTest() {
        int[] result = hash.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Assertions.assertArrayEquals(new int[]{2}, result);

        result = hash.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Assertions.assertArrayEquals(new int[]{4, 9}, result);
    }

    @Test
    @DisplayName("快乐数")
    public void isHappyTest() {
        Assertions.assertTrue(Hash.isHappy(19));
        Assertions.assertTrue(!Hash.isHappy(116));
    }

    @Test
    @DisplayName("同构字符串")
    public void isIsomorphicTest() {
        Assertions.assertTrue(Hash.isIsomorphic("egg", "add"));
        Assertions.assertTrue(!Hash.isIsomorphic("foo", "bar"));
        Assertions.assertTrue(Hash.isIsomorphic("paper", "title"));
    }

    @Test
    @DisplayName("两个列表的最小索引总和")
    public void findRestaurantTest() {
        String[] result = Hash.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
        Assertions.assertArrayEquals(new String[]{"Shogun"}, result);

        result = Hash.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        Assertions.assertArrayEquals(new String[]{"Shogun"}, result);
    }

    @Test
    @DisplayName("两数之和")
    public void twoSumTest() {
        int[] result = Hash.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    @DisplayName("字符串中的第一个唯一字符")
    public void firstUniqCharTest() {
        int result = Hash.firstUniqChar("leetcode");
        Assertions.assertEquals(0, result);

        result = Hash.firstUniqChar("loveleetcode");
        Assertions.assertEquals(2, result);

        result = Hash.firstUniqChar("leel");
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("两个数组的交集 II")
    public void intersectTest() {
        int[] result = Hash.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Assertions.assertArrayEquals(new int[]{2, 2}, result);

        result = Hash.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Assertions.assertArrayEquals(new int[]{9, 4}, result);
    }

    @Test
    @DisplayName("存在重复元素 II")
    public void containsNearbyDuplicateTest() {
        boolean result = Hash.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        Assertions.assertTrue(result);

        result = Hash.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
        Assertions.assertTrue(result);

        result = Hash.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
        Assertions.assertTrue(!result);
    }

    @Test
    @DisplayName("日志速率限制器")
    public void logShouldPrintMessageTest() {
        Hash.Logger logger = new Hash.Logger();
        // 日志内容 "foo" 在时刻 1 到达系统
        boolean result = logger.shouldPrintMessage(1, "foo");
        Assertions.assertTrue(result);

        // 日志内容 "bar" 在时刻 2 到达系统
        result = logger.shouldPrintMessage(2, "bar");
        Assertions.assertTrue(result);

        // 日志内容 "foo" 在时刻 3 到达系统
        result = logger.shouldPrintMessage(3, "foo");
        Assertions.assertTrue(!result);

        // 日志内容 "bar" 在时刻 8 到达系统
        result = logger.shouldPrintMessage(8, "bar");
        Assertions.assertTrue(!result);

        // 日志内容 "foo" 在时刻 10 到达系统
        result = logger.shouldPrintMessage(10, "foo");
        Assertions.assertTrue(!result);

        // 日志内容 "foo" 在时刻 11 到达系统
        result = logger.shouldPrintMessage(11, "foo");
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("字母异位词分组")
    public void groupAnagramsTest() {
        List<List<String>> result =
                Hash.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result);
    }

    @Test
    @DisplayName("移位字符串分组")
    public void groupStringsTest() {
        List<List<String>> result =
                Hash.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
        System.out.println(result);
    }

    @Test
    @DisplayName("有效的数独")
    public void isValidSudokuTest() {
        char[][] s1 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = Hash.isValidSudoku(s1);
        Assertions.assertTrue(result);
        s1 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        result = Hash.isValidSudoku(s1);
        Assertions.assertTrue(!result);
    }

    @Test
    @DisplayName("寻找重复的子树")
    public void findDuplicateSubtreesTest() {
        TreeNode root = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n22 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n33 = new TreeNode(3);
        root.left = n2;
        root.right = n22;
        n2.left = n3;
        n22.left = n33;
        List<TreeNode> list = Hash.findDuplicateSubtrees(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("宝石与石头")
    public void numJewelsInStonesTest() {
        int result = Hash.numJewelsInStones("aA", "aAAbbbb");
        Assertions.assertEquals(3, result);

        result = Hash.numJewelsInStones("z", "ZZ");
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("无重复字符的最长子串")
    public void lengthOfLongestSubstringTest() {
        int result = Hash.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(3, result);

        result = Hash.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(1, result);

        result = Hash.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(3, result);

        result = Hash.lengthOfLongestSubstring("");
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("两数之和 III - 数据结构设计")
    public void twoSumClassTest() {
        Hash.TwoSum twoSum1 = new Hash.TwoSum();
        twoSum1.add(1);
        twoSum1.add(3);
        twoSum1.add(5);
        boolean result = twoSum1.find(4);
        Assertions.assertTrue(result);
        result = twoSum1.find(7);
        Assertions.assertTrue(!result);

        Hash.TwoSum twoSum2 = new Hash.TwoSum();
        twoSum2.add(0);
        twoSum2.add(-1);
        twoSum2.add(1);
        result = twoSum2.find(0);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("四数相加 II")
    public void fourSumCountTest() {
        int result = Hash.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2});
        Assertions.assertEquals(2, result);
    }
}
