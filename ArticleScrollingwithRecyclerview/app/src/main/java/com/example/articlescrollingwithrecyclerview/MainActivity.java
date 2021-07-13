package com.example.articlescrollingwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private ArrayList<Article> articleList;
    private RecyclerView recyclerView;
    private TextView mTvAuthor;
    private CardView cardView;
    private ArticleAdapter articleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        articleAdapter=new ArticleAdapter(articleList, this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(articleAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void buildRecyclerViewData() {
        articleList=new ArrayList<>();
        Article article=new Article(R.drawable.ocean,"Mausam","Journey of Programmer");
        articleList.add(article);
        Article article1=new Article(R.drawable.skywrapper,"Rohit","Journey of Coder");
        articleList.add(article1);
        Article article2=new Article(R.drawable.ocean,"Abhimanyu","Competent Developer");
        articleList.add(article2);
        Article article3=new Article(R.drawable.skywrapper,"Ashutosh","Journey To Government Job");
        articleList.add(article3);
        Article article4=new Article(R.drawable.ocean,"Intezar","Journey of Web Developer");
        articleList.add(article4);
        Article article5=new Article(R.drawable.skywrapper,"Talib","Journey To Dubai");
        articleList.add(article5);
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recycleView);
        mTvAuthor=findViewById(R.id.tvAuthor);
        cardView=findViewById(R.id.cardView);
    }


    @Override
    public void onItemClicked(int position, Article article) {
        String name=article.getAuthor();
        Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
        articleAdapter.notifyItemChanged(position,article);

//        mTvAuthor.setVisibility(View.VISIBLE);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//           //     mTvAuthor.setVisibility(View.VISIBLE);
//                String name=article.getAuthor();
//                Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
//                articleAdapter.notifyItemChanged(position,article);
//            }
//        });

           }
}