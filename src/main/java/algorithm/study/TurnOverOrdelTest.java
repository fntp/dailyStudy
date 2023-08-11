package algorithm.study;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.study
 * @Author: fntp
 * @CreateTime: 2023-08-10  16:33
 * @Description: TODO
 * @Version: 1.0
 */
public class TurnOverOrdelTest {

    public static void main(String[] args) {
        f1("abcd",0);
        System.out.println();
        f2("abcd","abcd".length()-1);
    }

    public static void f1(String str, int index) {
        if (index==str.length()){
            return;
        }
        f1(str, index+1);
        System.out.print(str.charAt(index));
    }

    public static void f2(String str,int index) {
        if (index==-1){
            return;
        }
        System.out.print(str.charAt(index));
        f2(str,index-1);
    }
}
