import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangzhilei3 on 2017/12/19.
 */
public class MainTest {
    private static Logger logger = LoggerFactory.getLogger(MainTest.class);
    @Test
    public void myFirstTest() {
        logger.info("test");
        assertEquals(2, 1 + 1);
    }
}
