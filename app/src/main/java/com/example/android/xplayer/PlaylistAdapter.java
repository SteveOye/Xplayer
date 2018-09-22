package com.example.android.xplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    public PlaylistAdapter(Activity context, ArrayList<Playlist> tracks) {

        super(context, 0, tracks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listview_playlist, parent, false);
        }

        Playlist currentPlaylist = getItem(position);

        ImageView art = listItemView.findViewById(R.id.albumArt);
        art.setImageResource(currentPlaylist.getTrackArt());

        TextView title = listItemView.findViewById(R.id.albumTitle);
        title.setText(currentPlaylist.getTrackTitle());

        TextView artist = listItemView.findViewById(R.id.artistName);
        artist.setText(currentPlaylist.getArtistName());

        TextView duration = listItemView.findViewById(R.id.trackDuration);
        duration.setText(currentPlaylist.getTrackDuration());

        return listItemView;
    }
}
