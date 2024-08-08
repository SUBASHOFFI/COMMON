package com.gift.website.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gift.website.Modal.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
