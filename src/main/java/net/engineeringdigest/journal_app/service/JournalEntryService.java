package net.engineeringdigest.journal_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journal_app.entity.JournalEntry;
import net.engineeringdigest.journal_app.entity.User;
import net.engineeringdigest.journal_app.repository.JournalEntryReposiotory;

@Component
@Slf4j
public class JournalEntryService {

    // Repository for Journal Entries
    @Autowired
    private JournalEntryReposiotory journalEntryReposiotory;

    @Autowired
    private UserService userService;

    // save entry
    @Transactional
    public void saveEntry(JournalEntry entry, String username) {

        try {
            User user = userService.findByUsername(username);
            entry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryReposiotory.save(entry);
            user.getJournalEntries().add(saved);
            user.setUsername(null);
            userService.saveEntry(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the journal entry.", e);
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
    public void deleteById(ObjectId id, String username) {
        User user = userService.findByUsername(username);
        user.getJournalEntries().removeIf(entry -> entry.getId().equals(id));
        userService.saveEntry(user);
        journalEntryReposiotory.deleteById(id);
    }
}

// controller ---> service ---> repository