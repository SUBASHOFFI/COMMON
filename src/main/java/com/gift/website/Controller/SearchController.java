package com.gift.website.Controller;




import com.gift.website.Modal.SearchModel;
import com.gift.website.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class SearchController {

    @Autowired
    private SearchService jobService;

    @GetMapping
    public ResponseEntity<List<SearchModel>> getAllJobs() {
        List<SearchModel> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchModel> getJobById(@PathVariable Long id) {
        SearchModel job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<SearchModel> createJob(@RequestBody SearchModel job) {
        SearchModel createdJob = jobService.saveJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchModel>> searchJobs(@RequestParam String keyword) {
        List<SearchModel> jobs = jobService.searchJobs(keyword);
        return ResponseEntity.ok(jobs);
    }
}
