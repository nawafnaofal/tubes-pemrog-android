package com.tubes.tubes.Rest.Interface;

import com.tubes.tubes.Model.Mahasiswa.GetMahasiswa;
import com.tubes.tubes.Model.Mahasiswa.PostPutDelMahasiswa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("mahasiswa")
    Call<List<GetMahasiswa>> getMahasiswa();
    @FormUrlEncoded
    @POST("mahasiswa")
    Call<PostPutDelMahasiswa> postMahasiswa(@Field("nama") String nama,
                                            @Field("npm") String npm,
                                            @Field("jurusan") String jurusan);

    @FormUrlEncoded
    @PUT("mahasiswa")
    Call<PostPutDelMahasiswa> putMahasiswa(@Field("id_mahasiswa") String id_mahasiswa,
                                           @Field("nama") String nama,
                                           @Field("npm") String npm,
                                           @Field("jurusan") String jurusan);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "mahasiswa", hasBody = true)
    Call<PostPutDelMahasiswa> deleteMahasiswa(@Field("id_mahasiswa") String id_mahasiswa);

}
