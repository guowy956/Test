package test.httpClient;

import com.cn.App;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author guowy
 * @create 2017-07-04 14:30
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest("server.port:0")// 使用0表示端口号随机，也可以指定端口
public class HttpClientManagerFactoryBenTest {
    // 注入HttpClient实例
    @Resource(name = "httpClientManagerFactoryBen")
    private CloseableHttpClient client;

    @Test
    public void test() throws ClientProtocolException, IOException, InterruptedException{
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i=0; i<10; i++){
            service.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println("the current thread is:"+Thread.currentThread().getName());
                    HttpEntity entity = null;
                    try {
                        HttpGet get = new HttpGet("https://operation-430.yingujr.com/#/operateAuditList");
                        // 通过httpclient的execute提交 请求 ，并用CloseableHttpResponse接受返回信息
                        CloseableHttpResponse response = client.execute(get);
                        System.out.println("client object:"+client);
                        entity = response.getEntity();
                        System.out.println("============"+EntityUtils.toString(entity, Consts.UTF_8)+"=============");
                        EntityUtils.consumeQuietly(entity);// 释放连接
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally{
                        if(null != entity){// 释放连接
                            EntityUtils.consumeQuietly(entity);
                        }
                    }
                }
            });
        }
        Thread.sleep(60000);
    }
}