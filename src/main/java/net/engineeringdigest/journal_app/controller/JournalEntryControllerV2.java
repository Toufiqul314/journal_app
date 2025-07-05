package net.engineeringdigest.journal_app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journal_app.entity.JournalEntry;
import net.engineeringdigest.journal_app.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {

        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {

        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId) {

        return null;
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long myId) {
        return null;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return null;
    }
}
