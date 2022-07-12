package com.example.aaaaa123;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {

    @GET("get_product_details.php")
    Call<List<Post>> getPost();

}
