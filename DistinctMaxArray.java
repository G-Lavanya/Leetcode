import java.util.HashMap;

public class DistinctMaxArray {

    public static long maximumSubarraySum(int[] nums, int k){
        int max =0;
        int i =0;
        int beststart = -1, bestend =-1;
        int sum =0;
        HashMap<Integer,Integer> freq = new HashMap<>(); //Assign Hashmap to get a key value pattern
        for(int j =0;j<nums.length;j++){
            freq.merge(nums[j], 1,Integer::sum); //count the freq of number if its repeating
            sum+= nums[j];
            while (freq.get(nums[j]) > 1) //Fix Duplicates
            {
                freq.put(nums[i],freq.get(nums[i])-1);
                sum-=nums[i];

                if(freq.get(nums[i]) ==0){
                    freq.remove(nums[i]);
                }
                i++;
            }
            if(j-i+1>k){ // maintain size k by removing leftmost value
                freq.put(nums[i],freq.get(nums[i])-1);
                sum-=nums[i];
                if(freq.get(nums[i])==0){
                    freq.remove(nums[i]);
                }
                i++;
            }
            if(j-i+1 ==k){//valid window
                if (sum > max) { //check max value
                    max = sum;
                    beststart = i;
                    bestend = j;
                }
            }
        }
            if(beststart != -1){
                System.out.println("Max Sum Subarray: " + max);
                System.out.print("Subarray: ");
                for(int l = beststart;l<= bestend;l++){
                    System.out.print(nums[l] + " ");
                }

            }
        return max;
    }
    public static void main(String[] args) {
        int [] num ={1,2,3,1,4,5};
        int k =3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + maximumSubarraySum(num, k));

    }
}
