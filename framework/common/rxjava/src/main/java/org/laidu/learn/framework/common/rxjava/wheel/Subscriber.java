package org.laidu.learn.framework.common.rxjava.wheel;

import io.reactivex.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * 观察者
 * <p>
 * Created by laidu
 * on 2018-08-06 18:11.
 *
 * @author laidu
 */
// TODO: 2018-08-06 18:11  观察者
@Slf4j
public abstract class Subscriber<T> implements Observer<T> {

    public void onStart(){}
}