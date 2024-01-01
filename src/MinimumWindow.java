import java.util.HashMap;
import java.util.Map;

public class MinimumWindow {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABCX"));
    }

    static class Solution {
        public String minWindow(String s, String t) {
            int match = t.length();
            Map<Character, Integer> tmap = new HashMap<>();
            Map<Character, Integer> smap = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char temp = t.charAt(i);
                tmap.put(temp, tmap.getOrDefault(temp, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                smap.put(temp, smap.getOrDefault(temp, 0) + 1);
            }
            int low = 0;
            int high = s.length() - 1;
            int i = 0;
            while (low <= high) {
                char currentChar = s.charAt(low);
                int currCount = smap.get(currentChar);
                if (tmap.containsKey(currentChar)) {
                    if (currCount - 1 >= tmap.get(currentChar)) {
                        smap.put(currentChar, currCount - 1);
                        low++;
                    } else {
                        break;
                    }
                } else {
                    low++;
                }
            }
            while (low >= high) {
                char currentChar = s.charAt(high);
                int currCount = smap.get(currentChar);
                if (tmap.containsKey(currentChar)) {
                    if (currCount - 1 >= tmap.get(currentChar)) {
                        smap.put(currentChar, currCount - 1);
                        high--;
                    } else {
                        break;
                    }
                } else {
                    high--;
                }
            }
            return s.substring(low, high + 1);
        }
    }
}
