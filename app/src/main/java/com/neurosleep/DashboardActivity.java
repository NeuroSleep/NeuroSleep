package com.neurosleep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class DashboardActivity extends Activity {
    private Button logout;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_analysis);
        new FirebaseDatabaseHelper().readAnalysis(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Analysis> analysisList, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,DashboardActivity.this,analysisList,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override 
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
