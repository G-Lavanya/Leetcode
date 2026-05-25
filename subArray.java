public class subArray {
    public static int findMaxSumSubarray(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }

        int maxSum = 0;
        int windowSum = 0;

        // 1. Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // 2. Slide the window from index 'k' to the end of the array
        for (int i = k; i < nums.length; i++) {
            // Add the next element and subtract the element leaving the window
            windowSum += nums[i] - nums[i - k];//Instead of recalculating the sum of the entire window from scratch,
            // this updates the existing window sum in \(O(1)\) constant time. It adds the new element entering the
            // window on the right (nums[i])
            // and subtracts the old element that is leaving the window on the left (nums[i - k]).
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + findMaxSumSubarray(nums, k));
    }
}