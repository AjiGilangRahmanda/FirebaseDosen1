package com.example.firebasedosen1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DosenListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DosenAdapter adapter;
    private ArrayList<Dosen> dosenList;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_list);

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dosenList = new ArrayList<>();
        adapter = new DosenAdapter(this);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("dosen");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dosenList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Dosen dosen = postSnapshot.getValue(Dosen.class);
                    dosenList.add(dosen);
                }
                adapter.setDosenList(dosenList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle possible errors.
            }
        });
    }
}
