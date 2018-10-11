package org.laidu.learn.network.retrofit.usage.local.api;

import com.alibaba.fastjson.JSONObject;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * 资源服务器
 * <p>
 * Created by laidu
 * on 2018-10-11 14:37.
 *
 * @author laidu
 */
public interface ResourceService {


    @Multipart
    @POST("/resource/upload")
    Call<JSONObject> upload(@Part("description") RequestBody description, @Part MultipartBody.Part file);


    /**
     * @param filename
     * @return
     */
    @GET("/resource/files/{filename}")
    Call<ResponseBody> download(@Path("filename") String filename);
}
