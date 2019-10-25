package cn.az.little.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author : Liz
 * @date : 2019/10/25
 **/
public class ValidParenthese_020 {

    public static void main(String[] args) {
        System.out.println(valid("[[(]]{})"));
    }

    public static boolean valid(String strs) {
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < strs.length(); i++) {
            if (strs.charAt(i) == '(' || strs.charAt(i) == '[' || strs.charAt(i) == '{') {
                queue.add(strs.charAt(i));
            } else {
                if (queue.isEmpty()) {
                    return false;
                } else {
                    if (queue.peek() == '(' && strs.charAt(i) != ')') {
                        return false;
                    } else if (queue.peek() == '[' && strs.charAt(i) != ']') {
                        return false;
                    } else if (queue.peek() == '{' && strs.charAt(i) != '}') {
                        return false;
                    }
                    queue.pop();
                }
            }
        }
        return queue.isEmpty();
    }
}
