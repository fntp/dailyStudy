package designpattern.dutychain;

/**
 * @author fntp
 * @since 2023/9/2
 */
public class HandleB implements IHandler{
    /**
     * 责任链模式处理业务代码
     */
    @Override
    public void doHandle() {
        System.out.println("责任链中的【B】处理了用户信息核对");
    }
}
