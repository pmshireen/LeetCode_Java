package PracticePP;

public class MountainArray {

    public static void main(String[] args) {

        int []arr = {1,3,4,6,5,2};
        int target = 5;
        int ans = search(arr,target);
        System.out.println(ans);
    }
      static int search(int[] arr, int target){


        int peak =  peakIndexInMountainArray(arr) ;
        int firstTry = orderbinarySearch(arr,target,0,peak);
        if(firstTry!=-1){
            return firstTry;
        }
        // then serach in secong half
        return  orderbinarySearch(arr,target,peak+1,arr.length-1);
    }
     static int peakIndexInMountainArray(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;
        while(start < end ){
            int mid =  start + (end - start)/2;
            if(arr[mid] > arr[mid + 1]){
                end =   mid;

            }else{
                start = mid + 1;
            }
        }
        return start;// because start==end both are equal
    }
    static int orderbinarySearch(int arr[], int target, int start, int end)

    {

        boolean isAsc = arr[start] < arr[end];

        while(start <end )
        {
            int mid = start + (end - start)/2;

            if (arr[mid] == target)
            {
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid-1;
                }
                else if(target > arr[mid]){
                    start = mid+1;
                }

            }
            else{
                if(target < arr[mid]){
                    start = mid-1;
                }
                else if(target > arr[mid]){
                    end = mid-1;
                }
            }


        }
        return -1;
    }
}
