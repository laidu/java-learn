
package org.laidu.learn.network.retrofit.usage.mode;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PriceReq {

    @SerializedName("age")
    private Long mAge;
    @SerializedName("baoeList")
    private List<BaoeList> mBaoeList;
    @SerializedName("bid")
    private Long mBid;
    @SerializedName("male")
    private Long mMale;
    @SerializedName("periodType")
    private Long mPeriodType;
    @SerializedName("periods")
    private Long mPeriods;
    @SerializedName("pid")
    private Long mPid;
    @SerializedName("policyTerm")
    private Long mPolicyTerm;
    @SerializedName("policyTermType")
    private Long mPolicyTermType;
    @SerializedName("proType")
    private Long mProType;
    @SerializedName("sid")
    private Long mSid;
    @SerializedName("socialSecurity")
    private Long mSocialSecurity;
    @SerializedName("typeStr")
    private String mTypeStr;

    public Long getAge() {
        return mAge;
    }

    public void setAge(Long age) {
        mAge = age;
    }

    public List<BaoeList> getBaoeList() {
        return mBaoeList;
    }

    public void setBaoeList(List<BaoeList> baoeList) {
        mBaoeList = baoeList;
    }

    public Long getBid() {
        return mBid;
    }

    public void setBid(Long bid) {
        mBid = bid;
    }

    public Long getMale() {
        return mMale;
    }

    public void setMale(Long male) {
        mMale = male;
    }

    public Long getPeriodType() {
        return mPeriodType;
    }

    public void setPeriodType(Long periodType) {
        mPeriodType = periodType;
    }

    public Long getPeriods() {
        return mPeriods;
    }

    public void setPeriods(Long periods) {
        mPeriods = periods;
    }

    public Long getPid() {
        return mPid;
    }

    public void setPid(Long pid) {
        mPid = pid;
    }

    public Long getPolicyTerm() {
        return mPolicyTerm;
    }

    public void setPolicyTerm(Long policyTerm) {
        mPolicyTerm = policyTerm;
    }

    public Long getPolicyTermType() {
        return mPolicyTermType;
    }

    public void setPolicyTermType(Long policyTermType) {
        mPolicyTermType = policyTermType;
    }

    public Long getProType() {
        return mProType;
    }

    public void setProType(Long proType) {
        mProType = proType;
    }

    public Long getSid() {
        return mSid;
    }

    public void setSid(Long sid) {
        mSid = sid;
    }

    public Long getSocialSecurity() {
        return mSocialSecurity;
    }

    public void setSocialSecurity(Long socialSecurity) {
        mSocialSecurity = socialSecurity;
    }

    public String getTypeStr() {
        return mTypeStr;
    }

    public void setTypeStr(String typeStr) {
        mTypeStr = typeStr;
    }

}
