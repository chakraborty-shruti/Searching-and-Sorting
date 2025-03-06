/* We are using java program to search in a rotated sorted array we are using binary search twice to achieve result */

class Test{
    static int search(int arr[], int key){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            // Find the middle element
            int mid = (low + high)/2;
            if(arr[mid] == key) return mid;

            //Left half of the array is searched- check if left half is sorted
            if(arr[low] <= arr[mid]){
                // If key is within the sorted left half, search in left half
                if(key >= arr[low] && key < arr[mid]) high = mid -1;
                // Else search in the right half
                else low = mid + 1;
            }

            //Right half of the array is searched- check if right half is sorted
            else{
                // If key is within the sorted right half, search in right half
                if(key > arr[mid] && key <= arr[high]) low = mid +1;
                // Else search in the left half
                else high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println(search(arr, key));
    }
}