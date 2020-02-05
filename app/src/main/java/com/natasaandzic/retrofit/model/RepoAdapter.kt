package com.natasaandzic.retrofit.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.repo_list_item.view.*

class RepoAdapter(val rowLayout: Int, val context: Context, val repos: List<Repo>) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val repoLayout: LinearLayout = itemView.repoItemLayout
        val repoName: TextView = itemView.repoNameTv
        val repoDescription: TextView = itemView.repoDescriptionTv
        val repoLanguage: TextView = itemView.repoLanguageTv

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.repoName.setText(repos[position].name)
        holder.repoDescription.setText(repos[position].description)
        holder.repoLanguage.setText(repos[position].language)
    }

}