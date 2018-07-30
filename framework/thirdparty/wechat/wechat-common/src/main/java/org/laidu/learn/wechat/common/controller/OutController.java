package org.laidu.learn.wechat.common.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by laidu
 * on 2018-07-20 15:51.
 *
 * @author laidu
 */
// TODO: 2018-07-20 15:51  
@Slf4j
@RestController
@RequestMapping("/api/v1.1")
public class OutController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${msgQueueKey:msg}")
    private String msgQueueKey;


    @GetMapping("/channels/{channelId}/danmaku")
    public String getMsg(@PathVariable String channelId){

        JSONArray msgArray = new JSONArray();
        
        log.info("channelId : {}", channelId);

        String msgString = redisTemplate.opsForList().rightPop(msgQueueKey);

        while (StringUtil.isNotBlank(msgString)){

            JSONObject msg = new JSONObject();
            msg.put("style","blue");
            msg.put("text",msgString);
            msg.put("position","fly");
            msgArray.add(msg);

            msgString = redisTemplate.opsForList().rightPop(msgQueueKey);
        }

        return msgArray.toJSONString();
    }
}