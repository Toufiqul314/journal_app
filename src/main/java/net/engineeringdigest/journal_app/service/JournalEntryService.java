package net.engineeringdigest.journal_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journal_app.entity.JournalEntry;
import net.engineeringdigest.journal_app.repository.JournalEntryReposiotory;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryReposiotory journalEntryReposiotory;

    public void saveEntry(JournalEntry entry) {
        journalEntryReposiotory.save(entry);
    }
}

// controller ---> service ---> repository