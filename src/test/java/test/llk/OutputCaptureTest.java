package test.llk;


import com.cn.App;
import org.apache.http.impl.client.CloseableHttpClient;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertThat;

/**
 * @author guowy
 * @create 2017-07-04 15:25
 **/


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest("server.port:0")// 使用0表示端口号随机，也可以指定端口
public class OutputCaptureTest {


    // 注入HttpClient实例
    @Resource(name = "httpClientManagerFactoryBen")
    private CloseableHttpClient client;


    @Rule
    // 这里注意，使用@Rule注解必须要用public
    public OutputCapture capture = new OutputCapture();

    @Test
    public void outputCaptureTest(){

        System.out.println("");
        System.out.println("Hello");
        System.out.println("HelloWorld");
        System.out.println("HelloWorld1");
        System.out.println("HelloWorld2");
        System.out.println("HelloWorld3");

        System.out.println(capture.toString());

        assertThat(capture.toString(), Matchers.containsString("HelloWorld"));

    }

}
