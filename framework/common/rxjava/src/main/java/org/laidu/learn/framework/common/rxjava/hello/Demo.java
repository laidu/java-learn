
package org.laidu.learn.framework.common.rxjava.hello;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * demo
 * <p>
 * Created by laidu
 * on 2018-08-01 11:56.
 *
 * @author laidu
 */
@Slf4j
public class Demo {


    public static void main(String[] args) throws InterruptedException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        int bufferSize = 16*1024*10240;
        StringBuffer stringBuffer = new StringBuffer(bufferSize);

        File file = new File(System.getProperty("user.dir")+"/logs/temp.txt");


        Consumer<List<Long>> handler = s -> {
            stringBuffer.append(s + "\n");

            if (stringBuffer.length() >= bufferSize) {
                FileUtil.appendString(file,stringBuffer.toString());
                stringBuffer.setLength(0);
            }
        };

        Consumer<Throwable> onError = Throwable::printStackTrace;


        Disposable disposable = Observable.interval(5, TimeUnit.MICROSECONDS)
                .subscribeOn(Schedulers.io())
                .buffer(1000)
                .subscribe(handler,onError);


        stopWatch.stop();

        System.out.println(stopWatch.getNanoTime());

        for (int i = 0; i < 600; i++) {

            Thread.sleep(1000);
            disposable.dispose();
            if (disposable.isDisposed()) {

                return;
            }else {
                System.out.println("running...");
            }
        }


    }
}