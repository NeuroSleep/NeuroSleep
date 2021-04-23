package com.neurosleep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends Activity {
    private Button logout;
    private RecyclerView mRecyclerView;
    LineChart lineChart;
    Analysis analysis;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Analysis");
    LineDataSet lineDataSet = new LineDataSet(null,null);
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        database = FirebaseDatabase.getInstance();
        lineChart = findViewById(R.id.lineChart);

        reference=database.getReference("Analysis");
        lineDataSet.setLineWidth(5);
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



    @Override
    protected void onStart() {
        super.onStart();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList<Entry> dataVals = new ArrayList<Entry>();
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                        Analysis analysis = keyNode.getValue(Analysis.class);
                            dataVals.add(new Entry(Float.parseFloat(analysis.getSeconds()),Float.parseFloat(analysis.getGamma())));
                            lineChart.animateX(5000);
                    }
                    showChart(dataVals);
                } else {
                    dataVals.add(new Entry(0, 0));
                    lineChart.clear();
                    lineChart.invalidate();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

    private void showChart(ArrayList<Entry> dataVals){
        lineDataSet.setValues(dataVals);
        lineDataSet.setLabel("Alpha");
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData(iLineDataSets);
        lineChart.clear();
        lineChart.setData(lineData);
        lineChart.invalidate();
    }
}
