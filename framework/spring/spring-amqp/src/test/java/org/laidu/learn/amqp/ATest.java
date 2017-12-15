package org.laidu.learn.amqp;

import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * Created by tiancai.zang on 2017-11-30 20:03.
 */
@Slf4j
public class ATest {



    public static void main(String[] args) {

        BigInteger pubKey = new BigInteger("e8ed5abd9b79b311ee84daac3b1384ede6c13ae90bf7327956684bab80a7f0a1ff28a1fed77472ca1ad2f5c24df9bd0ee0076b1df709e071a008b3beed966336be91f2c8437aa319249af16b495f3c5b22c0a37cc9c33d30837cb38af0521a4121be5fa9d3d77f5f8431c804db4cac78bb31a2df72566f4735285349f99ddde7", 16);

        System.out.println(Base64.encodeToString(pubKey.toString()));
        System.out.println(String.valueOf(pubKey.toString()));

    }

}