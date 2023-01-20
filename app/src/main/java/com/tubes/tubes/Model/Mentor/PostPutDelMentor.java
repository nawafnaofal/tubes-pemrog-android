package com.tubes.tubes.Model.Mentor;
import com.google.gson.annotations.SerializedName;
import com.tubes.tubes.Model.Mentor.Mentor;

public class PostPutDelMentor {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Mentor mMentor;
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
    public Mentor getMentor() {
        return mMentor;
    }
    public void setMentor(Mentor Mentor) {
        mMentor = Mentor;
    }
}
