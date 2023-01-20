package com.tubes.tubes.Model.Mahasiswa;
import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    @SerializedName("id_mahasiswa")
    private String id_mahasiswa;
    @SerializedName("nama")
    private String nama;
    @SerializedName("npm")
    private String npm;
    @SerializedName("jurusan")
    private String jurusan;


    public Mahasiswa(){}

    public Mahasiswa(String id_mahasiswa, String nama, String npm, String jurusan) {
        this.id_mahasiswa = id_mahasiswa;
        this.nama = nama;
        this.npm = npm;
        this.jurusan = jurusan;
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

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
