public class DailyTemperature {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] finAns = sl.dailyTemperatures(new int[]{4,5,2,3,6,4,1});
        for(int fin:finAns){
            System.out.println(fin);
        }
    }

}

class Solution2 {
    int[] answer;
    public int[] dailyTemperatures(int[] temperatures) {
        answer = new int[temperatures.length];
        int start = 0;
        int end = 1;
        while(start< temperatures.length){
            if(end==temperatures.length){
                answer[start]=0;
                start++;
                end=start+1;
            }else if(temperatures[start]<temperatures[end]){
                answer[start]=end-start;
                start++;
                end=start+1;
            }else{
                end++;
            }
        }
        return answer;
    }
}

class Solution {
    int[] result;
    int[] stack;
    public int[] dailyTemperatures(int[] temperatures) {
        result = new int[temperatures.length];
        stack = new int[temperatures.length];
        for(int i=0 ; i<temperatures.length;i++){

        }
        return result;
    }
}
