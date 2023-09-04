package designpattern.dutychain;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fntp
 * @since 2023/9/2
 */
@Test
public class HandleChainTest {

    @Test
    public void test01() {

        List<IHandler> handlerList = new LinkedList<>();
        handlerList.add(new HandleA());
        handlerList.add(new HandleB());
        handlerList.add(new HandleC());
        handlerList.add(new HandleD());

        HandleChain chain = new HandleChain(handlerList);
        chain.runWithChain();

        ArrayList<Object> objects = Lists.newArrayList();
    }

}
