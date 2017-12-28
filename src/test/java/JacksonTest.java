import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import heapStark.jackson.Gender;
import heapStark.jackson.Student;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by wangzhilei3 on 2017/12/28.
 */
public class JacksonTest {
    private final static Logger logger = LoggerFactory.getLogger(JacksonTest.class);

    @Test
    public void voidTest() {

    }

    @Test
    public void jsonSerializeTest()throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Student student  = new Student("laowang",10,new Date(), Gender.MALE);
        String jsonString = objectMapper.writeValueAsString(student);
        logger.info(":{}",jsonString);
        jsonString = "{\"name\":\"laowang\",\"age\":\"10\",\"gender\":\"MALE\",\"brithday\":1514441052291}";
        student = objectMapper.readValue(jsonString,Student.class);
        logger.info(":{}",student);

    }
    @Test
    public void jsonDeserializeTest(){

    }
}
