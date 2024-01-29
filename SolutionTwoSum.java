public class SolutionTwoSum {
    public int[] twoSum(int[] nums, int target) {
        // TODO: Write your code here

        for(int i=0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[j] == target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No Pair is found");
    }

    public static void main(String[] args){
        SolutionTwoSum s = new SolutionTwoSum();
        int[] result = s.twoSum(new int[]{3,2,6,0},6);
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]"); // Output: [0, 3]

    }
}

