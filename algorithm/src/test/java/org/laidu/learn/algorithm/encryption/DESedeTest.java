package org.laidu.learn.algorithm.encryption;

import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class DESedeTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void encrypt() throws Exception {

        String encrypString = "15838125654";
        byte[] source = DESede.encrypt(Base64.decode(encrypString),"@xi'an%lvdian#xitongbu~&".getBytes(), "01234567".getBytes());
        log.info("new String(source) 's value : {}", Base64.encodeToString(source));
    }

    @Test
    void decrypt() throws Exception {

//        String encrypString = "Kk8Ul0RirAmpHbpS5Kd2jNJEttb56l2S3BrcHfdNZmL6cyarBgpbA5JQ74EV1KnSMYObGkB248bB7iTVy/da6JMwK6b2sK1ET28zz0nd3191ukMmlXbrv6V2XlvvWZvRWbqe1M+roolt7Pfo1wLE8Qai7Z6nuSpWyyGYvSmV2K0=";
        String encrypString = "+SqABQLTngme+5ta3MAie9sZWlhM48/q4URHBfdsnEvvw4zvrf03QzFlQUrzuoUhItDbvZ9iAQy9M9zC4uN+7gC0daWBiELR/X3Y8SsdK6A=";
        byte[] source = DESede.decrypt(Base64.decode(encrypString),"@xi'an%lvdian#xitongbu~&".getBytes(), "01234567".getBytes());
        log.info("new String(source) 's value : {}", new String(source));
    }

}