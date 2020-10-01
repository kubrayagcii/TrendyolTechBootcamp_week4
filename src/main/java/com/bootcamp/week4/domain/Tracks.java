package com.bootcamp.week4.domain;

import java.util.UUID;

public class Tracks {
    private String name;
    private String length;
    private String artist;

    public Tracks() {
    }

    public Tracks(String name, String length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
