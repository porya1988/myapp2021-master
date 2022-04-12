package com.example.myapp2021.comments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.CommentRowBinding;
import com.example.myapp2021.model.Comment;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.commentViewHolder> {


    List<Comment> commentList;
    CommentRowBinding binding;
    LayoutInflater inflater;


    public CommentsAdapter(List<Comment> commentList){
        inflater= LayoutInflater.from(AppConfiguration.getContext());
        this.commentList=commentList;
    }




    @NonNull
    @Override
    public CommentsAdapter.commentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(inflater, R.layout.comment_row,parent,false);
        return new commentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.commentViewHolder holder, int position) {
         Comment comment=commentList.get(position);
         binding.setComment(comment);
    }

    @Override
    public int getItemCount() {
        return commentList.size();

    }

    public class commentViewHolder extends RecyclerView.ViewHolder {
       CommentRowBinding binding;
        public commentViewHolder( CommentRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
