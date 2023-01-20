package com.tubes.tubes.Model.Mentor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMentor {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Mentor> listDataMentor;
    @SerializedName("message")
    String message;

    @SerializedName("id_mentor")
    private String id_mentor;
    @SerializedName("nama")
    private String nama;
    @SerializedName("nip")
    private String nip;


    public GetMentor(String id_mentor, String nama, String nip) {
        this.id_mentor = id_mentor;
        this.nama = nama;
        this.nip = nip;
    }

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

    public List<Mentor> getListDataMentor() {
        return listDataMentor;
    }
    public String getId() {
        return id_mentor;
    }

    public void setId(String id_mentor) {
        this.id_mentor = id_mentor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setListDataMentor(List<Mentor> listDataMentor) {
        this.listDataMentor = listDataMentor;
    }
}
