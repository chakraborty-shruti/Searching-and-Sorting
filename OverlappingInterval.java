//Given an array of time intervals where arr[i] = [starti, endi], the task is to merge all the overlapping intervals into one and output the result which should have only mutually exclusive intervals.

/*Input: arr[] = [[1, 3], [2, 4], [6, 8], [9, 10]]
Output: [[1, 4], [6, 8], [9, 10]] */

import java.util.Arrays;
import java.util.Comparator;

class IntervalComparator implements Comparator<int[]>{

    public int compare(int[] a, int[] b){
        return a[0] - b[0];
    }
}

class Test{

    static int mergeOverlap(int[][] arr){
        //Sort intervals using comparator
        Arrays.sort(arr, new IntervalComparator());

        int resIdx = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[resIdx][1] >= arr[i][0]){
                arr[resIdx][1] = Math.max(arr[resIdx][1], arr[i][1]);
            }
            else{
                resIdx++;
                arr[resIdx] = arr[i];
            }
        }
        return (resIdx + 1);
    }

    public static void main(String[] args) {
        int[][] arr = {{7,8},{1,5},{2,4},{4,6}};
        int newSize = mergeOverlap(arr);

        for(int i =0; i < newSize; i++){
            System.out.println(arr[i][0]+ " "+ arr[i][1]);
        }
    }
}