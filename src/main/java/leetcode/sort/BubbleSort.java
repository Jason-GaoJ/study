package leetcode.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 冒泡排序,将最大的数据放到最后，时间复杂度O(n2),空间复杂度O(1),稳定
 * @createTime 2021年01月05日 16:32:00
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr={5,3,9,0,7,8,2,4,1,6};
        for (int j = arr.length; j >0; j--) {
            for (int i = 0; i < j-1; i++) {
                if(arr[i]>arr[i+1]){
                    ArrayUtils.swap(arr,i,i+1);
                }
            }
            System.out.println(j+":"+ArrayUtils.toString(arr));
        }

        
    }
}
