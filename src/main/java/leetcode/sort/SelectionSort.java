package leetcode.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description 选择排序 -> 从头开始找到最小的置换，时间复杂度O(n2)，空间复杂度O(1)。不稳定
 * @createTime 2021年01月05日 15:00:00
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr={5,3,9,0,7,8,2,4,1,6};

        for (int i = 0; i < arr.length -1; i++) {
            int minPos=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minPos];
            arr[minPos]=temp;
            System.out.println(i+":"+ArrayUtils.toString(arr));
        }
    }
}
