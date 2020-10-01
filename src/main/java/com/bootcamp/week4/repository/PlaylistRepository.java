package com.bootcamp.week4.repository;

import com.bootcamp.week4.domain.Playlist;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PlaylistRepository {

    List<Playlist> playlistList = new ArrayList<Playlist>();

    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public void createPlaylist(Playlist playlist) {
        playlistCollection.insert(playlist.getId(), playlist);
    }

    public void deletePlaylist(String id) {
        playlistCollection.remove(id);
    }

    public List<Playlist> findAll() {
        String statement = "select id, name, description, followersCount, track, trackCount, userId from playlist";
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);
    }

    public Playlist findById(String id) {
        GetResult getResult = playlistCollection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        return playlist;
    }

    public void update(Playlist playlist) {
        playlistCollection.replace(playlist.getId(), playlist);
    }


    public List<Playlist> findAllByUserId(int userId) {

        String statement = String.format("select id, name, description, followersCount, track, trackCount, userId  from playlist where userId = %d", userId);
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);
    }


}
