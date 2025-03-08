//Merge sort is a sorting algorithm that follows the divide-and-conquer approach. It works by recursively dividing the input array into smaller subarrays and sorting those subarrays then merging them back together to obtain the sorted array.

class Test{
    static void merge(int arr[], int l, int mid, int r){
        //Find sizes of two subarray to be merged
        int n1 = mid - l +1;
        int n2 = r - mid;
        
        //Create temp array
        int L[] = new int[n1];
        int R[] = new int[n2];

        //Copy data to temp arrays
        for(int i=0; i<n1; i++){
            L[i] = arr[l+i];
        }
        for(int j = 0 ; j< n2; j++){
            R[j] = arr[mid +1+j];
        }

        //Merge the temp arrays
        int k = l;
        int i = 0, j=0;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //Copy remaining elements of L[]
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        //Copy remaining elements of R[]
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    

    static void sort(int arr[], int l, int r){
        if(l < r){
            int mid = (l + r)/2;

            //Sort first and second half
            sort(arr,l,mid);
            sort(arr, mid +1, r);

            //Merge the sorted halves
            merge(arr,l,mid,r);
        }
    }

    static void printArray(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.println(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = {12,11,13,5,6,7};
        System.out.println("Given array is");
        printArray(arr);

        sort(arr,0,arr.length - 1);

        System.out.println("\n Sorted Array is");
        printArray(arr);
    }
}