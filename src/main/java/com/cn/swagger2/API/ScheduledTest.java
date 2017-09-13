package com.cn.swagger2.API;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by newtouch on 2017/8/11.
 *
 *
 * Spring 定时器
 */
@Component   // 启动定时器
public class ScheduledTest {

//  规则不同
//    @Scheduled(cron="* * * * * ?")
//    @Scheduled(fixedRate = 3000)
    public void timerRate() {
        System.out.println(888);
    }

}
