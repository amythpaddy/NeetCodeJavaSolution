import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        List<List<String>> ans = new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> row : ans) {
            for (String x : row) {
                System.out.print(x + "--");
            }
            System.out.println();
        }
    }

    static class Solution {
        List<List<String>> answer = new ArrayList<>();
        HashMap<String, List<String>> answerMap = new HashMap<>();
        List<String> tempList;

        public List<List<String>> groupAnagrams(String[] strs) {
            for (String str : strs) {
                String sorted = getID(str);
                if (!answerMap.containsKey(sorted)) {
                    tempList = new ArrayList<>();
                    answerMap.put(sorted, tempList);
                    answer.add(tempList);
                } else {
                    tempList = answerMap.get(sorted);
                }
                tempList.add(str);
            }
            return answer;
        }

        String sort(String word) {
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            return new String(wordArr);
        }

        String getID(String s) {
            char[] counter = new char[26];
            for (char c : s.toCharArray()) {
                counter[c - 'a']++;
            }

            return String.valueOf(counter);
        }
    }
}
