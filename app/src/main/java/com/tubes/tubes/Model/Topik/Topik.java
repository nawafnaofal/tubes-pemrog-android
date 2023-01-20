package com.tubes.tubes.Model.Topik;

import com.google.gson.annotations.SerializedName;

public class Topik {
    @SerializedName("id_topik")
    private String id_topik;
    @SerializedName("judul")
    private String judul;
    @SerializedName("keterangan")
    private String keterangan;


    public Topik(){}

    public Topik(String id_topik, String judul, String keterangan) {
        this.id_topik = id_topik;
        this.judul = judul;
        this.keterangan = keterangan;
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
}
