package net.engineeringdigest.journal_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journal_app.entity.JournalEntry;
import net.engineeringdigest.journal_app.repository.JournalEntryReposiotory;

@Component
public class JournalEntryService {

    // Repository for Journal Entries
    @Autowired
    private JournalEntryReposiotory journalEntryReposiotory;

    // save entry
    public void saveEntry(JournalEntry entry) {
        journalEntryReposiotory.save(entry);
    }

    // get all
    public List<JournalEntry> getAll() {
        return journalEntryReposiotory.findAll();
    }
}

// controller ---> service ---> repository