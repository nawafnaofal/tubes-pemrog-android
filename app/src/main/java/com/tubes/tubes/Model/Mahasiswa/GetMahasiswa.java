package com.tubes.tubes.Model.Mahasiswa;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMahasiswa {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Mahasiswa> listDataMahasiswa;
    @SerializedName("message")
    String message;

    @SerializedName("id_mahasiswa")
    private String id_mahasiswa;
    @SerializedName("nama")
    private String nama;
    @SerializedName("npm")
    private String npm;
    @SerializedName("jurusan")
    private String jurusan;

    public GetMahasiswa(String id_mahasiswa, String nama, String npm, String jurusan) {
        this.id_mahasiswa = id_mahasiswa;
        this.nama = nama;
        this.npm = npm;
        this.jurusan = jurusan;
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

    public List<Mahasiswa> getListDataMahasiswa() {
        return listDataMahasiswa;
    }
    public String getId() {
        return id_mahasiswa;
    }

    public void setId(String id_mahasiswa) {
        this.id_mahasiswa = id_mahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }
    public void setListDataMahasiswa(List<Mahasiswa> listDataMahasiswa) {
        this.listDataMahasiswa = listDataMahasiswa;
    }
}
