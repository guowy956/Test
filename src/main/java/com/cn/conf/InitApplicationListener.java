package com.cn.conf;

import com.cn.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * spring的事件监听器的处理机制：在启动服务器的时候，插入默认数据
 *
 * @author guowy
 * @create 2017-05-26 17:09
 **/
@Component
public class InitApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        //UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        for (int i = 1; i < 21; i++) {
            User user = new User("user" + i, 25 + i);
           // userRepository.save(user);
        }
    }
}
