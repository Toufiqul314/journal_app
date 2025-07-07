package net.engineeringdigest.journal_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journal_app.entity.JournalEntry;
import net.engineeringdigest.journal_app.repository.JournalEntryReposiotory;

@Component
@Slf4j
public class JournalEntryService {

    // Repository for Journal Entries
    @Autowired
    private JournalEntryReposiotory journalEntryReposiotory;

    // save entry
    public void saveEntry(JournalEntry entry) {
        try {
            entry.setDate(LocalDateTime.now());
            journalEntryReposiotory.save(entry);
        } catch (Exception e) {
            log.error("Exception", e);
        }
    }

    // get all
    public List<JournalEntry> getAll() {
        return journalEntryReposiotory.findAll();
    }

    // find by id
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryReposiotory.findById(id);
    }

    // delete by id
    public void deleteById(ObjectId id) {
        journalEntryReposiotory.deleteById(id);
    }
}

// controller ---> service ---> repository