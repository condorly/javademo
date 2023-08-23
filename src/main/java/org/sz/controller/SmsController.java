package org.sz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.sz.service.SmsSendService;

@RestController
public class SmsController {
    @Autowired
    private SmsSendService smsSendService;
    //    @Autowired
//    public StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;

    /**
     * 测试接口
     *
     * @return
     */
    @GetMapping("/test")
    public Object sendSms() {
        return "hello world 这是我的第一个web程序";
    }

    /**
     * 发送短信接口
     */
    @GetMapping("/sendSms")
    public Object sendSms(String phone, String message) {
        System.out.println("我进到发短信接口了，我演示的是断点调试");
        System.out.println("phone = " + phone + "，message = " + message);
        return smsSendService.sendSms(phone, message);

    }


    /**
     * 查询短信接口
     *
     * @param phone
     * @return
     */

    @GetMapping("/querySms")
    public Object querySms(String phone) {
        //根据手机号，查询出这个手机号发送过什么短信，什么时候发的
        String phone1 = strRedisTemplate.opsForValue().get(phone);
        if (phone1==null) {
            strRedisTemplate.opsForValue().set(phone, phone);
            phone1= strRedisTemplate.opsForValue().get(phone);
        }
        return phone1;
    }
}
