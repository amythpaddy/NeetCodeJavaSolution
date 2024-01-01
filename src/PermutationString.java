import java.util.HashMap;
import java.util.Map;

public class PermutationString {
    public static void main(String[] args) {
//        System.out.println(new Solution().checkInclusion());
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            String[] tempArr = new String[s2.length()];
            Map<Character, Integer> s1Map = new HashMap<>();
            int currMatch = 0;
            Map<Character, Integer> s2Map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0));
                s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0));
            }
            for (char i = 'a'; i <= 'z'; i++) {
                if (s1Map.getOrDefault(i, 0) == s2Map.getOrDefault(i, 0))
                    currMatch++;
            }
            if (currMatch == 26) return true;
            int l = 0;
            int r = s1.length();
            while (r < s2.length()) {
//                if(s1.)
            }
            if (s1.length() > s2.length())
                return false;
            else {
                return true;
            }
//            return false;
        }
    }
}
