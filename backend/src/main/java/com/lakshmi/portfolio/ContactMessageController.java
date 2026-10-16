
package com.lakshmi.portfolio;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {
        "http://localhost:5500",
        "http://127.0.0.1:5500"
})
public class ContactMessageController {

    private final ContactMessageRepository repository;

    public ContactMessageController(ContactMessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> submitContact(
            @Valid @RequestBody ContactMessage contactMessage) {

        repository.save(contactMessage);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message",
                        "Your message has been submitted successfully."));
    }
}
