package org.o7planning.katetube;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("comments");

    Button but_back1, but_next1, nBut_comment;
    EditText nEditTextComment;
    RecyclerView nCommentsRecycler;

    ArrayList <String> comments = new ArrayList<>();

    private  static int MAX_COMMENT_LENGTH=50;


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

        nBut_comment = findViewById(R.id.but_comment);
        nEditTextComment = findViewById(R.id.comment);
        nCommentsRecycler = findViewById(R.id.comment_recycler);

        nCommentsRecycler.setLayoutManager( new LinearLayoutManager( this ));


        DataAdapter dataAdapter = new DataAdapter(this, comments);

        nCommentsRecycler.setAdapter(dataAdapter);



        nBut_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comt = nEditTextComment.getText().toString();

                if (comt.equals("") ){

                    Toast.makeText(getApplicationContext(),"Введите комментарий", Toast.LENGTH_SHORT). show();
                    return;

                }

                if (comt.length() > MAX_COMMENT_LENGTH) {

                    Toast.makeText(getApplicationContext(),"Превышен лимит символов", Toast.LENGTH_SHORT). show();
                    return;

                }

                myRef.push().setValue(comt);
                nEditTextComment.setText("");
            }
        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot datasnapshot, @Nullable String previousChildName) {
                String comt = datasnapshot.getValue(String.class);
                comments.add(comt);
                dataAdapter.notifyDataSetChanged();
                nCommentsRecycler.smoothScrollToPosition(comments.size());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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




