package com.vacuum.app.metquiz.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.vacuum.app.metquiz.Adapters.ProductAdapter;
import com.vacuum.app.metquiz.MainActivity;
import com.vacuum.app.metquiz.Model.Product;
import com.vacuum.app.metquiz.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Home on 11/28/2017.
 */

public class ResultFragment extends Fragment {


    Context mContext;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.result_fragment, container, false);

        mContext = this.getActivity();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        // run the sentence in a new thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Product> products = MainActivity.get().getDB().productDao().getAll();
                boolean force = MainActivity.get().isForceUpdate();
                if (force || products.isEmpty()) {
                    retrieveProducts();
                } else {
                    populateProducts(products);
                }
                retrieveProducts();

            }
        }).start();
        return view;
    }




    private void retrieveProducts() {
        List<Product> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName(getString(R.string.name_format, String.valueOf(i)));
            product.setImageUrl("https://picsum.photos/500/500?image=" + i);
            product.setPrice(i == 0 ? 50 : i * 100);
            Log.e("TAG",product.getImageUrl().toString());
            list.add(product);
        }

        // insert product list into database
        MainActivity.get().getDB().productDao().insertAll(list);

        // disable flag for force update
        MainActivity.get().setForceUpdate(false);
        populateProducts(list);
    }

    private void populateProducts(final List<Product> products) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG","Set adabpter ================================");
                LinearLayoutManager llm = new GridLayoutManager(mContext,3);
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(new ProductAdapter(products));
            }
        });
    }

}