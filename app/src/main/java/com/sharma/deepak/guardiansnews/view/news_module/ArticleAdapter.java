package com.sharma.deepak.guardiansnews.view.news_module;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sharma.deepak.guardiansnews.R;
import com.sharma.deepak.guardiansnews.bean.news_api.NewsResults;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by deepak on 26-05-2018
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolderPattern> {
    private List<NewsResults> articleListDetail;
    private Context context;
    OnArticleClickListener onArticleClickListener;

    public interface OnArticleClickListener {
        void OnArticleClick(String url);
    }

    public ArticleAdapter(Context context, OnArticleClickListener onArticleClickListener, List<NewsResults> articleListDetail) {
        this.context = context;
        this.onArticleClickListener = onArticleClickListener;
        this.articleListDetail = articleListDetail;
    }

    @Override
    public ArticleHolderPattern onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item_list, parent, false);
        return new ArticleHolderPattern(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleHolderPattern holder, int position) {
        NewsResults article = articleListDetail.get(position);
        holder.tvTitle.setText(article.getWebTitle());
        String[] dateAndTime = article.getWebPublicationDate().split("T");
        String date = dateAndTime[0];
        holder.tvDate.setText(date);
        holder.tvSection.setText(article.getSectionName());
    }

    @Override
    public int getItemCount() {
        return articleListDetail.size();
    }

    class ArticleHolderPattern extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_article_name)
        TextView tvTitle;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_section_name)
        TextView tvSection;

        public ArticleHolderPattern(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(itemView);
            tvTitle = itemView.findViewById(R.id.tv_article_name);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvSection = itemView.findViewById(R.id.tv_section_name);
        }

        @Override
        public void onClick(View v) {
            onArticleClickListener.OnArticleClick(articleListDetail.get(getAdapterPosition()).getWebUrl());
        }
    }

}

