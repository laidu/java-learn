
package org.laidu.learn.network.retrofit.usage.mode;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BaoeList {

    @SerializedName("code")
    private String mCode;
    @SerializedName("comCode")
    private String mComCode;
    @SerializedName("value")
    private String mValue;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getComCode() {
        return mComCode;
    }

    public void setComCode(String comCode) {
        mComCode = comCode;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
