package com.tubes.tubes.Rest.Interface;

import com.tubes.tubes.Model.Bimbingan.GetBimbingan;
import com.tubes.tubes.Model.Bimbingan.PostPutDelBimbingan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface BimbinganInterface {

    @GET("bimbingan")
    Call<List<GetBimbingan>> getBimbingan();
    @FormUrlEncoded
    @POST("bimbingan")
    Call<PostPutDelBimbingan> postBimbingan(@Field("id_mahasiswa") String id_mahasiswa,
                                            @Field("id_mentor") String id_mentor,
                                            @Field("id_topik") String id_topik,
                                            @Field("waktu") String waktu);

    @FormUrlEncoded
    @PUT("bimbingan")
    Call<PostPutDelBimbingan> putBimbingan(@Field("id_bimbingan") String id_bimbingan,
                                           @Field("id_mahasiswa") String id_mahasiswa,
                                           @Field("id_mentor") String id_mentor,
                                           @Field("id_topik") String id_topik,
                                           @Field("waktu") String waktu);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "bimbingan", hasBody = true)
    Call<PostPutDelBimbingan> deleteBimbingan(@Field("id_bimbingan") String id_bimbingan);



}
