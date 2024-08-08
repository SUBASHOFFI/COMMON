package com.gift.website.Modal;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SearchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String company;
    private String location;
    private String description;
    private String type;  // e.g., Full-time, Part-time
    private String category;

    public SearchModel(Long id, String title, String company, String location, String description, String type, String category) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.type = type;
        this.category = category;
    }
}
