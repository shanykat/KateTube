package org.o7planning.katetube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button but_back1, but_next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_back1 = (Button) findViewById(R.id.but_back1);
        but_back1.setOnClickListener(this);
        but_next1 = (Button) findViewById(R.id.but_next1);
        but_next1.setOnClickListener(this);


        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "lBJyaIR1mlw";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_next1:
                //переходим ко второй активити
                Intent intent = new Intent (this, MainActivity2.class);
                startActivity(intent);
                break;
            default:
                break;


        }
    }
}




