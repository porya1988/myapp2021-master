package com.example.myapp2021.comments;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp2021.model.Comment;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.commentViewHolder> {

    Context context;
    List<Comment> commentList;

    public CommentsAdapter(Context context,List<Comment> commentList){
        this.context=context;
        this.commentList=commentList;
    }


    @NonNull
    @Override
    public CommentsAdapter.commentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.commentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class commentViewHolder extends RecyclerView.ViewHolder {
        public commentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
