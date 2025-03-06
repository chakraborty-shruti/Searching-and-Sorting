class Test{
    static int binarySearch(int arr[], int x){
        int n = arr.length;
        int low =0 ,high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args){
        int arr[] =new int[]{10,20,30,40,50,60,70,80,90};
        int x = 60;
        int result = binarySearch(arr,x);

        if(result != -1){
            System.out.println("Element found at index"+result);
        }else{
            System.out.println("Element not found");
        }
    }
}