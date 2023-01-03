package localTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {
	
	private static final Logger log = LoggerFactory.getLogger(MyTest.class);
	
	@Test
	public void testCharValue() {
		log.info(String.format("数值是%s",'0'+0));
	}
}
