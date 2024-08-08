package com.gift.website.Controller;


import com.gift.website.Modal.Vacancy;
import com.gift.website.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<List<Vacancy>> getAllVacancies() {
        List<Vacancy> vacancies = vacancyService.getAllVacancies();
        return ResponseEntity.ok(vacancies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vacancy>> getVacancyById(@PathVariable Long id) {
        Optional<Vacancy> vacancy = vacancyService.getVacancyById(id);
        return ResponseEntity.ok(vacancy);
    }

    @PostMapping
    public ResponseEntity<Vacancy> addVacancy(@RequestBody Vacancy vacancy) {
        Vacancy newVacancy = vacancyService.addOrUpdateVacancy(vacancy);
        return ResponseEntity.ok(newVacancy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacancy> updateVacancy(@PathVariable Long id, @RequestBody Vacancy vacancyDetails) {
        return vacancyService.getVacancyById(id)
                .map(vacancy -> {
                    vacancy.setTitle(vacancyDetails.getTitle());
                    vacancy.setDescription(vacancyDetails.getDescription());
                    vacancy.setLocation(vacancyDetails.getLocation());
                    vacancy.setCompany(vacancyDetails.getCompany());
                    vacancy.setType(vacancyDetails.getType());
                    vacancy.setSalary(vacancyDetails.getSalary());
                    Vacancy updatedVacancy = vacancyService.addOrUpdateVacancy(vacancy);
                    return ResponseEntity.ok(updatedVacancy);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable Long id) {
        vacancyService.deleteVacancy(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/location")
    public ResponseEntity<List<Vacancy>> searchVacanciesByLocation(@RequestParam String location) {
        List<Vacancy> vacancies = vacancyService.searchVacanciesByLocation(location);
        return ResponseEntity.ok(vacancies);
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<Vacancy>> searchVacanciesByTitle(@RequestParam String title) {
        List<Vacancy> vacancies = vacancyService.searchVacanciesByTitle(title);
        return ResponseEntity.ok(vacancies);
    }
}
