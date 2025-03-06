//Java program to find a peak element in the given array using Binary Search

//An element is considered peak element if it is strictly greater than its adjacent elements.

/*
1)If an element is smaller than it's next element then it is guaranteed that at least one peak element will exist on th right side of this element 
2) Conversely if an element is smaller than it's previous element then it is guaranteed that at least one peak element will exist on the left side of this element
*/

class Test{

    static int peakElement(int[] arr){
        int n = arr.length;

        //If there is only one element, then it's a peak
        if(n == 1) return 0;

        //Check if the first element is a peak
        if(arr[0] > arr[1]) return 0;

        //Check if the last element is a peak
        if(arr[n-1] > arr[n-2]) return n-1;

        //Search space for binary search
        int low = 1, high = n-2;

        while(low <= high){
            int mid = (low+high)/2;

            //If the element at mid is a peak element return mid
            if(arr[mid] > arr[mid -1] && arr[mid] < arr[mid + 1]) return mid;

            //If next neighbor is greater, than peak element will exist in right subarray
            if(arr[mid] < arr[mid+1]){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[] arr = {1,2,4,5,7,8,3};
        System.out.println(peakElement(arr));
    }
}