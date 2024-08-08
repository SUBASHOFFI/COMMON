package com.gift.website.service;



import com.gift.website.Modal.Vacancy;
import com.gift.website.Repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    public Optional<Vacancy> getVacancyById(Long id) {
        return vacancyRepository.findById(id);
    }

    public Vacancy addOrUpdateVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        vacancyRepository.deleteById(id);
    }

    public List<Vacancy> searchVacanciesByLocation(String location) {
        return vacancyRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Vacancy> searchVacanciesByTitle(String title) {
        return vacancyRepository.findByTitleContainingIgnoreCase(title);
    }
}
