package com.tubes.tubes.Model.Topik;

import com.google.gson.annotations.SerializedName;
import com.tubes.tubes.Model.Topik.Topik;

import java.util.List;

public class GetTopik {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Topik> listDataTopik;
    @SerializedName("message")
    String message;

    @SerializedName("id_topik")
    private String id_topik;
    @SerializedName("judul")
    private String judul;
    @SerializedName("keterangan")
    private String keterangan;

    public GetTopik(String id_topik, String judul, String keterangan) {
        this.id_topik = id_topik;
        this.judul = judul;
        this.keterangan = keterangan;
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

    public List<Topik> getListDataTopik() {
        return listDataTopik;
    }
    public String getId() {
        return id_topik;
    }

    public void setId(String id_topik) {
        this.id_topik = id_topik;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setListDataTopik(List<Topik> listDataTopik) {
        this.listDataTopik = listDataTopik;
    }
}
