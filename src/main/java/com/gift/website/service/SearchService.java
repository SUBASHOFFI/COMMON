package com.gift.website.service;




import com.gift.website.Modal.SearchModel;
import com.gift.website.Repository.SearchRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepo jobRepository;

    public List<SearchModel> getAllJobs() {
        return jobRepository.findAll();
    }

    public SearchModel getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public SearchModel saveJob(SearchModel job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<SearchModel> searchJobs(String keyword) {
        return jobRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
