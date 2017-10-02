package com.knews.android.articles

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.knews.android.R
import com.knews.android.data.Article

/**
 * Created by asafvaron on 02/10/2017.
 */
class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleItemViewHolder>() {

    var data: List<Article> = emptyList()

    fun setItems(items: List<Article>) {
        this.data = items
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ArticleItemViewHolder, position: Int) {
        val article = data[position]
        val context = holder.itemView.context
        holder.title.text = article.title
        holder.author.text = article.author
        holder.description.text = article.description
        holder.publishedAt.text = article.publishedAt
        Glide.with(context)
                .load(article.imageUrl)
                .into(holder.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_item, parent, false)

        return ArticleItemViewHolder(view)
    }

    inner class ArticleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val author: TextView = itemView.findViewById(R.id.author)
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val publishedAt: TextView = itemView.findViewById(R.id.published_at)
        val image: ImageView = itemView.findViewById(R.id.image)
    }
}