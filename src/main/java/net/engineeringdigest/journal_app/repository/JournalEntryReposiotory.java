package net.engineeringdigest.journal_app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.engineeringdigest.journal_app.entity.JournalEntry;

public interface JournalEntryReposiotory extends MongoRepository<JournalEntry, Long> {
    
    // This interface will automatically provide CRUD operations for JournalEntry
    // No need to implement methods, Spring Data MongoDB will handle it

}
