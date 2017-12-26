package org.laidu.learn.design.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cloneable impl
 * <p>
 * Created by tiancai.zang on 2017-12-25 14-19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {
    private String name;
    private int sex;
    private String job;

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}