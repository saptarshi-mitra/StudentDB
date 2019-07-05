package com.iamsm.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class DisplayActivity extends AppCompatActivity {
    private static final String TAG = "Experiment";
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mRecyclerView=findViewById(R.id.recycler);
        Log.i(TAG, "onCreate: before adapter creation" + "Also the recyclerView id is " + mRecyclerView.getId());
        Realm realm=Realm.getDefaultInstance();
        RealmResults<Student> studentRealmResults = realm.where(Student.class).findAll();
        MyAdapter myAdapter=new MyAdapter(studentRealmResults,this);
        Log.i(TAG, "onCreate: After adapter creation");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.i(TAG, "onCreate: After linear layout manager creation and setting");
        mRecyclerView.setAdapter(myAdapter);
        Log.i(TAG, "onCreate: After setAdapter");

    }
}
