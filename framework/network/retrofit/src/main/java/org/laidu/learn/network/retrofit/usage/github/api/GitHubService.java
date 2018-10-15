package org.laidu.learn.network.retrofit.usage.github.api;

import org.laidu.learn.network.retrofit.usage.github.dto.ApiSummaryRes;
import org.laidu.learn.network.retrofit.usage.github.dto.UserBasicInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * github service api
 * <p>
 * Created by laidu
 * on 2018-10-11 09:53.
 *
 * @author laidu
 */
public interface GitHubService {

    /**
     * github api summary
     * @return
     */
    @GET("/")
    Call<ApiSummaryRes> apiSummary();

    /**
     * 获取基本的用户信息
     * @param username
     * @return
     */
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/users/{username}")
    Call<UserBasicInfo> getUserBasicInfo(@Path("username") String username);


}
