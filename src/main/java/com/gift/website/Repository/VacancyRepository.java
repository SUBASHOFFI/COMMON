package com.gift.website.Repository;



import com.gift.website.Modal.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByLocationContainingIgnoreCase(String location);
    List<Vacancy> findByTitleContainingIgnoreCase(String title);
}
