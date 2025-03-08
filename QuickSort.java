//In a quick Sort pivot element is placed in the correct position actually always the pivot element is choosen as the last element and placed in its correct position, Quick sort is an element wise sorting special focus on element

public class QuickSort {

    static int partition(int[] arr, int low, int high){

        //Choose the pivot
        int pivot = arr[high];

        //Right position of pivot so far
        int i = low -1;

        //Move all smaller elements to the left side
        for(int j = low; j<= high -1; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        //move pivot after smaller element and return its position
        swap(arr, i+1, high);
        return i+1;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            
            //pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            //Recursive call for smaller elements
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

   public static void main(String[] args){
    int[] arr = {10,7,8,9,1,5};
    int n = arr.length;

    quickSort(arr, 0, n -1);

    for(int val : arr){
        System.out.println(val + " ");
    }
   } 
}
