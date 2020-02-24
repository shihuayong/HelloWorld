package com.shihuayong.wechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shihuayong.wechat.models.Tweet;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetHolder> {
    private final List<Tweet> tweets;

    public TweetAdapter(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public TweetHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.moments_tweet, null);
        return new TweetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.nickName.setText(tweet.getSender().getNick());
        holder.content.setText(tweet.getContent());
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public static class TweetHolder extends RecyclerView.ViewHolder {
        private TextView nickName;
        private TextView content;

        public TweetHolder(@NonNull View itemView) {
            super(itemView);
            nickName = itemView.findViewById(R.id.tweet_nickname);
            content = itemView.findViewById(R.id.tweet_content);
        }

    }
}
