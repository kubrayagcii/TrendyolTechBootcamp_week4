package com.bootcamp.week4.domain;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Playlist {
    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Tracks> tracks;
    private int trackCount;
    private int userId;

    public Playlist() {
        this.id = UUID.randomUUID().toString();
        this.name = "name";
        this.description = "description";
        this.followersCount = 0;
        this.tracks = Collections.emptyList();
        this.trackCount = 0;
        this.userId = 0;
    }

    public Playlist(String name, String description, int followersCount, List<Tracks> tracks, int trackCount, int userId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.followersCount = followersCount;
        this.tracks = tracks;
        this.trackCount = trackCount;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public List<Tracks> getTracks() {
        return tracks;
    }

    public void setTracks(List<Tracks> tracks) {
        this.tracks = tracks;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount() {
        this.trackCount = this.tracks.size();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void addTrack(List<Tracks> tracks) {
        for (int i = 0; i < tracks.size(); i++) {
            Tracks track = tracks.get(i);
            this.getTracks().add(track);
        }
        this.setTrackCount();
    }

    public void deleteTrack(Tracks track) {
        for (int i = 0; i < this.getTracks().size(); i++) {
            if (this.getTracks().get(i).getName().equals(track.getName()))
                this.getTracks().remove(i);
        }
        this.setTrackCount();
    }
}
