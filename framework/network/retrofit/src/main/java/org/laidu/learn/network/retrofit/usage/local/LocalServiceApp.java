package org.laidu.learn.network.retrofit.usage.local;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.laidu.learn.network.retrofit.usage.local.api.ResourceService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import xyz.xpcoder.common.retrofit.converter.fastjson.FastjsonConverterFactory;

import java.io.*;

/**
 * @author tiancai.zang
 * on 2018-10-11 14:44.
 */
@Slf4j
public class LocalServiceApp {

    private static boolean writeResponseBodyToDisk(String filename,ResponseBody body) {
        try {
            File futureStudioIconFile = new File(SystemUtils.getUserHome()+"/temp/"+filename);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    log.debug("file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://local-dev:8080/")
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();

        ResourceService service = retrofit.create(ResourceService.class);

        fileDownload(service);

    }

    public static void fileDownload(ResourceService service) {
        String filename = "20180928172521278582030156351166.xls";

        service.download(filename)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            log.debug("server contacted and has file");

                            boolean writtenToDisk = writeResponseBodyToDisk(filename,response.body());

                            log.debug("file download was a success? " + writtenToDisk);
                        } else {
                            log.debug("server contact failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        log.error("文件下载失败");
                    }
                });

        log.info(": {}");
    }

    public static void fileUpload(ResourceService service) throws IOException {
        String filename = "/Downloads/20180928172521278582030156351166.xls";
        File file = FileUtils.getFile(SystemUtils.getUserHome()+filename);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(""),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        MultipartBody.FORM, descriptionString);

        Response<JSONObject> response = service.upload(description, body).execute();

        log.info("result: {}", response.body());
    }
}