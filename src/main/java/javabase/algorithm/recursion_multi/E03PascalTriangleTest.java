package javabase.algorithm.recursion_multi;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: javabase.algorithm.recursion_multi
 * @Author: fntp
 * @CreateTime: 2023-08-12  15:36
 * @Description: TODO
 * @Version: 1.0
 */
public class E03PascalTriangleTest {

    public static void main(String[] args) {
        print(5);
        print1(5);
    }

    private static int cal(int i,int j,int[][] arr){
        if (arr[i][j]>0){
            return arr[i][j];
        }
        if (j==0||i==j) {
            arr[i][j] = 1;
            return 1;
        }
        arr[i][j] = cal(i-1,j,arr)+cal(i-1,j-1,arr);
        return arr[i][j];
    }

    public static void print(int height) {
        int[][] arr = new int[height][];
        for (int i = 0; i < height; i++) {
            for (int k = 0; k < (height - 1 - i) * 2; k++) {
                System.out.print(" ");
            }
            arr[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d",cal(i,j,arr));
            }
            System.out.println();
        }
    }

    public static void print1(int height) {
        int[] arr = new int[height];
        for (int i = 0; i < height; i++) {
            cal1(i,arr);
            for (int k = 0; k < (height - 1 - i) * 2; k++) {
                System.out.print(" ");
            }
            for (int k : arr) {
                if (k>0){
                    System.out.printf("%-4d", k);
                }
            }
            System.out.println();
        }
    }
    private static void cal1(int i,int[] arr){
        if (i==0) {
            arr[i] = 1;
            return;
        }
        for (int j = i; j > 0 ; j--) {
            arr[j] = arr[j] + arr[j-1]; 
        }
    }

}
