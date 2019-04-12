package com.diu.finalproject.dietplan.data_upload.network_related_class;


import com.diu.finalproject.dietplan.data_upload.model_class.ResponseModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {

    @Multipart
    @POST("/file") //Here, `upload` is the PATH PARAMETER
    Call<ResponseModel> fileUpload(
            @Part("sender_information") RequestBody description,
            @Part MultipartBody.Part file);

}
