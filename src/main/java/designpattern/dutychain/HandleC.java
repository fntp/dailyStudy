package designpattern.dutychain;

/**
 * @author fntp
 * @since 2023/9/2
 */
public class HandleC implements IHandler{
    /**
     * 责任链模式处理业务代码
     */
    @Override
    public void doHandle() {
        System.out.println("责任链中的【C】处理了球桌等附加信息核对");
    }
}
