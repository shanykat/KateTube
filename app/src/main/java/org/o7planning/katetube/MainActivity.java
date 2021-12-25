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

public class MainActivity extends AppCompatActivity {

    Button but_back1, but_next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public void clickButnext1 (View view){
        switch (view.getId()) {
            case R.id.but_next1:
                // переходим на вторую активити
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    public void clickButback1 (View view){
        switch (view.getId()) {
            case R.id.but_back1:
                // возвращаемся на третью активити
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}




