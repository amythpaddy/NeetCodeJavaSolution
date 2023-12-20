import java.util.Stack;

public class LargestRectInHistogram {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2,4}));
    }
    static class Solution {
        class StackComp{
            int height;
            int startIdx;
            StackComp(int height, int startIdx){
                this.height=height;
                this.startIdx=startIdx;
            }
        }
        public int largestRectangleArea(int[] heights) {
            Stack<StackComp> stack = new Stack<>();
            int maxArea=0;
            stack.push(new StackComp(heights[0],0));
            for(int i=1;i<heights.length;i++){
                StackComp pop=null;
                while(!stack.isEmpty()&&heights[i]<stack.lastElement().height){
                    pop = stack.pop();
                    int tempArea = pop.height*(i-pop.startIdx);
                    if(tempArea>maxArea){
                        maxArea=tempArea;
                    }
                }
                int startidx = pop!=null?pop.startIdx:i;
                stack.push(new StackComp(heights[i],startidx));
            }
            while(!stack.isEmpty()){
                StackComp pop = stack.pop();
                int tempArea = pop.height*(heights.length-pop.startIdx);
                if(tempArea>maxArea){
                    maxArea=tempArea;
                }
            }
            return maxArea;
        }
    }
}
