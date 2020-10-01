package com.bootcamp.week4.controller;

import com.bootcamp.week4.domain.Playlist;
import com.bootcamp.week4.domain.Tracks;

import com.bootcamp.week4.service.PlaylistService;
import com.couchbase.client.core.error.DocumentExistsException;
import com.couchbase.client.core.error.DocumentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/playlists")
@RestController

public class PlaylistController {


    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody Playlist playlist) {
        try {
            playlistService.createPlaylist(playlist);
            playlist.setTrackCount();
            return ResponseEntity.ok().build();
        } catch (DocumentExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> findAll() {
        try {
            return ResponseEntity.ok(playlistService.findAll());
        } catch (DocumentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(playlistService.findById(id));
        } catch (DocumentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{userId}/userId")
    public ResponseEntity<List<Playlist>> findAllByUserId(@PathVariable int userId) {
        try {
            return ResponseEntity.ok(playlistService.findAllByUserId(userId));
        } catch (DocumentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(String id) {
        playlistService.deletePlaylist(id);
    }

    @PostMapping("/{id}/addTrack")
    public ResponseEntity<Playlist> addTrack(@PathVariable String id, @RequestBody List<Tracks> tracks) {
        Playlist playlist = playlistService.findById(id);
        playlist.addTrack(tracks);
        playlistService.updatePlaylist(playlist);
        return ResponseEntity.ok(playlist);
    }

    @PostMapping("{id}/deleteTrack")
    public ResponseEntity<Playlist> deleteTrack(@PathVariable String id, @RequestBody Tracks track) {
        Playlist playlist = playlistService.findById(id);
        playlist.deleteTrack(track);
        playlistService.updatePlaylist(playlist);
        return ResponseEntity.ok(playlist);
    }

}
