package com.example.week4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private static ArrayList<Article> ay;
    private OnNoteListener mOnNoteListener;

    public RecyclerViewAdapter(OnNoteListener onNoteListener) {
        this.mOnNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, parent, false);
        ViewHolder userViewHolder = new ViewHolder(view,mOnNoteListener);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //User userAtPosition = users.get(position);
        Article article = ay.get(position);
        holder.tv_head.setText(article.getHeadline());
        holder.tv_content.setText(article.getContent());
    }

    @Override
    public int getItemCount() {
        return ay.size();
    }

    public void setData (ArrayList<Article> ay) {
        RecyclerViewAdapter.ay = ay;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout parent_layout;
        LinearLayout ll_1;
        LinearLayout ll_2;
        TextView tv_head;
        TextView tv_content;
        Button button;
        ImageButton ib_c;
        ImageButton ib_share;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            tv_head = itemView.findViewById(R.id.tv_head);
            tv_content = itemView.findViewById(R.id.tv_content);
            ib_c = itemView.findViewById(R.id.ib_c);
            ib_share = itemView.findViewById(R.id.ib_share);
            parent_layout = itemView.findViewById(R.id.parent_layout);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}
