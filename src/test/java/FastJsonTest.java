import com.alibaba.fastjson.JSON;
import heapStark.fastjson.Gender;
import heapStark.fastjson.Student;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * Created by wangzhilei3 on 2017/12/19.
 */
public class FastJsonTest {
    private final static Logger logger = LoggerFactory.getLogger(FastJsonTest.class);
    private  static Student student = new Student();

    @Test
    public void voidTest() {

    }
    @Test
    public void jsonSerializeTest() {
        Student student  = new Student("laowang",10,new Date(), Gender.MALE);
        String json = JSON.toJSONString(student);
        String result = "{\"age\":10,\"brithday\":1514431010935,\"gender\":\"MALE\",\"name\":\"laowang\"}";
        student = JSON.parseObject(json,Student.class);
        logger.info(":{}",json);
        logger.info("----------------------end--------------------");
    }
}
