package com.bootcamp.week4.service;

import com.bootcamp.week4.domain.Playlist;
import com.bootcamp.week4.domain.Tracks;
import com.bootcamp.week4.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void createPlaylist(Playlist playlist) {
        playlistRepository.createPlaylist(playlist);
    }

    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    public Playlist findById(String id) {
        return playlistRepository.findById(id);
    }

    public List<Playlist> findAllByUserId(int userId) {
        return playlistRepository.findAllByUserId(userId);
    }

    public void deletePlaylist(String id) {
        playlistRepository.deletePlaylist(id);
    }

    public void updatePlaylist(Playlist playlist) {
        playlistRepository.update(playlist);
    }


}
