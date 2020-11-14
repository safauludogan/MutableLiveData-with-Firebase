package com.bsf.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bsf.myapplication.Adapter.RecyclerAdapter;
import com.bsf.myapplication.Model.Model;
import com.bsf.myapplication.ViewModel.FirebaseViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    Button addDataBtn, getDataBtn;
    FirebaseViewModel firebaseViewModel;
    private DatabaseReference mDatabase;
    List<Model> listModel = new ArrayList<>();
    ProgressBar progress;
    TextView progressTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDataBtn = findViewById(R.id.addDataBtn);
        getDataBtn = findViewById(R.id.getDataBtn);
        recyclerView = findViewById(R.id.recyclerView);
        progress = findViewById(R.id.progress);
        progressTV = findViewById(R.id.progressTV);

        firebaseViewModel = ViewModelProviders.of(this).get(FirebaseViewModel.class);


        initBtnClick();
        getData();
        dataControl();
    }

    private void dataControl() {
        firebaseViewModel.errorLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {//true ise hata
                    progress.setVisibility(View.VISIBLE);
                    progressTV.setVisibility(View.VISIBLE);
                } else {
                    progress.setVisibility(View.INVISIBLE);
                    progressTV.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void getData() {//getData MutableLiveData
        firebaseViewModel.getData().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
               // if (models!=null){
                    listModel = models;
                    recyclerAdapter = new RecyclerAdapter(MainActivity.this, listModel);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(recyclerAdapter);
                    recyclerAdapter.notifyDataSetChanged();
               // }
            }
        });
    }


    public void initBtnClick() {
        addDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase = FirebaseDatabase.getInstance().getReference();
                String uid = String.valueOf(UUID.randomUUID());

                Model model = new Model(
                        "Baklava",
                        "900",
                        "3",
                        "300",
                        "400",
                        "Baklavanın kalorisi fazla"
                );

                mDatabase.child("FOODS").child(uid).setValue(model);
            }
        });
    }
}