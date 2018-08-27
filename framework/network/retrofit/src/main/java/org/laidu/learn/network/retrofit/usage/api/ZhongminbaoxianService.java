package org.laidu.learn.network.retrofit.usage.api;

import org.laidu.learn.network.retrofit.usage.mode.PriceReq;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 测试使用的json服务
 * <p>
 * Created by laidu
 * on 2018-08-27 11:35.
 *
 * curl 'https://www.zhongmin.cn/product/price/getPrice'
 * -H 'Cookie: JSESSIONID=0F828CBC9B367B5FF50BDC0167446BC3; __jsluid=a62852f6bb75ee5cdff823e3e356bd9b; PIDDAB666666=2018082710081357094289; FVTDAB666666=636709612939928688; LVTDAB666666=636709612939928688; VTSDAB666666=1; MSTSDAB666666=0; SIDDAB666666=7c4a63dfee9e4f58b0d8ddaa1780ed5c; cookieUserName=cookie3c83ee2c153f3782b1336e57b348144e; Hm_lvt_9634323798be51b19359016bdfd65b32=1535335696; browseInfo=%5B%7B%22url%22%3A%22https%3A//www.zhongmin.cn/health/detail/ip10059_is1.html%22%2C%22productImg%22%3A%22//images.zhongmin.cn/images/2018/320/10059.jpg%22%2C%22productName%22%3A%22%u590D%u661F%u8054%u5408%u5EB7%u4E50%u4E00%u751F%u91CD%u5927%u75BE%u75C5%u4FDD%u9669B%u6B3E%u5347%u7EA7%u6B3E%22%2C%22price%22%3A%22129%22%2C%22pid%22%3A%2210059%22%7D%5D; VPSDAB666666=2; Hm_lpvt_9634323798be51b19359016bdfd65b32=1535335776'
 * -H 'Origin: https://www.zhongmin.cn'
 * -H 'Accept-Encoding: gzip, deflate, br' -H 'Accept-Language: zh-CN,zh;q=0.9' -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36'
 * -H 'Content-Type: application/json' -H 'Accept: application/json, text/javascript, **; q=0.01'
 * -H 'Referer: https://www.zhongmin.cn/health/detail/ip10059_is1.html'
 * -H 'X-Requested-With: XMLHttpRequest'
 * -H 'Connection: keep-alive'
 * --data-binary '[{"pid":10059,"sid":1,"bid":12,"typeStr":"LongMain","proType":0,"age":0,"male":1,"baoeList":[{"code":"MajorDis","value":"100000","comCode":"110021-110221 "}],"socialSecurity":0,"policyTerm":70,"policyTermType":3,"periods":30,"periodType":1}]'
 * --compressed
 *
 * @author laidu
 */
public interface ZhongminbaoxianService {

    @POST("product/price/getPrice")
    Call<String> getPrice(@Body PriceReq[] req);
}
