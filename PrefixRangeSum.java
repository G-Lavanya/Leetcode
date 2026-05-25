public class PrefixRangeSum {
    int[] nums = {1, 3,4,7,6,0};
    int n = nums.length;
    int p[] = new int[n];



    public PrefixRangeSum(int[] nums) {
            //int n = nums.length;
           // int p[] = new int[n];
            p[0] = nums[0];
            for(int i = 1;i<n;i++){
                p[i] =p[i-1]+nums[i];

            }
        }

        public int PrefixRangeSum2(int left, int right) {

           if(p[left] == 0 ) {

               return p[right];
           }
           else{
               return p[right]-p[left-1];
           }

        }

    public static void main(String[] args) {
        prefixArray p = new prefixArray();
        int[] nums = {5,3,4,7,6,5};
        int left=3;
        int right=5;
        PrefixRangeSum obj = new PrefixRangeSum(nums);
        int param_1 = obj.PrefixRangeSum2(left,right);

        System.out.println(param_1);

    }


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
