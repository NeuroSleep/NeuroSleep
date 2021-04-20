package com.neurosleep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private AnalysisAdapter mAnalysisAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Analysis> analysis, List<String> keys){
        mContext = context;
        mAnalysisAdapter = new AnalysisAdapter(analysis, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAnalysisAdapter);
    }
    class AnalysisItemView extends RecyclerView.ViewHolder{
        private TextView mDelta;
        private TextView mTheta;
        private TextView mAlpha;
        private TextView mBeta;
        private TextView mGamma;
        private TextView mSeconds;

        private String key;
        public AnalysisItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.analysis_list_item, parent,false));
        mDelta = (TextView) itemView.findViewById(R.id.delta_textView);
        mTheta = (TextView) itemView.findViewById(R.id.theta_textView);
        mAlpha = (TextView) itemView.findViewById(R.id.alpha_textView);
        mBeta = (TextView) itemView.findViewById(R.id.beta_textView);
        mGamma = (TextView) itemView.findViewById(R.id.gamma_textView);
        mSeconds = (TextView) itemView.findViewById(R.id.seconds_textView);
        }
        public void bind(Analysis analysis, String key){
            mDelta.setText(String.valueOf(analysis.getDelta()));
            mTheta.setText(String.valueOf(analysis.getTheta()));
            mAlpha.setText(String.valueOf(analysis.getAlpha()));
            mBeta.setText(String.valueOf(analysis.getBeta()));
            mGamma.setText(String.valueOf(analysis.getGamma()));
            mSeconds.setText(String.valueOf(analysis.getSeconds()));
            this.key = key;
        }
    }
    class AnalysisAdapter extends RecyclerView.Adapter<AnalysisItemView>{
        private List<Analysis> mAnalysisList;
        private List<String> mKeys;

        public AnalysisAdapter(List<Analysis> mAnalysisList, List<String> mKeys) {
            this.mAnalysisList = mAnalysisList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public AnalysisItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AnalysisItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AnalysisItemView holder, int position) {
            holder.bind(mAnalysisList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mAnalysisList.size();
        }
    }

}