package com.niklai.leetcode.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StacksTest {
    @Test
    @DisplayName("最小栈")
    public void MinStackTest() {
        Stacks.MinStack minStack = new Stacks.MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        Assertions.assertEquals(-1024, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(-1024, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(512, minStack.getMin());
    }

    @Test
    @DisplayName("有效的括号")
    public void isValidTest() {
        Assertions.assertTrue(Stacks.isValid("()"));
        Assertions.assertTrue(Stacks.isValid("()[]{}"));
        Assertions.assertTrue(!Stacks.isValid("(]"));
        Assertions.assertTrue(!Stacks.isValid("([)]"));
        Assertions.assertTrue(Stacks.isValid("{[]}"));
    }

    @Test
    @DisplayName("每日温度")
    public void dailyTemperaturesTest() {
        int[] result = Stacks.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(result);
    }

    @Test
    @DisplayName("逆波兰表达式求值")
    public void evalRPNTest() {
        Assertions.assertEquals(9, Stacks.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assertions.assertEquals(6, Stacks.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        Assertions.assertEquals(22, Stacks.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    @Test
    @DisplayName("字符串解码")
    public void decodeStringTest(){
        String result = Stacks.decodeString("3[a]2[bc]");
        Assertions.assertEquals("aaabcbc", result);

        result = Stacks.decodeString("3[a2[c]]");
        Assertions.assertEquals("accaccacc", result);

        result = Stacks.decodeString("2[abc]3[cd]ef");
        Assertions.assertEquals("abcabccdcdcdef", result);

        result = Stacks.decodeString("10[leetcode]");
        Assertions.assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode", result);
    }
}
