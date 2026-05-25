import java.util.*;

class DistinctSubArray {

    public static long maximumSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> freq = new HashMap<>();

            long sum = 0, max = 0;
            int i = 0;

            //int bestStart = -1, bestEnd = -1;

            for (int j = 0; j < nums.length; j++) {

                freq.merge(nums[j], 1, Integer::sum);
                sum += nums[j];

                // fix duplicates
                while (freq.get(nums[j]) > 1) {
                    freq.put(nums[i], freq.get(nums[i]) - 1);
                    sum -= nums[i];

                    if (freq.get(nums[i]) == 0) {
                        freq.remove(nums[i]);
                    }
                    i++;
                }

                // maintain size k
                while (j - i + 1 > k) {
                    freq.put(nums[i], freq.get(nums[i]) - 1);
                    sum -= nums[i];

                    if (freq.get(nums[i]) == 0) {
                        freq.remove(nums[i]);
                    }
                    i++;
                }

                // valid window
                if (j - i + 1 == k) {
                    if (sum > max) {
                        max = sum;
//                        bestStart = i;
//                        bestEnd = j;
                    }
                }
            }

            // print the best distinct subarray
//            if (bestStart != -1) {
//                System.out.println("Max Sum Subarray: " + max);
//                System.out.print("Subarray: ");
//                for (int x = bestStart; x <= bestEnd; x++) {
//                    System.out.print(nums[x] + " ");
//                }
//            }

            return max;
        }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + maximumSubarraySum(nums, k));
    }
}