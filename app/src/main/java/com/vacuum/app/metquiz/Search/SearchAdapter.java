package com.vacuum.app.metquiz.Search;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vacuum.app.metquiz.Model.Mada_Realm;
import com.vacuum.app.metquiz.R;


import java.util.List;

import io.realm.Case;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by Home on 10/11/2017.
 */
 public class SearchAdapter  extends RealmRecyclerViewAdapter<Mada_Realm, RecyclerView.ViewHolder> implements Filterable {
    Realm realm;
    private List<Mada_Realm> Mada;
    private Context mContext;
    public static int expandedPosition = -1;


    public SearchAdapter(Context mContext, OrderedRealmCollection<Mada_Realm> Mada) {
        super(Mada, true);
        this.mContext = mContext;
        realm = Realm.getDefaultInstance();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Mada_Realm mada = getData().get(position);

        MyViewHolder mHolder = (MyViewHolder) holder;
        mHolder.mada_title.setText(mada.getMada_title());
        mHolder.mada_num.setText(mada.getMada_num());
        if (position == expandedPosition) {
            mHolder.llExpandArea.setVisibility(View.VISIBLE);
        } else {
            mHolder.llExpandArea.setVisibility(View.GONE);
        }
    }

    public void filterResults(String text) {
        text = text == null ? null : text.toLowerCase().trim();
        if (text == null || "".equals(text)) {
            updateData(realm.where(Mada_Realm.class).findAll());
        } else {
            updateData(realm.where(Mada_Realm.class)
                    .contains("mada_title", text, Case.INSENSITIVE) // TODO: change field
                    .findAll());
        }
    }

    public android.widget.Filter getFilter() {
        RealmFilter filter = new RealmFilter(this);
        return filter;
    }

    private class RealmFilter extends android.widget.Filter {
        private final SearchAdapter adapter;

        private RealmFilter(SearchAdapter adapter) {
            super();
            this.adapter = adapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            return new FilterResults();
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.filterResults(constraint.toString());
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mada_title, mada_num, update, comments, old_update, old_title;
        public LinearLayout llExpandArea;
        CardView Btn_Comment;

        public MyViewHolder(View view) {
            super(view);
            mada_title = view.findViewById(R.id.mada_title);
            mada_num = view.findViewById(R.id.mada_num);
            update = view.findViewById(R.id.update);
            comments = view.findViewById(R.id.comments);
            llExpandArea = view.findViewById(R.id.llExpandArea);
            old_update = view.findViewById(R.id.old_update);
            old_title = view.findViewById(R.id.old_title);
            Btn_Comment = view.findViewById(R.id.Btn_Comment);

        }
    }
}
