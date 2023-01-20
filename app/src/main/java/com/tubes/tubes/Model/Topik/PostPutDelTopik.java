package com.tubes.tubes.Model.Topik;

import com.google.gson.annotations.SerializedName;
import com.tubes.tubes.Model.Topik.Topik;

public class PostPutDelTopik {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Topik mTopik;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Topik getTopik() {
        return mTopik;
    }
    public void setTopik(Topik Topik) {
        mTopik = Topik;
    }
}
