package com.ethan.springcloud.service;

import com.ethan.springcloud.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//服务降级工厂处理类
@Component
public class UserClientFallbackFactory implements FallbackFactory {

    public UserService create(Throwable throwable) {

        return new UserService() {

            public List<User> userList() {
                return null;
            }

            public User userWithId(int id) {
                return new User().setName("不存在")
                        .setDbSource("服务降级，服务已关闭");
            }

            public boolean addUser(User user) {
                return false;
            }
        };

    }
}
