package com.tubes.tubes.Model.Mentor;
import com.google.gson.annotations.SerializedName;

public class Mentor {
    @SerializedName("id_mentor")
    private String id_mentor;
    @SerializedName("nama")
    private String nama;
    @SerializedName("nip")
    private String nip;


    public Mentor(){}

    public Mentor(String id_mentor, String nama, String nip) {
        this.id_mentor = id_mentor;
        this.nama = nama;
        this.nip = nip;
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

}
