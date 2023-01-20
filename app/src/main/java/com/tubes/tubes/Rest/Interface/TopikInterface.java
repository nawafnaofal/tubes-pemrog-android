package com.tubes.tubes.Rest.Interface;

import com.tubes.tubes.Model.Topik.GetTopik;
import com.tubes.tubes.Model.Topik.PostPutDelTopik;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TopikInterface {
    @GET("topik")
    Call<List<GetTopik>> getTopik();
    @FormUrlEncoded
    @POST("topik")
    Call<PostPutDelTopik> postTopik(@Field("judul") String judul,
                                      @Field("keterangan") String keterangan);

    @FormUrlEncoded
    @PUT("topik")
    Call<PostPutDelTopik> putTopik(@Field("id_topik") String id_topik,
                                     @Field("judul") String judul,
                                     @Field("keterangan") String keterangan);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "topik", hasBody = true)
    Call<PostPutDelTopik> deleteTopik(@Field("id_topik") String id_topik);
}
