package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Ringtone;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        hashMap = new HashMap<>();
        hashMap.put("itemtype", "BOOK");
        hashMap.put("name", "আমি  তোমাকে ভালোবাসি");
        hashMap.put("tittle", "sowrov islam");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Itemtype", "VIDEO");
        hashMap.put("name", "tumi  mor jiboner vabo na");
        hashMap.put("tittle", "AMI TOMAKE");
        arrayList.add(hashMap);

        // adap call


        Myadapter myadapter=new Myadapter();
        recyclerView.setAdapter(myadapter);

       recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));













    }





    // Adapter view in this jone


    private class Myadapter extends RecyclerView.Adapter {

        int BOOK=0;
        int VIDEO=1;



        private class myViewHoldar extends RecyclerView.ViewHolder {


            public myViewHoldar(@NonNull View itemView) {

                super(itemView);
            }
        }


        private class myViewHolder2 extends RecyclerView.ViewHolder {


            public myViewHolder2(@NonNull View itemView) {
                super(itemView);
            }
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater= getLayoutInflater();

            if (viewType==BOOK){

                View myview =layoutInflater.inflate(R.layout.layout,parent,false);

         return new myViewHoldar(myview);

            }else {

                View myview = layoutInflater.inflate(R.layout.layout2, parent, false);


                return new myViewHolder2(myview);

            }





        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        @Override
        public int getItemViewType(int position) {
//            return super.getItemViewType(position);

            hashMap = arrayList.get(position);
            String itemtype = hashMap.get("itemtype");


            if (itemtype.contains("BOOK"))

                return BOOK;



            else

                return VIDEO;



        }
    }


}





