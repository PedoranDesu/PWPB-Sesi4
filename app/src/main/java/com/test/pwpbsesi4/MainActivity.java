package com.test.pwpbsesi4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Hero> heroList;
    ListView listViewHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroList = new ArrayList<>();
        listViewHero = findViewById(R.id.list_view);

        heroList.add(new Hero(R.drawable.spiderman,"Spiderman","Avengers"));
        heroList.add(new Hero(R.drawable.ironman,"Iron Man","Avengers"));
        heroList.add(new Hero(R.drawable.doctorstrange,"Doctor Strange","Avengers"));
        heroList.add(new Hero(R.drawable.captainamerica,"Captain America","Avengers"));
        heroList.add(new Hero(R.drawable.joker,"Joker","Injustice Gang"));
        heroList.add(new Hero(R.drawable.batman,"Batman","Justice League"));

        HeroListAdapter heroAdapt = new HeroListAdapter(heroList,this,R.layout.my_custom_list);
        listViewHero.setAdapter(heroAdapt);


        Button btnLat1 = findViewById(R.id.btn_to_lat1);
        btnLat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this,Latihan1.class);
                startActivity(pindah);
            }
        });
    }
}
