package ba.edu.ibu.springtok.right.controllers;

import ba.edu.ibu.springtok.right.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// This class is dependent on the VideoRepository
@RestController // Spring will manage this for us, IOC concept
public class VideoController {

    /*
    * 1. Constructor injection (recommended approach)
    * 2. Setter injection (1st drawback is that the property cannot be final)
    * 3. Field injection
    *   - private attribute that can be manipulated
    *   - it cannot be final, so it means it can happen that it is null and it is mutable
    *   - it is hard to test, you have to use refleciton
    *
    *   - FIELD INJECTION IS GOOD FOR TESTING @MockBean annotation
    * */
    @Autowired
    private VideoRepository videoRepository;

    @Autowired // You have to use @Autowired annotation
    public void setVideoRepository(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public VideoController(VideoRepository videoRepository) {
        // We do not want this as now we are managing the class on our own
        //this.videoRepository = new VideoRepository(); // What if VideoRepository also has the dependency, we would have to manage that as well

        this.videoRepository = videoRepository; // Construction injection, implicite @Autowire that became redundant
    }
}
