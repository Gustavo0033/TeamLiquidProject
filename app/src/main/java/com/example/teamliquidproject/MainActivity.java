package com.example.teamliquidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView Liquidmain;
    private View btn_signIN;
    private View btn_signUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Mainitem> mainItems = new ArrayList<>();
        mainItems.add(new Mainitem(1, R.drawable._00px_team_liquid_2020_full_lightmode, R.string.app_name, Color.BLUE));
        mainItems.add(new Mainitem(1, R.drawable._00px_team_liquid_2020_full_lightmode, R.string.app_name, Color.GREEN));
        mainItems.add(new Mainitem(1, R.drawable._00px_team_liquid_2020_full_lightmode, R.string.app_name, Color.RED));
        mainItems.add(new Mainitem(1, R.drawable.og_logo, R.string.app_name, Color.GRAY));
        mainItems.add(new Mainitem(1, R.drawable.og_logo, R.string.app_name, Color.MAGENTA));



        Liquidmain = findViewById(R.id.main_Liquid);
        Liquidmain.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter(mainItems);
        Liquidmain.setAdapter(adapter);







    }
    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder>{

       private List<Mainitem> mainItems;

        public MainAdapter(List<Mainitem> mainitems) {
            this.mainItems = mainitems;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.liquid_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Mainitem mainItemCurretn = mainItems.get(position);
        holder.bind(mainItemCurretn);
        }

        @Override
        public int getItemCount() {
            return mainItems.size() ;
        }
    }

    private class MainViewHolder extends RecyclerView.ViewHolder{

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind( Mainitem item) {
            TextView txtName = itemView.findViewById(R.id.txt_loja);
            ImageView imgICon = itemView.findViewById(R.id.Liquid_logo);
            LinearLayout container = (LinearLayout) itemView;

            txtName.setText(item.getTextStringId());
            imgICon.setImageResource(item.getDrawbleid());
            container.setBackgroundColor(item.getColor());
        }
    }


}