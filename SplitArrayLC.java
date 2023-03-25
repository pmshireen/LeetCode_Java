package PracticePP;

public class SplitArrayLC {
    public static void main(String[] args) {
          int[] nums = {7,2,5,10,8};
          int m  = 10;
          int ans = splitArray(nums,m);
          System.out.println(ans);
    }
    public static int splitArray(int[] nums, int m){
        int start = 0;
        int end = 0;
        for(int i = 0;i<nums.length;i++){
            start = Math.max(start,nums[i]);
            end += nums[i];

        }
        while(start < end)
        {
            //try for the middle as potential answer
            int mid = start + (end - start)/2;

            //calculate how many pieces you can divide this in with max Sum.
            int sum = 0;
            int pieces = 1;
            for(int num:nums) {
                if(sum + num > mid) {
                    sum = num;
                    pieces ++;

                }
                else {
                    sum += num;
                }
            }

            if(pieces > m) {
                start = mid+1;
            }
            else {
                end = mid;
            }


        }
        return end;//becoz end == start

    }
}
