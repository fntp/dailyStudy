package algorithm.study;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.study
 * @Author: fntp
 * @CreateTime: 2023-08-10  16:01
 * @Description: TODO
 * @Version: 1.0
 */
public class InsertOrderlyTest {

    public static void main(String[] args) {

    }

    public static void sort(int[] array) {
        insertion(array,1);
    }

    private static void insertion(int[] array, int low) {
        if (low== array.length) {
            return;
        }
        int t = array[low];
        // 已排序区域的右边界
        int i = low-1;
        while (array[i] > t && i > 0){
            array[i+1] = array[i];
            i--;
        }
       if (i+1!=low) {
           array[i+1] = t;
       }
        insertion(array,low+1);
    }

    private static void insertion2(int[] array, int low) {
        if (low==array.length) {
            return;
        }
        int i = low -1;
        int target = array[low];
        while (array[i]>target && i >=0) {
            array[i+1] = array[i];
            i--;
        }
        if (i+1!=low) {
            array[i+1] = target;
        }
        insertion2(array,low+1);
    }

}
