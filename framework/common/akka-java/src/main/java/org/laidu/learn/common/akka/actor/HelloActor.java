package org.laidu.learn.common.akka.actor;

import com.alibaba.fastjson.JSON;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class HelloActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return new ReceiveBuilder()
                .match(String.class, var -> System.out.println(this.getSelf().path()+": "+var))
                .matchAny(var -> System.out.println(JSON.toJSONString(var)))
                .build();
    }
}
