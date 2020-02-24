package com.shihuayong.wechat;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.shihuayong.wechat.data.Requests;
import com.shihuayong.wechat.models.Tweet;
import com.shihuayong.wechat.utils.ThreadUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MomentsActivity extends AppCompatActivity {

    private List<Tweet> tweets = new ArrayList<>();
    private RecyclerView tweetListView;

    private ImageView tweetAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tweetAvatar = findViewById(R.id.tweet_avatar);

//        Glide.with(this)
//                .load("http://info.thoughtworks.com/rs/thoughtworks2/images/glyph_badge.png")
//                .dontAnimate()
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_foreground)
//                .into(tweetAvatar);

        // 适配Tweet列表
        tweetListView = findViewById(R.id.tweet_list);
        tweetListView.setLayoutManager(new LinearLayoutManager(this));
        tweetListView.setAdapter(new TweetAdapter(tweets));

        updateTweets();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateTweets() {
        ThreadUtils.run(new Runnable() {
            @Override
            public void run() {
                List<Tweet> tweets = Requests.tweets();
                updateTweets(tweets);
            }
        });
    }

    private void updateTweets(final List<Tweet> tweets) {
        ThreadUtils.postOnMainThread(new Runnable() {
            @Override
            public void run() {
                MomentsActivity.this.tweets.clear();
                MomentsActivity.this.tweets.addAll(tweets);
                tweetListView.getAdapter().notifyDataSetChanged();
            }
        });
    }
}
