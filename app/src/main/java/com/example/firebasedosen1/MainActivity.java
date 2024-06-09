package com.example.firebasedosen1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btCreateDB;
    private Button btViewDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btCreateDB = findViewById(R.id.bt_createdata);
        btViewDB = findViewById(R.id.bt_viewdata);

        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch DBCreateActivity to create new dosen data
                startActivity(DBCreateActivity.getActIntent(MainActivity.this));
            }
        });

        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch DosenListActivity to view dosen data
                Intent intent = new Intent(MainActivity.this, DosenListActivity.class);
                startActivity(intent);
            }
        });
    }
}
