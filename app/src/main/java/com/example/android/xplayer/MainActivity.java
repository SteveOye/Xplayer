package com.example.android.xplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView noOfTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create and arrayList
        final ArrayList<Playlist> tracks = new ArrayList<>();
        //adding contains(words) to the arrayList
        tracks.add(new Playlist(R.drawable.air_i_birth,"The Air", "Jerry K", "6:15"));
        tracks.add(new Playlist(R.drawable.desire,"Desire", "FreshlyGround", "3:38"));
        tracks.add(new Playlist(R.drawable.divine,"Divine Intervention", "Akon", "3:56"));
        tracks.add(new Playlist(R.drawable.eye,"Eye of the Needle", "Sia", "4:09"));
        tracks.add(new Playlist(R.drawable.eye,"Fair Game", "Sia", "3:51"));
        tracks.add(new Playlist(R.drawable.fire,"Fire and Desire", "Drake", "3:58"));
        tracks.add(new Playlist(R.drawable.hand,"Hand of God", "Unknown Artist", "5:37"));
        tracks.add(new Playlist(R.drawable.mali,"Heavy Love", "Mali", "3:20"));
        tracks.add(new Playlist(R.drawable.mali,"I Believe", "Mali Music", "3:53"));
        tracks.add(new Playlist(R.drawable.identity,"Identity", "James Fortune & Fiya", "4:42"));
        tracks.add(new Playlist(R.drawable.kolafiwe,"Kolafiwe", "Dolapo", "4:46"));
        tracks.add(new Playlist(R.drawable.love,"Love me Like You Do", "Ellie Goulding", "4:12"));
        tracks.add(new Playlist(R.drawable.mali,"Make It", "Mali Music", "3:26"));
        tracks.add(new Playlist(R.drawable.mayunga,"Mayunga", "Akon", "4:02"));
        tracks.add(new Playlist(R.drawable.my,"My Shadow", "Jessica J", "3:50"));
        tracks.add(new Playlist(R.drawable.night,"The Night", "Avicii", "2:56"));
        tracks.add(new Playlist(R.drawable.niyola,"Niyola-Go On", "Niyola", "3:54"));
        tracks.add(new Playlist(R.drawable.mali,"No Fun Alone", "Mali Music", "3:24"));
        tracks.add(new Playlist(R.drawable.mali,"One", "Mali Music", "3:40"));
        tracks.add(new Playlist(R.drawable.mali,"Ready Aim", "Mali Music", "3:40"));
        tracks.add(new Playlist(R.drawable.replay,"Replay", "Iyaz", "3:03"));
        tracks.add(new Playlist(R.drawable.mali,"Royalty", "Mali Music", "4:06"));
        tracks.add(new Playlist(R.drawable.should,"Should've Been Us", "Tori Kelly", "3:02"));
        tracks.add(new Playlist(R.drawable.eye,"Straight for the Knife", "Sia", "3:31"));
        tracks.add(new Playlist(R.drawable.travis,"Gave it all", "Travis Greene", "5:10"));
        tracks.add(new Playlist(R.drawable.travis,"Just Want You", "Travis Greene", "6:08"));
        tracks.add(new Playlist(R.drawable.travis,"Soul will Sing", "Travis Greene", "2:32"));
        tracks.add(new Playlist(R.drawable.travis,"Intentional", "Travis Greene", "3:02"));
        tracks.add(new Playlist(R.drawable.eye,"Unstoppable", "Sia", "3:37"));
        tracks.add(new Playlist(R.drawable.night,"Waiting For Love", "Avicii", "3:48"));
        tracks.add(new Playlist(R.drawable.hand,"Weight of the World", "Jon Bellion", "4:30"));
        tracks.add(new Playlist(R.drawable.travis,"World Rise", "Travis Greene", "8:44"));
        tracks.add(new Playlist(R.drawable.yellow,"Yellow Light", "Pharrell Williams", "3:87"));

        //initalize the listView from the xml
        ListView listView = findViewById(R.id.listView);
        //initialize the ArrayAdapter
        PlaylistAdapter itemAdapter = new PlaylistAdapter(this, tracks);
        //implementing the adapter to the list veiw
        listView.setAdapter(itemAdapter);
        //getting the size of the arrayList
        noOfTrack = findViewById(R.id.noOfTracks);
        final int noOfTracks = tracks.size();
        String displayN0 = noOfTracks + " songs";
        noOfTrack.setText(displayN0);

        /*
        * setting the onCLick listener to the listView
        * to get the value of the position clicked
        * and pass it to the NowPlaying activity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nowPlaying = new Intent(MainActivity.this, NowPlaying.class);
                nowPlaying.putExtra("playlist", tracks.get(position));
                startActivity(nowPlaying);
            }
        });
    }
}
