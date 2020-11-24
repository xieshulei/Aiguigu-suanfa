package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadisSort {
    public static void main(String[] args) {
//        int[] arr = {53,3,542,748,14,214};
        int[] arr = new int[8000000];
        for (int i = 0;i<8000000;i++){
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simp.format(date1);
        System.out.println(date1Str);
        radixSort(arr);
        Date date2 = new Date();
        String date1Str2 = simp.format(date2);
        System.out.println(date1Str2);
//        radixSort(arr);
    }

    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();


        int[][] tong = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n = 1;i<maxLength;i++,n*=10){
            for (int j = 0;j< arr.length;j++){
                // 去除每一个元素的各位
                int digitOfElement = arr[j]/n%10;
                tong[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0;k< tong.length;k++){
                if (bucketElementCounts[k] != 0){
                    for (int l = 0;l< bucketElementCounts[k];l++){
                        arr[index] = tong[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k] = 0;
            }
//            System.out.println(Arrays.toString(arr));

        }


    }
}
