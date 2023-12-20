public class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3}},2));
    }
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = searchRow(matrix,0,matrix.length-1,target);
            if(row==-1){
                return false;
            }
            int column = searchColumn(matrix,0,matrix[0].length-1,row,target);
            if(column==-1){
                return false;
            }
            return true;
        }

        private int searchColumn(int[][] matrix, int left, int right,int row, int target) {
            if(left>right){
                return -1;
            }
            int mid = (left+right)/2;
//            System.out.println(left+"--"+mid+"---"+right+"--------------col");
            if(matrix[row][mid]>target){
                return searchColumn(matrix,left,mid-1,row,target);
            }else if(matrix[row][mid]<target){
                return searchColumn(matrix,mid+1,right,row,target);
            }else{
                return mid;
            }
        }

        private int searchRow(int[][] matrix, int left, int right, int target) {
            if(left>right)
                return -1;
            int mid = (left+right)/2;
//            System.out.println(left+"--"+mid+"---"+right+"--------------row");
            if(matrix[mid][0]>target){
                return searchRow(matrix,left,mid-1,target);
            }else if(matrix[mid][matrix[mid].length-1]<target){
                return searchRow(matrix,mid+1,right,target);
            }else{
                return mid;
            }
        }
    }
}
