//Java program to find the square root of given integer using binary search

class Test{

    static int floorSqrt(int n){

        //Initial search space
        int low = 1, high = n;
        int res = 1;

        while(low <= high){
            int mid = (high + low)/2;

            //If a square of a mid is less than or equal to n update the result and search in upper half
            if(mid * mid <= n){
                res = mid;
                low = mid + 1;
            }else{
                //If square of mid exceeds n, search in the lower half
                high = mid -1;
            }
        }
        return res;
    }
public static void main(String[] args){
    int n = 11;
    System.out.println(floorSqrt(n));
}
}