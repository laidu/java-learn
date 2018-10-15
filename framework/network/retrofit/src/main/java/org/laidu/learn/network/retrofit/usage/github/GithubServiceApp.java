package org.laidu.learn.network.retrofit.usage.github;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.network.retrofit.usage.github.api.GitHubService;
import org.laidu.learn.network.retrofit.usage.github.dto.ApiSummaryRes;
import org.laidu.learn.network.retrofit.usage.github.dto.UserBasicInfo;
import retrofit2.Response;
import retrofit2.Retrofit;
import xyz.xpcoder.common.retrofit.converter.fastjson.FastjsonConverterFactory;

import java.io.IOException;

/**
 * github api app
 *
 * @author tiancai.zang
 * on 2018-10-11 09:55.
 */
@Slf4j
public class GithubServiceApp {


    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);

        Response<ApiSummaryRes> response = gitHubService.apiSummary()
                .execute();


        String username = "laidu";
        Response<UserBasicInfo> userBasicInfo = gitHubService.getUserBasicInfo(username)
                .execute();

        log.info(": {}", userBasicInfo.body());


    }
}