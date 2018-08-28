
package org.laidu.learn.network.retrofit.usage.mode;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PriceQes implements Serializable {

    @SerializedName("code")
    private Long mCode;
    @SerializedName("data")
    private Data mData;
    @SerializedName("message")
    private String mMessage;

    public Long getCode() {
        return mCode;
    }

    public void setCode(Long code) {
        mCode = code;
    }

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
