package com.gift.website.Repository;




import com.gift.website.Modal.SearchModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepo extends JpaRepository<SearchModel, Long> {
    List<SearchModel> findByTitleContainingIgnoreCase(String title);
    List<SearchModel> findByCompanyContainingIgnoreCase(String company);
    List<SearchModel> findByLocationContainingIgnoreCase(String location);
    List<SearchModel> findByCategoryContainingIgnoreCase(String category);
}
