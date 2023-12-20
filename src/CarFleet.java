public class CarFleet {
    public static void main(String[] args) {
        System.out.println(new Solution().carFleet(10,new int[]{6,8},new int[]{3,2}));
    }

    static class Solution {

        public int carFleet(int target, int[] position, int[] speed) {
            float stepCount=0f;
            int fleetCount = 0;
            for(int i=0;i<position.length;i++){
                for(int j=i+1;j<position.length;j++){
                    if(position[i]<position[j]){
                        int tempPos = position[j];
                        int tempSpeed = speed[j];
                        position[j]=position[i];
                        speed[j]=speed[i];
                        position[i]=tempPos;
                        speed[i]=tempSpeed;
                    }
                }
                float tempStepCount= (float) (target - position[i]) /speed[i];
                if(tempStepCount>stepCount){
                    fleetCount++;
                    stepCount=tempStepCount;
                }
            }
            return fleetCount;
        }
    }

}
