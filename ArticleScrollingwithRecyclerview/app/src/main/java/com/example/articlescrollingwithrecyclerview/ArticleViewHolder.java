package com.example.articlescrollingwithrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private TextView mTvAuthor, mTvTitle;
    private ItemClickListener itemClickListener;
    private CardView cardView;

    public ArticleViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener=itemClickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        mIvImage=itemView.findViewById(R.id.ivImage);
        mTvAuthor=itemView.findViewById(R.id.tvAuthor);
        mTvTitle=itemView.findViewById(R.id.tvTitle);
        cardView=itemView.findViewById(R.id.cardView);
    }

    public void setData(Article article) {
        mIvImage.setImageResource(article.getImage());
        mTvTitle.setText(article.getTitle());
        mTvAuthor.setText(article.getAuthor());

        //to display the author name
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(),article);

            }
        });
    }
}
