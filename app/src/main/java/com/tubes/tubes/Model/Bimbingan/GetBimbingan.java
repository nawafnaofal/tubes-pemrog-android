package com.tubes.tubes.Model.Bimbingan;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBimbingan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Bimbingan> listDataBimbingan;
    @SerializedName("message")
    String message;

    @SerializedName("id_bimbingan")
    private String id_bimbingan;
    @SerializedName("id_mahasiswa")
    private String id_mahasiswa;
    @SerializedName("id_mentor")
    private String id_mentor;
    @SerializedName("id_topik")
    private String id_topik;
    @SerializedName("waktu")
    private String waktu;

    public GetBimbingan(String id_bimbingan, String id_mahasiswa, String id_mentor, String id_topik, String waktu) {
        this.id_bimbingan = id_bimbingan;
        this.id_mahasiswa = id_mahasiswa;
        this.id_mentor = id_mentor;
        this.id_topik = id_topik;
        this.waktu = waktu;

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

    public List<Bimbingan> getListDataBimbingan() {
        return listDataBimbingan;
    }

    public String getId() {
        return id_bimbingan;
    }

    public void setId(String id_bimbingan) {
        this.id_bimbingan = id_bimbingan;
    }

    public String getIdMahasiswa() {
        return id_mahasiswa;
    }

    public void setIdMahasiswa(String id_mahasiswa) {
        this.id_mahasiswa = id_mahasiswa;
    }

    public String getIdMentor() {
        return id_mentor;
    }

    public void setIdMentor(String id_mentor) {
        this.id_mentor = id_mentor;
    }

    public String getIdTopik() {
        return id_topik;
    }

    public void setIdTopik(String id_topik) {
        this.id_topik = id_topik;
    }

    public String getWaktu() {
        return id_topik;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }



    public void setListDataBimbingan(List<Bimbingan> listDataBimbingan) {
        this.listDataBimbingan = listDataBimbingan;
    }
}
