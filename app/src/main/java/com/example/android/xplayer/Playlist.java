package com.example.android.xplayer;

import android.os.Parcel;
import android.os.Parcelable;

public class Playlist implements Parcelable {

    //declaring the variables
    private int mTrackArt;

    private String mTrackTitle;

    private String mArtistName;

    private String mTrackDuration;

    //constructor that take the track title, duration and artistname for each song.
    public Playlist(int trackArt, String trackTitle, String artistName, String trackDuration){
        mTrackArt = trackArt;
        mTrackTitle = trackTitle;
        mArtistName = artistName;
        mTrackDuration = trackDuration;
    }

    protected Playlist(Parcel in) {
        mTrackArt = in.readInt();
        mTrackTitle = in.readString();
        mArtistName = in.readString();
        mTrackDuration = in.readString();
    }

    public static final Creator<Playlist> CREATOR = new Creator<Playlist>() {
        @Override
        public Playlist createFromParcel(Parcel in) {
            return new Playlist(in);
        }

        @Override
        public Playlist[] newArray(int size) {
            return new Playlist[size];
        }
    };
    //get trackArt
    public int getTrackArt(){
        return mTrackArt;
    }
    //get trackTitle
    public String getTrackTitle(){
        return  mTrackTitle;
    }
    //get artistName
    public String getArtistName(){
        return  mArtistName;
    }
    //get trackDuration
    public String getTrackDuration(){
        return mTrackDuration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTrackArt);
        dest.writeString(mTrackTitle);
        dest.writeString(mArtistName);
        dest.writeString(mTrackDuration);
    }
}
