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
        byte[] source = DESede.encrypt(Base64.decode(encrypString), "@xi'an%lvdian#xitongbu~&".getBytes(), "01234567".getBytes());
        log.info("new String(source) 's value : {}", Base64.encodeToString(source));
    }

    @Test
    void decrypt() throws Exception {

        String encrypString = "Kk8Ul0RirAmpHbpS5Kd2jNJEttb56l2S3BrcHfdNZmL6cyarBgpbA5JQ74EV1KnSMYObGkB248bB7iTVy/da6JMwK6b2sK1ET28zz0nd3191ukMmlXbrv6V2XlvvWZvRWbqe1M+roolt7Pfo1wLE8Qai7Z6nuSpWyyGYvSmV2K0=";
//        String encrypString = "+SqABQLTngme+5ta3MAie9sZWlhM48/q4URHBfdsnEvvw4zvrf03QzFlQUrzuoUhItDbvZ9iAQy9M9zC4uN+7gC0daWBiELR/X3Y8SsdK6A=";
        byte[] source = DESede.decrypt(Base64.decode(encrypString), "@xi'an%lvdian#xitongbu~&".getBytes(), "01234567".getBytes());
        log.info("new String(source) 's value : {}", new String(source));
    }

    @Test
    void decrypt1() throws Exception {

//        String encrypString = "tpU56yxqMfMzGzDO1zApo4uKU0S72j5aiWklRT+BZ3JuSiJAnozaP4pUyvPHUriIPCyqz3WrPFdvQfOhM/rIsKHl8rapeCR7RCfXLC+a35GF7DSTIUcEjM/E3CULKaQIaKwRAIlUpkQ/HzvV5OxIJkitUYvToHuI";
//        String encrypString = "lXAMG0mJ3Vj95uytdjyxG0dqtXylyHXDc4oExQaPlcpg/mrr5jQhtO94mlNN6V5ynAtPGbfQ4gCEAl8WBQm3Wn7GwgFKpdmYWa3CDEUxAoIMFOBwVMvPVmlRRHjU++PADngJ8vRgzGm7lyqNHzCziyj4zszsColpTuBEqrgwOULAMAVamc3zHsFa1vl5vzCfclKlqDg91jvxpt3Zz+q8YSd4fkEDzaz4e6tICkPiXdUVVAWnX5miY/ZHAbq6XHMtGtzlhrWX0i7iBVI0kEw6LZyb5drPFCtNB5jRiGOGcMEIZxjHqdcskdY1PPYL4h3CWQcs9NOr6iVxHUkc6SBFVdlpCuRBURXGlfu52v1ZNT8jD1xkaz5arSxlJFiirVq26hI4/uQDosqRZy+63YegVCxbvkUUUXkfY2AhFCVqTNc7E/Hxdl6CcFQPWHmB59knH3xcFWehi11oF/PYeQbLFk0XmC8CN/JRgR1v1bus7r3zzrTvJdL2YdRSscCLtmlgb+G5/5ZxqAzeFfs7SQd0ocfOOzlFkK5YeRIIX0PNjIxS6RfwWwlZjbXW/oGmKOId2LcHdhuWeIZPkpgUtbW7mzzzVQwMz35+vL/Rz9pYgZr6tl1kQRUnpSFgACDoC0M68UPmtFLSgFYk2TGl0VQOaQmlFl6dvlDKZXUU06hREuuyFKtmKkEjzZO7SfZAdtwvUvQ9aMsuTvJGWVio0FrQlL+cLbs2ktEhhQSeo6Yqs+8zNG1sbzCLeEimsfZS4eLtZL/daM/JWKoDgEkDaKXrcBI3gkQQx6Yhgkjz64r1iCHyxd0nw8i94igoVsao0GuFWKjoZlTM942bWcQyfePfzb8/27ltZSkjbyGFuKlWW+ymbS5cioGwGkRT4LecGraOaWX6t+tofbT+PcflLLzJkcjTorEus4NojzeU+5Z8t8HZSqEnXfjzr86MIexiNs0RV/S/JKfIKRY9dhEksf3LbmmqXvHjQpTaxjgRBE/6PiDPRorFt9/I6KsEfLR8SIe8VhwDUXiD1phvH0pGWzAhI7Xu7/A/I6JB5NojhQTP/muIUFG8kGAvtXqL9pshbTrZPO/pl0yKGAf3VN3QViD/OCyNOmjMbjQsFc2kf3Ro4I1xvd5hRPU3Uz/JKRMgstlYsiZ7y9+FoCDBmeAgfa3uTmNsBVWWOBXNuqdmwTksCc9xPgm/0FUtvHY4oyNopoMEkJUk1Li1ODQ=";
        String encrypString = "tpU56yxqMfMzGzDO1zApo4uKU0S72j5aiWklRT+BZ3JuSiJAnozaP4pUyvPHUriIPCyqz3WrPFdvQfOhM/rIsKHl8rapeCR7RCfXLC+a35GF7DSTIUcEjM/E3CULKaQIaKwRAIlUpkQ/HzvV5OxIJkitUYvToHuI";
        byte[] source = DESede.decrypt(Base64.decode(encrypString), "qazwUIUY45gftyu7689014dv".getBytes(), "08965438".getBytes());
        log.info("new String(source) 's value : {}", new String(source));
    }

    @Test
    void encrypt1() throws Exception {

        String encrypString = "{\"RequestParams\":{\"PhoneNo\":\"13241847378\",\"UUID\":\"7297894caecc7a31\",\"UserPwd\":\"2AA1CEDF567ED470313F3EC328E9E10E\",\"channelId\":\"happiness\",\"deviceId\":\"bfe0d224-61a6-3701-bc5e-b38d2e58c6ec\",\"deviceType\":\"android\",\"location\":\"\",\"osVersion\":\"6.0.1\",\"phoneModel\":\"Coolpad\",\"userId\":\"\",\"version\":\"2.1.0\"},\"deviceId\":\"bfe0d224-61a6-3701-bc5e-b38d2e58c6ec\",\"deviceType\":\"android\",\"latitude\":\"39.921154\",\"longitude\":\"116.419624\",\"pushToken\":\"13065ffa4e02776121d\",\"requestUrl\":\"logon\",\"responseClass\":\"com.happycfc.finance.gen.response.LogonResponse\",\"returnCode\":null,\"returnMsg\":null,\"tag\":\"LoginActivity\",\"token\":\"\",\"tongdunId\":\"eyJvcyI6ImFuZHJvaWQiLCJ2ZXJzaW9uIjoiMy4xLjEiLCJwYWNrYWdlcyI6ImNvbS5oYXBweWNmYy5maW5hbmNlXzIuMS4wIiwicHJvZmlsZV90aW1lIjoyNjAsImludGVydmFsX3RpbWUiOjQ2MjksInRva2VuX2lkIjoidHJyYWVLWk5aQ1hCdHV1d1puS2lcL2RVaXFQbnV1U3duRXEzcitBU1graHFnNlwvbk1rXC84endhTzlPMXhiVGNVWE96ckpFbmFUMW9yQnRKQXBWWU55Vmc9PSJ9\"}";
        byte[] source = DESede.encrypt(encrypString.getBytes(), "qazwUIUY45gftyu7689014dv".getBytes(), "08965438".getBytes());
        log.info("new String(source) 's value : {}", Base64.encodeToString(source));
    }

}