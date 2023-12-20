public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1,0,3,5,9,12},9));
    }
    static class Solution {
        public int search(int[] nums, int target) {
            int pos = binSearch(nums,0,nums.length-1,nums.length/2,target);
            return pos;
        }

        int binSearch(int[] nums, int left, int right, int middle,int target){
            int pos = -1;
            if(left>right){
                return pos;
            }
            else if(nums[middle]==target){
                pos=middle;
            }else{
                pos = binSearch(nums,left,middle-1,(middle+left)/2,target);
                if(pos==-1){
                    pos = binSearch(nums,middle+1,right,(right+middle)/2,target);
                }
            }
            return pos;
        }
    }
}
