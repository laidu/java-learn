package org.laidu.learn.play.controller;

import lombok.extern.slf4j.Slf4j;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Application
 * <p>
 * Created by tiancai.zang on 2017-10-22 11:54.
 */
@Slf4j
public class Application extends Controller{

    public Result index() {
        return ok("It works!");
    }


}