package com.tubes.tubes.Rest.Interface;

import com.tubes.tubes.Model.Mentor.GetMentor;
import com.tubes.tubes.Model.Mentor.PostPutDelMentor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface MentorInterface {
    @GET("mentor")
    Call<List<GetMentor>> getMentor();
    @FormUrlEncoded
    @POST("mentor")
    Call<PostPutDelMentor> postMentor(@Field("nama") String nama,
                                            @Field("nip") String nip);

    @FormUrlEncoded
    @PUT("mentor")
    Call<PostPutDelMentor> putMentor(@Field("id_mentor") String id_mentor,
                                           @Field("nama") String nama,
                                           @Field("nip") String nip);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "mentor", hasBody = true)
    Call<PostPutDelMentor> deleteMentor(@Field("id_mentor") String id_mentor);
}
