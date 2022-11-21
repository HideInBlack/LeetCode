import java.util.*;

public class Main {
    public static void main(String[] args)  {
        /**
         * 三分算法搜索
         * 2022年10月29日22:06:46
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input what you would like to input nums:");
        int n = sc.nextInt();
        int[] temp = new int[n];
        System.out.println("and please input them:");
        for (int i = 0; i < temp.length; i++) {
            temp[i] = sc.nextInt();
        }
        System.out.println("Finally , Please input what you want search:");
        int t = sc.nextInt();
        int x = Tsearch(temp,t);
        if(x != -1){
            System.out.println(Tsearch(temp,t));
        }else {
            System.out.println(-1);
        }

    }

    public static int Tsearch(int[] temp,int key){
        int low = 0;
        int high = temp.length-1;
        int mid1;
        int mid2;
        if(temp[low] > key || temp[high] < key || low > high){
            return -1;
        }
        while (low <= high){
            mid1 = 1+(low+high)/3;
            mid2 = 1+(low+high)*2/3;

            if(temp[low] == key) {
                return low;
            }
            if(temp[high] == key) {
                return high;
            }
            if(temp[mid1] == key){
                return mid1;
            }
            if(temp[mid2] == key){
                return mid2;
            }
            if(key < temp[mid1]){
                high = mid1-1;
            }
            if(key > temp[mid2]){
                low = mid2+1;
            }
            if(key > temp[mid1] && key < temp[mid2]) {
                low = mid1+1;
                high = mid2-1;
            }
        }
        return  -1;
    }
}