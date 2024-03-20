import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindow {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("cabwefgewcwaefgcf", "cae"));
    }

    static class Solution {
        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> want = new HashMap<>();
        int haveCount = 0;
        int wantCount = 0;
        Set<Character> tSet = new HashSet<>();
        int low = 0;
        int high = 0;

        public String minWindow(String s, String t) {
            if (t.equalsIgnoreCase(""))
                return "";
            for (char tChar : t.toCharArray()) {
                tSet.add(tChar);
                want.put(tChar, want.getOrDefault(tChar, 0) + 1);
                wantCount++;
            }
            int i = 0;
            while (i < s.length()) {
                char temp = s.charAt(i);
                have.put(temp, have.getOrDefault(temp, 0) + 1);
                if (tSet.contains(temp) && have.get(t).equals(want.get(t))) {
                    haveCount++;
                }
//                if(haveCount==needCount)

            }

            return "";
        }
    }
}
