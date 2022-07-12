package com.example.aaaaa123.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aaaaa123.GridCon;
import com.example.aaaaa123.JSONPlaceHolderApi;
import com.example.aaaaa123.Post;
import com.example.aaaaa123.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatalogueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatalogueFragment extends Fragment {

    private GridView gridView;
    private TextView text;


    public static CatalogueFragment newInstance()
    {
        CatalogueFragment catalogueFragment = new CatalogueFragment();

        return catalogueFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_catalogue, null);

        gridView = (GridView) rootView.findViewById(R.id.gridView_ct1);
        text = rootView.findViewById(R.id.error_text);





        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.31.183:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful())
                {
                    text.setText("code" + response.code());
                    return;
                }
                List<Post> posts = response.body();
                GridCon gridCon = new GridCon(posts, getContext());
                /*for(Post post : posts)
                {
                    int i = 0;
                    String content = "";
                    content += "id: " + post.getId() + "\n";
                    content += "item name: " + post.getName() + "\n";
                    content += "item desc: " + post.getDesc() + "\n\n";

                    itemNames[i] = post.getName();
                    itemImages[i] = R.drawable.ic_image;

                    i++;

                    //text.append(content);
                }*/

                gridView.setAdapter(gridCon);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getActivity(), "you cliked on " + posts.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });

        return rootView;
    }

    //        gridView.findViewById(R.id.gridView);
//        GridCon gridCon = new GridCon(CatalogueActivity.this, itemNames, itemImages);
//        gridView.setAdapter(gridCon);
//

}