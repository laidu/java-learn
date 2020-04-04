package org.laidu.learn.common.akka;

import org.laidu.learn.common.akka.actor.HelloActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * akka-java learn
 */
public class AkkaJavaApp {

    public static void main(String[] args) {

        final ActorSystem system = ActorSystem.create("akka-learn");

        ActorRef hello = system.actorOf(Props.create(HelloActor.class), "hello");
        ActorRef hello2 = system.actorOf(Props.create(HelloActor.class), "hello2");

        hello.tell("hello", ActorRef.noSender());
        hello.tell("hello", ActorRef.noSender());
        hello.tell(new Object(), ActorRef.noSender());
        hello.tell("hello", ActorRef.noSender());
        hello.tell("hello", hello2);


    }
}
