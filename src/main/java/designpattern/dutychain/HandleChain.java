package designpattern.dutychain;

import java.util.List;

/**
 * @author fntp
 * @since 2023/9/2
 */
public class HandleChain {

    private List<IHandler> handleList;

    public HandleChain(List<IHandler> handleList) {
        this.handleList = handleList;
    }

    /**
     * 执行调用链
     */
    public void runWithChain() {
        handleList.forEach(IHandler::doHandle);
    }

}
