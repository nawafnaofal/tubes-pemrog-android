package com.tubes.tubes.Model.Bimbingan;

import com.google.gson.annotations.SerializedName;

public class PostPutDelBimbingan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Bimbingan mBimbingan;
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
    public Bimbingan getBimbingan() {
        return mBimbingan;
    }
    public void setBimbingan(Bimbingan Bimbingan) {
        mBimbingan = Bimbingan;
    }
}
