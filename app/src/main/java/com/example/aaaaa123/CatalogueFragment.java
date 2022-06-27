package com.example.aaaaa123;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatalogueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatalogueFragment extends Fragment {

    private GridView gridView;
    private ArrayAdapter<String> adapter;
    String[] itemNames = {"item1","item2","item3","item4",
            "item5","item6","item7","item8"};
    int[] itemImages = {R.drawable.ic_image,R.drawable.ic_image,
            R.drawable.ic_image,R.drawable.ic_image,
            R.drawable.ic_image,R.drawable.ic_image,
            R.drawable.ic_image,R.drawable.ic_image};

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
        GridCon gridCon = new GridCon(getContext(), itemNames, itemImages);
        gridView.setAdapter(gridCon);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Toast.makeText(getActivity(), "you cliked on " + itemNames[position], Toast.LENGTH_SHORT).show();
                                          }
                                       });

        return rootView;
    }

    //        gridView.findViewById(R.id.gridView);
//        GridCon gridCon = new GridCon(CatalogueActivity.this, itemNames, itemImages);
//        gridView.setAdapter(gridCon);
//

}