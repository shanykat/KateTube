package org.o7planning.katetube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    Button but_back2, but_next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        but_back2 = (Button) findViewById(R.id.but_back2);
//        but_back2.setOnClickListener(this);
//        but_next2 = (Button) findViewById(R.id.but_next2);
//        but_next2.setOnClickListener(this);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S_dfq9rFWAE";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }
    public void clickButback2(View view) {
        switch (view.getId()) {
            case R.id.but_back2:
                // возвращаемся на первую активити
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    public void clickButnext2(View view) {
        switch (view.getId()) {
            case R.id.but_next2:
                // переходим на третью активити
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                break;
            default:
                break;
        }
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.but_next2:
//                // переходим на третью активити
//                Intent intent = new Intent (this, MainActivity3.class);
//                startActivity(intent);
//
//                break;
//            default:
//                break;
//
//
//        }
//    }
    }
}