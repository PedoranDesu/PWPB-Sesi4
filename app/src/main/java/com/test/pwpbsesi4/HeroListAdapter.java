package com.test.pwpbsesi4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HeroListAdapter extends ArrayAdapter<Hero> {
    List<Hero> heroList;

    Context context;

    int resource;

    public HeroListAdapter(List<Hero> heroList, Context context, int resource) {
        super(context, resource, heroList);
        this.heroList = heroList;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,@NonNull ViewGroup parent) {
        //ngambil layout custom dan pake inflater
        LayoutInflater inflaterHero = LayoutInflater.from(context);
        //buat view customnya
        View view = inflaterHero.inflate(resource,null,false);
        //inisialisasi komponen dari view custom
        ImageView imgView = view.findViewById(R.id.img_hero);
        TextView txtName = view.findViewById(R.id.txt_name);
        TextView txtTeam = view.findViewById(R.id.txt_team);
        Button btnDelete = view.findViewById(R.id.btnDelete);
        //simpan Hero di posisi....
        Hero hero = heroList.get(position);

        //time to GET HELL!!
        imgView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        txtName.setText(hero.getName());
        txtTeam.setText(hero.getTeam());
        //btn delete on click, YEAH!!
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeHero(position);
            }
        });

        return view;
    }

    private void removeHero(final int pos){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are You Sure You Want To DELETE This?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //removed that shit after confirmation
                heroList.remove(pos);
        //reloading list
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
