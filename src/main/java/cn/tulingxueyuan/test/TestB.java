package cn.tulingxueyuan.test;

/**
 * @author fntp
 * @date 2025/2/6
 * @apiNote
 */
public class TestB {

    public static TestA<String> testA = new TestA<>() {
        @Override
        protected String initT() {
            return "testB";
        }
    };

}
