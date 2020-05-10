package com.niklai.leetcode.hash;

import java.util.*;

public class Hash {

    /**
     * @param nums
     * @return
     * @see HashTest#singleNumberTest()
     */
    //    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    //
    //    说明：
    //
    //    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //
    //    示例 1:
    //
    //    输入: [2,2,1]
    //    输出: 1
    //
    //    示例 2:
    //
    //    输入: [4,1,2,1,2]
    //    输出: 4
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                set.remove(n);
            }
        }

        for (int n : set) {
            return n;
        }

        return Integer.MIN_VALUE;
    }

    /**
     * @param n
     * @return
     * @see HashTest#isHappyTest()
     */
    //    编写一个算法来判断一个数 n 是不是快乐数。
    //
    //    「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
    //
    //    如果 n 是快乐数就返回 True ；不是，则返回 False 。
    //
    //
    //
    //    示例：
    //
    //    输入：19
    //    输出：true
    //    解释：
    //            12 + 92 = 82
    //            82 + 22 = 68
    //            62 + 82 = 100
    //            12 + 02 + 02 = 1
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                int i = n % 10;
                sum += i * i;
                n = (n - i) / 10;
            }

            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            }

            set.add(sum);
            n = sum;
        }
    }

    /**
     * @param s
     * @param t
     * @return
     * @see HashTest#isIsomorphicTest()
     */
    //    给定两个字符串 s 和 t，判断它们是否是同构的。
    //
    //    如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    //
    //    所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    //
    //    示例 1:
    //
    //    输入: s = "egg", t = "add"
    //    输出: true
    //
    //    示例 2:
    //
    //    输入: s = "foo", t = "bar"
    //    输出: false
    //
    //    示例 3:
    //
    //    输入: s = "paper", t = "title"
    //    输出: true
    //
    //    说明:
    //    你可以假设 s 和 t 具有相同的长度。
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        return isIsomorphicItem(s1, s2) && isIsomorphicItem(s2, s1);
    }

    private static boolean isIsomorphicItem(char[] s, char[] t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], t[i]);
            } else {
                if (map.get(s[i]) != t[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @param list1
     * @param list2
     * @return
     * @see HashTest#findRestaurantTest()
     */
    //    假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
    //
    //    你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
    //
    //    示例 1:
    //
    //    输入:
    //            ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    //            ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
    //    输出: ["Shogun"]
    //    解释: 他们唯一共同喜爱的餐厅是“Shogun”。
    //
    //    示例 2:
    //
    //    输入:
    //            ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    //            ["KFC", "Shogun", "Burger King"]
    //    输出: ["Shogun"]
    //    解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
    //
    //    提示:
    //
    //    两个列表的长度范围都在 [1, 1000]内。
    //    两个列表中的字符串的长度将在[1，30]的范围内。
    //    下标从0开始，到列表的长度减1。
    //    两个列表都没有重复的元素。
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        if (map1.size() < map2.size()) {
            for (Map.Entry<String, Integer> item : map1.entrySet()) {
                if (map2.containsKey(item.getKey())) {
                    int r = item.getValue() + map2.get(item.getKey());
                    if (r == min) {
                        list.add(item.getKey());
                    } else if (r < min) {
                        min = r;
                        list.clear();
                        list.add(item.getKey());
                    }
                }
            }
        } else {
            for (Map.Entry<String, Integer> item : map2.entrySet()) {
                if (map1.containsKey(item.getKey())) {
                    int r = item.getValue() + map1.get(item.getKey());
                    if (r == min) {
                        list.add(item.getKey());
                    } else if (r < min) {
                        min = r;
                        list.clear();
                        list.add(item.getKey());
                    }
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
