package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1000,1000,1234};

        List resultIndex = binarySearch(arr,0,arr.length-1,1000);
       for (int i = 0;i< resultIndex.size();i++){
           System.out.println(resultIndex.get(i));
       }

    }

    // 二分查找算法
    public static List binarySearch(int[] arr, int left, int right, int findVal){
        if (left > right){
            return null;
        }
        int[] res = new int[arr.length];
        int mid = (left = right)/2;
        int midVal = arr[mid];
        int count = 0;
        List<Integer> resIndexList = new ArrayList<Integer>();

        if (findVal > midVal){
            return binarySearch(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid - 1,findVal);
        }else {

            resIndexList.add(mid);

            int temp = mid - 1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                resIndexList.add(temp);
                temp-=1;
            }

            temp = mid + 1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;



//            for (int i = 0;i<arr.length;i++){
//                if (mid - i > 0){
//                    if (arr[mid - i] == arr[mid]){
//                        res[count] = mid - i;
//                        count++;
//                    }
//                }else {
//                    break;
//                }
//            }
//            for (int i = 0;i<arr.length;i++){
//                if (mid + i < arr.length - 1){
//                    if (arr[mid - i] == arr[mid]){
//                        res[count] = mid + i;
//                        count++;
//                    }
//                }else {
//                    break;
//                }
//            }
//            System.out.println(count);
//            return res;

        }
    }
}
