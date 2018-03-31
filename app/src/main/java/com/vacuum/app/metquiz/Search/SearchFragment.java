package com.vacuum.app.metquiz.Search;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vacuum.app.metquiz.MainActivity;
import com.vacuum.app.metquiz.Model.Mada_Realm;
import com.vacuum.app.metquiz.R;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

/**
 * Created by Home on 10/11/2017.
 */

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener{
    RecyclerView recyclerView;
    SearchAdapter adapter;
    SearchView editsearch;
    Context mContext;
    Realm realm;
    OrderedRealmCollection<Mada_Realm> Mada;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_two);
        editsearch = ((MainActivity) getActivity()).editsearch;
        mContext = this.getActivity();
        realm = Realm.getDefaultInstance();

        editsearch.setOnQueryTextListener(this);
        generatdata_search();

        return view;
    }




    private void generatdata_search() {

        Mada = realm.where(Mada_Realm.class).findAll();
        System.out.println("Mada.size()"+Mada.size());
        adapter = new SearchAdapter(mContext, Mada);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter.getFilter().filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (editsearch.getQuery().length() == 0) {
            adapter.getFilter().filter("");
        }
        if(editsearch.getWidth()>0)
        {
            adapter.getFilter().filter(newText);
        }
        return false;
    }
}