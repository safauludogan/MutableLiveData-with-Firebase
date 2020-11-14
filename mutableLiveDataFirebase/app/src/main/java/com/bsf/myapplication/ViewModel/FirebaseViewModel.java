package com.bsf.myapplication.ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bsf.myapplication.Model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseViewModel extends ViewModel {

    public MutableLiveData<Boolean> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Model>> usersLiveData;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceFoods;
    private List<Model> foods = new ArrayList<>();

    public MutableLiveData<List<Model>> getData() {
        if (usersLiveData == null) {
            errorLiveData.setValue(true);
            usersLiveData = new MutableLiveData<>();
            getDataFromFB();
        }
        return usersLiveData;
    }

    private void getDataFromFB() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceFoods = mDatabase.getReference("FOODS");
        mReferenceFoods.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                foods.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot keyNode : snapshot.getChildren()) {
                        Model model = keyNode.getValue(Model.class);
                        foods.add(model);
                        errorLiveData.setValue(false);
                    }
                    usersLiveData.setValue(foods);
                }else{
                    usersLiveData.setValue(null);
                    foods.clear();
                    errorLiveData.setValue(true);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                errorLiveData.setValue(true);
            }
        });
    }

}
