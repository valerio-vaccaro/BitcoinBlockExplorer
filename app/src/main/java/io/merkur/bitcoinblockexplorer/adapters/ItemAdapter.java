package io.merkur.bitcoinblockexplorer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import io.merkur.bitcoinblockexplorer.R;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private HashMap<String,String> mDataset = new HashMap<>();

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTvKey,mTvValue;
        public ViewHolder(View v) {
            super(v);
            mTvKey = (TextView) v.findViewById(R.id.tvKey);
            mTvValue = (TextView) v.findViewById(R.id.tvValue);
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public ItemAdapter(HashMap<String,String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTvKey.setText("");
        holder.mTvValue.setText("");
        synchronized (mDataset) {
            try {
                String key = (String)(mDataset.keySet().toArray()[position]);
                String value = (String) (mDataset.values().toArray())[position];

                holder.mTvKey.setText(key);
                holder.mTvValue.setText(value);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}