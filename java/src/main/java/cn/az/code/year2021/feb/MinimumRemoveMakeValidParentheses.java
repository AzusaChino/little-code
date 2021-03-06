package cn.az.code.year2021.feb;

import java.util.Stack;

/**
 * @author ycpang
 * @since 2021-02-19 16:38
 */
public class MinimumRemoveMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.add(i);
            } else if (sb.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!stack.empty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }
}
