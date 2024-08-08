package com.gift.website.Controller;


import com.gift.website.Modal.Contact;
import com.gift.website.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contact>> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.getContactById(id);
        return ResponseEntity.ok(contact);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact newContact = contactService.saveOrUpdateContact(contact);
        return ResponseEntity.ok(newContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        return contactService.getContactById(id)
                .map(contact -> {
                    contact.setName(contactDetails.getName());
                    contact.setEmail(contactDetails.getEmail());
                    contact.setPhoneNumber(contactDetails.getPhoneNumber());
                    contact.setMessage(contactDetails.getMessage());
                    Contact updatedContact = contactService.saveOrUpdateContact(contact);
                    return ResponseEntity.ok(updatedContact);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok().build();
    }
}
