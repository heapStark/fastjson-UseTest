package heapStark.concurrentTest.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhilei3 on 2017/12/19.
 */
public class Call implements Callable {
    public List call() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        return Arrays.asList("hello","world");
    }
}
