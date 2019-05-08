package StackAl;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true
 */
public class q020_ValidParentheses {

    private static  boolean isPairs(String s1,String s2) {
        List<Pair<String, String>> list = new ArrayList<>();
        list.add(new Pair<>("(", ")"));
        list.add(new Pair<>("{", "}"));
        list.add(new Pair<>("[", "]"));

        Pair<String, String> temp = new Pair<>(s1, s2);
        return list.contains(temp);

    }

    public static boolean validParenthese(String string) {
        boolean bool = false;
        if (string == null || string.isEmpty()) {
            return bool;
        }

        String[] strings = string.split("");
        LinkedList<String> stack  = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            if (stack.peek() != null) {
                String key = stack.peek();
                String value = strings[i];
                if (isPairs(key, value)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(strings[i]);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParenthese("()"));
        System.out.println(validParenthese("()[]{}"));
        System.out.println(validParenthese("([)]"));
        System.out.println(validParenthese("{[]}"));

    }
}
