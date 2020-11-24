package search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0;i<100;i++){
            arr[i] = i+1;
        }
        int res = insertValurSearch(arr,0,arr.length -1,78);
        System.out.println(res);
    }


    // 插值查找算法要求数组是有序的
    public static int insertValurSearch(int[] arr,int left,int right,int findVal){
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            return -1;
        }
        int mid = left + (right - left)*(findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            return insertValurSearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            return insertValurSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
