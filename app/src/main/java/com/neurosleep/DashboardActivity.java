package com.neurosleep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends Activity {
    private Button logout;
    private RecyclerView mRecyclerView;
    LineChart lineChart;
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
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(),"Delta");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(),"Alpha");
        LineDataSet lineDataSet3 = new LineDataSet(dataValues3(),"Theta");
        LineDataSet lineDataSet4 = new LineDataSet(dataValues4(),"Beta");
        LineDataSet lineDataSet5 = new LineDataSet(dataValues4(),"Gamma");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        lineDataSet1.setLineWidth(8);
        lineDataSet2.setLineWidth(8);
        dataSets.add(lineDataSet2);
        //dataSets.add(lineDataSet3);
       // dataSets.add(lineDataSet4);
      //  dataSets.add(lineDataSet5);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();

        reference=database.getReference("Analysis");
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
private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,1));
        dataVals.add(new Entry(1,2));
        dataVals.add(new Entry(2,4));
        dataVals.add(new Entry(3,3));
        dataVals.add(new Entry(4,1));
        return dataVals;
}
    private ArrayList<Entry> dataValues2(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,8));
        dataVals.add(new Entry(1,9));
        dataVals.add(new Entry(2,12));
        dataVals.add(new Entry(3,8));
        dataVals.add(new Entry(4,10));
        return dataVals;
    }
    private ArrayList<Entry> dataValues3(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,4));
        dataVals.add(new Entry(1,6));
        dataVals.add(new Entry(2,8));
        dataVals.add(new Entry(3,5));
        dataVals.add(new Entry(4,6));
        return dataVals;
    }
    private ArrayList<Entry> dataValues4(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,12));
        dataVals.add(new Entry(1,20));
        dataVals.add(new Entry(2,23));
        dataVals.add(new Entry(3,30));
        dataVals.add(new Entry(4,15));
        return dataVals;
    }
    private ArrayList<Entry> dataValues5(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,35));
        dataVals.add(new Entry(1,37));
        dataVals.add(new Entry(2,45));
        dataVals.add(new Entry(3,40));
        dataVals.add(new Entry(4,35));
        return dataVals;
    }
//    @Override
//    protected void onStart(){
//        super.onStart();
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                DataPoint[] dp = new DataPoint[(int)dataSnapshot.getChildrenCount()];
//                int index=0;
//                for(DataSnapshot keyNode:dataSnapshot.getChildren()){
//                    Analysis analysis = keyNode.getValue(Analysis.class);
//                    dp[index]=new DataPoint(Integer.parseInt(analysis.getAlpha()),Integer.parseInt(analysis.getSeconds()));
//                    index++;
//                }
//                series.resetData(new DataPoint[] {});
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}
