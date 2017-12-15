package model;

import lombok.*;

import java.io.Serializable;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tiancai.zang on 2017-12-05 10:20.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable, Serializable {


    /**
     * 唯一标示一次请求
     */
    private String uuid = "";

    /**
     * 查询码和平台码
     */
    protected String queryCode;

    /**
     * 超时时间(ms)
     */
    private long timeout = 10000;

    /**
     * 开始时间
     */
    private long startTime = System.currentTimeMillis();

    /**
     * 结束时间
     */
    private long endTime = System.currentTimeMillis();

    @Getter
    private AtomicLong retryTimes = new AtomicLong(0);

    /**
     * Store additional information in extras.
     */
    @Getter
    protected Properties extras = new Properties();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person clone = (Person)super.clone();
        if (extras != null) {
            clone.setExtras((Properties) extras.clone());
        }
        if (retryTimes != null) {
            clone.setRetryTimes(new AtomicLong(retryTimes.get()));
        }
        return super.clone();
    }
}