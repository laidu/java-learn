package org.laidu.learn.network.retrofit.usage.github;

import lombok.extern.slf4j.Slf4j;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.laidu.learn.network.retrofit.usage.github.api.GitHubService;
import org.laidu.learn.network.retrofit.usage.github.dto.UserBasicInfo;
import retrofit2.Response;
import retrofit2.Retrofit;
import xyz.xpcoder.common.retrofit.converter.fastjson.FastjsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * github api app
 *
 * @author tiancai.zang
 * on 2018-10-11 09:55.
 */
@Slf4j
public class GithubServiceApp {


    public static void main(String[] args) throws IOException {

        String baseUrl = "http://";

        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(500, TimeUnit.MILLISECONDS)
                .eventListener(new EventListener() {

                })
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("api.github.com")
                .port(80)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(httpUrl)
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);

        String username = "laidu";
        Response<UserBasicInfo> userBasicInfo = gitHubService.getUserBasicInfo(username)
                .execute();

        log.info("username : {}", userBasicInfo.body().getLogin());


    }
}