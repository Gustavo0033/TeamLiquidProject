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

public class LiquidActivity extends AppCompatActivity {

    private RecyclerView rvMainLiquid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquid);


        rvMainLiquid = findViewById(R.id.main_rvLiquid);
        List<Mainitem> mainItems = new ArrayList<>();
        mainItems.add(new Mainitem(1, R.drawable.ssssssssssssssssssss, R.string.AgasalhoTL, Color.WHITE));
        mainItems.add(new Mainitem(2, R.drawable.fortiniteblusa, R.string.FortniteBLusa, Color.WHITE));
        mainItems.add(new Mainitem(3, R.drawable.casualliquid, R.string.CasualTL, Color.WHITE));
        mainItems.add(new Mainitem(4, R.drawable.liquidbranca, R.string.EsportivaTL, Color.WHITE));
        mainItems.add(new Mainitem(5, R.drawable.camisetaazulcampeonato, R.string.CamisetaAzulCamp, Color.WHITE));
        mainItems.add(new Mainitem(6, R.drawable.cal_ajogger, R.string.CalcaJogger, Color.WHITE));

        rvMainLiquid.setLayoutManager(new GridLayoutManager(this, 2));
        MainAdapter adapter = new MainAdapter(mainItems);


        adapter.setListener(id ->{
            switch (id){
                case 1:
                    startActivity(new Intent(LiquidActivity.this, ProdutoBlusa.class));
                    break;
                case 2:
                    startActivity(new Intent(LiquidActivity.this, LiquidFortnite.class));
                    break;

        }
        });



        rvMainLiquid.setAdapter(adapter);

    }

    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

        private List<Mainitem> mainItems;
        private OnitemClickListener Listener;

        public MainAdapter(List<Mainitem> mainitems) {
            this.mainItems = mainitems;
        }

        public void setListener(OnitemClickListener listener) {
            Listener = listener;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.liquid_main_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull LiquidActivity.MainAdapter.MainViewHolder holder, int position) {
        Mainitem mainItemCurrent = mainItems.get(position);
        holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();




        }
        private class MainViewHolder extends RecyclerView.ViewHolder{


            public MainViewHolder(@NonNull View itemView) {
                super(itemView);

            }
            public void bind (Mainitem item){
                TextView txtName = itemView.findViewById(R.id.item_txt_name);
                ImageView imgICon = itemView.findViewById(R.id.item_img_icon);
                LinearLayout container = (LinearLayout) itemView;

                container.setOnClickListener(View ->{
                Intent intent = new Intent(LiquidActivity.this, ProdutoBlusa.class);
                startActivity(intent);
                });

                container.setOnClickListener(view ->{
                    Listener.onClick(item.getId());

                    rvMainLiquid.setOnClickListener(View ->{
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




