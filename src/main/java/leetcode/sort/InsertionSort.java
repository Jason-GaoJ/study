package leetcode.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 插入排序：将
 * @createTime 2021年01月05日 17:04:00
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr={5,3,9,0,7,8,2,4,1,6};

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j-1]>arr[j]){
                    ArrayUtils.swap(arr,j,j-1);
                }
            }
            System.out.println(i+":"+ArrayUtils.toString(arr));
        }


    }
}
