package sort;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {
//        int arr[] = {3,9,-1,10,-2};
//        bubbleSort(arr);
        int[] arr = new int[80000];
        for (int i = 0;i<80000;i++){
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simp.format(date1);
        System.out.println(date1Str);
        bubbleSort(arr);
        Date date2 = new Date();
        String date1Str2 = simp.format(date2);
        System.out.println(date1Str2);


    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0;i < arr.length - 1;i++){
            for (int j = 0;j<arr.length - 1 - i;j++){
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){
                break;

            }else {
                flag = false;
            }
        }

//        System.out.println(Arrays.toString(arr));


    }
}


