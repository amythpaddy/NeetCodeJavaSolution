import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {
    public static void main(String[] args) {
        List<String> answer = new Solution().letterCombinations("23");
        for (String a : answer) {
            System.out.print(a + "--");
        }
        System.out.println();
    }

    static class Solution {
        List<String> answer = new ArrayList<>();
        String[] phArr = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            if (!digits.isEmpty())
                generateSublist(digits, 0, "");
            return answer;
        }

        void generateSublist(String digits, int pos, String currString) {
            if (pos == digits.length()) {
                answer.add(currString);
            } else {
                int num = Integer.parseInt(String.valueOf(digits.charAt(pos)));
                for (int i = 0; i < phArr[num].length(); i++) {
                    String temp = currString + phArr[num].charAt(i);
                    generateSublist(digits, pos + 1, temp);
                }
            }
        }
    }
}
