package com.neurosleep;

public class PointValue {
}

//

//package com.neurosleep;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.github.mikephil.charting.charts.LineChart;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.LineData;
//import com.github.mikephil.charting.data.LineDataSet;
//import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DashboardActivity extends Activity {
//    private Button logout;
//    private RecyclerView mRecyclerView;
//    LineChart lineChart;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference reference = database.getReference("Analysis");
//    LineDataSet lineDataSet = new LineDataSet(null,null);
//    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
//    LineData lineData;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dashboard);
//        database = FirebaseDatabase.getInstance();
//        lineChart = findViewById(R.id.lineChart);
//        //reference=database.getReference("Analysis");
//        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_analysis);
//        lineDataSet.setLineWidth(4);
//        new FirebaseDatabaseHelper().readAnalysis(new FirebaseDatabaseHelper.DataStatus() {
//            @Override
//            public void DataIsLoaded(List<Analysis> analysisList, List<String> keys) {
//                new RecyclerView_Config().setConfig(mRecyclerView,DashboardActivity.this,analysisList,keys);
//                retrieveData();
//            }
//
//            @Override
//            public void DataIsInserted() {
//
//            }
//
//            @Override
//            public void DataIsUpdated() {
//
//            }
//
//            @Override
//            public void DataIsDeleted() {
//
//            }
//        });
//        logout = findViewById(R.id.logout);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }
//    public void retrieveData() {
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ArrayList<Entry> dataVals = new ArrayList<Entry>();
//                if (dataSnapshot.hasChildren()) {
//                    for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
//                        Analysis analysis = keyNode.getValue(Analysis.class);
//                        dataVals.add(new Entry(Float.parseFloat(analysis.getAlpha()), Float.parseFloat(analysis.getGamma())));
//                    }
//                    showChart(dataVals);
//                } else {
//                    lineChart.clear();
//                    lineChart.invalidate();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//    public void showChart(ArrayList<Entry> dataVals){
//        lineDataSet.setValues(dataVals);
//        lineDataSet.setLabel("DataSet ");
//        iLineDataSets.clear();
//        iLineDataSets.add(lineDataSet);
//        lineData = new LineData(iLineDataSets);
//        lineChart.clear();
//        lineChart.setData(lineData);
//        lineChart.invalidate();
//    }
////    @Override
////    protected void onStart(){
////        super.onStart();
////        reference.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                DataPoint[] dp = new DataPoint[(int)dataSnapshot.getChildrenCount()];
////                int index=0;
////                for(DataSnapshot keyNode:dataSnapshot.getChildren()){
////                    Analysis analysis = keyNode.getValue(Analysis.class);
////                    dp[index]=new DataPoint(Integer.parseInt(analysis.getAlpha()),Integer.parseInt(analysis.getSeconds()));
////                    index++;
////                }
////                series.resetData(new DataPoint[] {});
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////
////            }
////        });
////    }
//}