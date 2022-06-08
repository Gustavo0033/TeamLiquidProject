package com.example.teamliquidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
        Liquidmain = findViewById(R.id.main_Liquid);

        List<Mainitem> mainItems = new ArrayList<>();
        mainItems.add(new Mainitem(1, R.drawable.sem_t_tulo_1, R.string.Loja, Color.WHITE));
        mainItems.add(new Mainitem(2, R.drawable.signup, R.string.SignUP, Color.WHITE));
        mainItems.add(new Mainitem(3, R.drawable.campeonatos, R.string.Campeonatos, Color.WHITE));
        mainItems.add(new Mainitem(4, R.drawable.signin, R.string.SignUP, Color.WHITE));
        mainItems.add(new Mainitem(5, R.drawable.liquidplayers02, R.string.Players, Color.WHITE));




        Liquidmain.setLayoutManager(new GridLayoutManager(this, 2));
        MainAdapter adapter = new MainAdapter(mainItems);
        Liquidmain.setAdapter(adapter);


        adapter.setListener(id ->{
            switch (id) {
                case 1:
                    startActivity(new Intent(MainActivity.this, LiquidActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, signUP.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, CampeonatosTL.class));
                    break;
                case 4:
                    startActivity(new Intent(MainActivity.this, SIGNIN.class));
                    break;
                case 5:
                    startActivity(new Intent(MainActivity.this, PLAYERSTL.class));
                    break;
            }
        });

        Liquidmain.setAdapter(adapter);


    }
    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

       private List<Mainitem> mainItems;
       private OnitemClickListener Listener;

        public MainAdapter(List<Mainitem> mainitems) {
            this.mainItems = mainitems;
        }
        public void setListener(OnitemClickListener listener) {
            this.Listener = listener;
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
        private class MainViewHolder extends RecyclerView.ViewHolder{

            public MainViewHolder(@NonNull View itemView) {
                super(itemView);
            }
            public void bind( Mainitem item) {
                TextView txtName = itemView.findViewById(R.id.txt_loja);
                ImageView imgICon = itemView.findViewById(R.id.Liquid_logo);
                LinearLayout container = (LinearLayout) itemView;

                container.setOnClickListener(view ->{
                        Listener.onClick(item.getId());

                        Liquidmain.setOnClickListener(View ->{
                        Listener.onClick(item.getId());
                        });
            });

                txtName.setText(item.getTextStringId());
                imgICon.setImageResource(item.getDrawbleid());
                container.setBackgroundColor(item.getColor());
            }

        }


    }
    }
