package org.laidu.learn.google.auto.value.model;

import com.google.auto.value.AutoValue;

/**
 * Animal.
 * User: zangtiancai
 * Date: 2017/8/29
 * Time: 下午2:13
 */
@AutoValue
abstract class Animal {

    abstract String name();

    abstract int numberOfLegs();

    public static Animal create(String name, int numberOfLegs) {
        return builder()
                .name(name)
                .numberOfLegs(numberOfLegs)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_Animal.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder numberOfLegs(int numberOfLegs);

        public abstract Animal build();
    }

}