package com.navin.journalApp.controller;

import com.navin.journalApp.entity.JournalEntry;
import com.navin.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryContollerV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAllEntry();
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
        return journalEntryService.getEntryById(myId).orElse(null);
    }


    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry;
    }


    @DeleteMapping("/id/{myId}")
    public boolean deleteEntry(@PathVariable ObjectId myId) {
        journalEntryService.deleteEntryById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry entry) {
        JournalEntry old = journalEntryService.getEntryById(myId).orElse(null);
        if (old != null) {
            old.setContent(entry.getContent() != null && !entry.getContent().equals("") ? entry.getContent() : old.getContent());
            old.setTitle(entry.getTitle() != null && !entry.getTitle().equals("") ? entry.getTitle() : old.getTitle());
        }
        journalEntryService.saveEntry(old);
        return old;
    }

}
