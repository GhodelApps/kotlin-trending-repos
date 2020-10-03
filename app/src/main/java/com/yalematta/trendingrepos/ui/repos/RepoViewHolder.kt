package com.yalematta.trendingrepos.ui.repos

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yalematta.trendingrepos.R
import com.yalematta.trendingrepos.data.model.Repo
import com.yalematta.trendingrepos.databinding.ItemTrendingRepoBinding

class RepoViewHolder(private val binding: ItemTrendingRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repo: Repo) {
        binding.apply {
            Glide.with(itemView)
                .load(repo.owner.avatar_url)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(android.R.drawable.stat_notify_error)
                .into(avatar)

            name.text = String.format(
                itemView.context.getString(R.string.repo_name), repo.owner.login, repo.name)

            description.text = repo.description

            language.text = repo.language

            stars.text = repo.stars.toString()

            forks.text = repo.forks.toString()
        }
    }
}