import com.weng.consumer.ConsumerApplication;
import com.weng.pojo.Books;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class test {
    @Autowired
    private RedisTemplate redisTemplate;

    //opsForValue 操作字符串
    //opsForList  操作list
    //opsForSet   操作set
    @Test//append接到末尾
    public void appendTest() {
        String key = "key14";
        String value = "a";
        redisTemplate.opsForValue().append(key, value);
        System.out.println("set..");
    }

    @Test//set
    public void setTest() {
        Books book = new Books(123, "书名", 321, "详细");
        redisTemplate.opsForValue().set("key14", "book");
        System.out.println("set..");
    }

    @Test//get
    public void getTest() {
        Object o = redisTemplate.opsForValue().get("key12");
        System.out.println("get.." + o);
    }

    @Test//getAndSet
    public void getAndSetTest() {
        String key = "key14";
        String value = "a";
        Object o = redisTemplate.opsForValue().getAndSet(key, value);
        System.out.println("get.." + o);
    }

    @Test
    public void test1(){

    }
}
