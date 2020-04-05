package com.niklai.leetcode.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Stacks {
    //    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //
    //    有效字符串需满足：
    //
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //
    //    注意空字符串可被认为是有效字符串。
    //
    //    示例 1:
    //
    //    输入: "()"
    //    输出: true
    //
    //    示例 2:
    //
    //    输入: "()[]{}"
    //    输出: true
    //
    //    示例 3:
    //
    //    输入: "(]"
    //    输出: false
    //
    //    示例 4:
    //
    //    输入: "([)]"
    //    输出: false
    //
    //    示例 5:
    //
    //    输入: "{[]}"
    //    输出: true
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    return false;
                } else {
                    st.pop();
                }
            } else if (c == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    return false;
                } else {
                    st.pop();
                }
            } else if (c == '}') {
                if (st.isEmpty() || st.peek() != '{') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        return st.isEmpty();
    }

    //    根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
    //
    //    例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
    //
    //    提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && T[i] >= T[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = st.peek() - i;
            }

            st.add(i);
        }

        return result;
    }

    //    根据逆波兰表示法，求表达式的值。
    //
    //    有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    //
    //    说明：
    //
    //    整数除法只保留整数部分。
    //    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
    //
    //    示例 1：
    //
    //    输入: ["2", "1", "+", "3", "*"]
    //    输出: 9
    //    解释: ((2 + 1) * 3) = 9
    //
    //    示例 2：
    //
    //    输入: ["4", "13", "5", "/", "+"]
    //    输出: 6
    //    解释: (4 + (13 / 5)) = 6
    //
    //    示例 3：
    //
    //    输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    //    输出: 22
    //    解释:
    //            ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    //            = ((10 * (6 / (12 * -11))) + 17) + 5
    //            = ((10 * (6 / -132)) + 17) + 5
    //            = ((10 * 0) + 17) + 5
    //            = (0 + 17) + 5
    //            = 17 + 5
    //            = 22
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        for (String s : tokens) {
            if (operators.contains(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.peek();
    }

    //    设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//    push(x) -- 将元素 x 推入栈中。
//    pop() -- 删除栈顶的元素。
//    top() -- 获取栈顶元素。
//    getMin() -- 检索栈中的最小元素。
//
//    示例:
//
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.getMin();   --> 返回 -2.
    public static class MinStack {
        Stack<Integer> st;
        Stack<Integer> minSt;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            st = new Stack<>();
            minSt = new Stack<>();
        }

        public void push(int x) {
            st.push(x);
            if (minSt.isEmpty() || minSt.peek() >= x) {
                minSt.push(x);
            }
        }

        public void pop() {
            int num = st.pop();
            if (minSt.peek() == num) {
                minSt.pop();
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return minSt.peek();
        }
    }
}
