package StringAl;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

 示例：

 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。

 */
public class q003_LongestSubstringWithoutRepeatingCharacter {
    /**
     * 双层循环
     * 并且采用一个List进行判断字串字符是否重复
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        String[] strings = s.split("");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            int tmplen=1;
            list.add(strings[i]);
            for (int j = i + 1; j < strings.length; ) {
                if (!list.contains(strings[j])) {
                    list.add(strings[j]);
                    j++;
                    tmplen++;
                }else {
                    len = Math.max(len, tmplen);
                    list.clear();
                    break;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "";
        int temp = lengthOfLongestSubstring("abcabcbb");
        System.out.println(temp );
        temp = lengthOfLongestSubstring("bbb");
        System.out.println(temp );
        temp = lengthOfLongestSubstring("pwwkew");
        System.out.println(temp );

    }
}
