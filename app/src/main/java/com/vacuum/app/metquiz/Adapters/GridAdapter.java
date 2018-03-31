package com.vacuum.app.metquiz.Adapters;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vacuum.app.metquiz.Fragments.BarcodeFragment;
import com.vacuum.app.metquiz.Fragments.Questions;
import com.vacuum.app.metquiz.MainActivity;
import com.vacuum.app.metquiz.Model.Item;
import com.vacuum.app.metquiz.Model.Person;
import com.vacuum.app.metquiz.NavigationDrawer.SettingsFragment;
import com.vacuum.app.metquiz.R;

import java.util.List;

import io.realm.Realm;

import static android.support.v4.content.ContextCompat.checkSelfPermission;
import static com.vacuum.app.metquiz.MainActivity.TAG_Barcodescanner;
import static com.vacuum.app.metquiz.MainActivity.TAG_HOME;
import static com.vacuum.app.metquiz.MainActivity.TAG_QUESTIONS;
import static com.vacuum.app.metquiz.MainActivity.TAG_SETTINGS;

/**
 * Created by Home on 2017-08-29.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    private List<Item> items;
    Realm realm;
    private Context mContext;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;
        public Button circle;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
            circle = (Button) view.findViewById(R.id.circle);

        }

    }


    public GridAdapter(List<Item> items, Context mContext) {
        this.items = items;
        this.mContext = mContext;
        realm =  Realm.getDefaultInstance();

    }

    @Override
    public GridAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_layout, parent, false);

        return new GridAdapter.MyViewHolder(itemView);
    }





    @Override
    public void onBindViewHolder(GridAdapter.MyViewHolder holder, final int position) {
        Typeface Gess_two = Typeface.createFromAsset(mContext.getAssets(),
                "fonts/GE_SS_Two_Bold.otf");

        holder.title.setText(items.get(position).getMada_title());
        holder.image.setImageResource(items.get(position).getImage());

        //=========================================
        holder.title.setTypeface(Gess_two);
        //=========================================
        //if(position == items.size()-2|| position == items.size()-1)
        if(realm.where(Person.class).equalTo("tableAndId","e7taty").findAll().size() == 0&&position == items.size()-1)
        {
            holder.circle.setVisibility(View.VISIBLE);
        }
        if(realm.where(Person.class).equalTo("tableAndId","asasy").findAll().size() == 0&&position == items.size()-2)
        {
            holder.circle.setVisibility(View.VISIBLE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0){
                    Toast.makeText(mContext, "this is number " +position, Toast.LENGTH_SHORT).show();
                }else if(position == 1){
                    Questions questions = new Questions();
                    loadfragment(questions,TAG_QUESTIONS);
                }else if(position == 2){
                    Toast.makeText(mContext, "this is number " +position, Toast.LENGTH_SHORT).show();
                }else if(position == 4){

                    if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED)
                    {
                        FragmentActivity activity = (FragmentActivity) mContext;
                        ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.CAMERA}, 100);
                    }else {
                        BarcodeFragment barcodeFragment = new BarcodeFragment();
                        loadfragment(barcodeFragment,TAG_Barcodescanner);
                    }

                }
                else {
                    SettingsFragment settingsFragment = new SettingsFragment();
                    loadfragment(settingsFragment,TAG_SETTINGS);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void loadfragment(Fragment Fragment,String TAG) {
        FragmentActivity activity = (FragmentActivity) mContext;
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.container, Fragment, TAG);
        fragmentTransaction.addToBackStack(TAG_HOME);
        fragmentTransaction.commitAllowingStateLoss();
    }


}
