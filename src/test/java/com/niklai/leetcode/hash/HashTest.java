package com.niklai.leetcode.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashTest {

    @Test
    @DisplayName("只出现一次的数字")
    public void singleNumberTest() {
        int result = Hash.singleNumber(new int[]{4, 1, 2, 1, 2});
        Assertions.assertEquals(4, result);
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
}
