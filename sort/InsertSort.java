package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {

//        int[] arr = {2,-1,9,-10};
//        insertSort(arr);
        int[] arr = new int[80000];
        for (int i = 0;i<80000;i++){
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simp.format(date1);
        System.out.println(date1Str);
        insertSort(arr);
        Date date2 = new Date();
        String date1Str2 = simp.format(date2);
        System.out.println(date1Str2);

    }
    public static void insertSort(int[] arr){
        for (int i = 1;i < arr.length;i++){

            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
//                arr[insertIndex] = insertValue;
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;

        }
//        System.out.println(Arrays.toString(arr));
        
    }
}
