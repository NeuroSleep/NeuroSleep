package com.neurosleep;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper{
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceAnalysis;
    private List<Analysis> analysisList = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Analysis> analysisList, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceAnalysis = mDatabase.getReference("Analysis");
    }

    public void readAnalysis(final DataStatus dataStatus){
        mReferenceAnalysis.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                analysisList.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Analysis analysis = keyNode.getValue(Analysis.class);
                    analysisList.add(analysis);
                }
                dataStatus.DataIsLoaded(analysisList,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
