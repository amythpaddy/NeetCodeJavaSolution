import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNotRepeating {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> wordTrap = new HashMap<>();
            int maxLength = 0;
            int tempLength = 0;
            int lastBreak = -1;
            for (int i = 0; i < s.length(); i++) {
                if (wordTrap.containsKey(s.charAt(i)) && wordTrap.get(s.charAt(i)) >= lastBreak) {
                    maxLength = Math.max(tempLength, maxLength);
                    tempLength = i - wordTrap.get(s.charAt(i)) - 1;
                    lastBreak = wordTrap.get(s.charAt(i));
                }
                tempLength++;
                wordTrap.put(s.charAt(i), i);
            }
            return Math.max(maxLength, tempLength);
        }
    }
}
