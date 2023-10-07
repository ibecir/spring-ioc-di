package ba.edu.ibu.springtok.wrong.controller;

import ba.edu.ibu.springtok.wrong.repository.VideoRepository;

public class VideoController {
    private final VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public String next() {
        return "Next video";
    }
}
