package org.laidu.learn.network.retrofit.usage;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.network.retrofit.usage.api.ZhongminbaoxianService;
import org.laidu.learn.network.retrofit.usage.mode.PriceQes;
import org.laidu.learn.network.retrofit.usage.mode.PriceReq;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 使用
 *
 * @author tiancai.zang
 * on 2018-08-27 11:33.
 */
@Slf4j
public class BasicUsage {


    private final static int[] DURATIONS = {5, 10, 15, 20, 30};
    private final static int[] QUOTA = {5, 10, 15, 20, 25, 30};



    public static void main(String[] args) {

        Retrofit retrofit = getRetrofit();


        ZhongminbaoxianService service = retrofit.create(ZhongminbaoxianService.class);


        PriceReq req = JSON.parseObject(" {\n" +
                "        \"pid\": 10059,\n" +
                "        \"sid\": 1,\n" +
                "        \"bid\": 12,\n" +
                "        \"typeStr\": \"LongMain\",\n" +
                "        \"birthday\": \"2012-07-01\",\n" +
                "        \"proType\": 0,\n" +
                "        \"age\": 0,\n" + // 年龄
                "        \"male\": 1,\n" + // 性别 男0 女1
                "        \"baoeList\": [\n" +
                "            {\n" +
                "                \"code\": \"MajorDis\",\n" +
                "                \"value\": \"100000\",\n" + // 保额 5 10 15 20 25 30万 QUOTA
                "                \"comCode\": \"110021-110221 \"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"socialSecurity\": 0,\n" +
                "        \"policyTerm\": 120,\n" +
                "        \"policyTermType\": 4,\n" +
                "        \"periods\": 30,\n" + // 期限  DURATIONS
                "        \"periodType\": 1\n" +
                "    }", PriceReq.class);


        getPrice(service, req);


    }

    private static void getPrice(ZhongminbaoxianService service, PriceReq req) {


        Map<Integer, Map<Integer, Double>> plan1 = initPlan();


        Call<String> call = service.getPrice(new PriceReq[]{req});

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PriceQes res = JSON.parseObject(response.body(),PriceQes.class);
                    System.out.println(response.body());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                log.error("call.request().body()'s value : {}", call.request().body());
            }
        });
    }

    private static Map<Integer, Map<Integer, Double>> initPlan() {
        Map<Integer, Map<Integer, Double>> plan = new HashMap<>();

        IntStream.range(0,50).forEach(i -> {
            
        });


        return plan;
    }

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                    .baseUrl("https://www.zhongmin.cn/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
    }
}