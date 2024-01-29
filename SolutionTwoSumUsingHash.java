import java.util.HashMap;

public class SolutionTwoSumUsingHash {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        SolutionTwoSumUsingHash s = new SolutionTwoSumUsingHash();
        int[] result = s.twoSum(new int[]{3, 2, 6, 0}, 6);
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]"); // Output: [0, 3]

    }
}

