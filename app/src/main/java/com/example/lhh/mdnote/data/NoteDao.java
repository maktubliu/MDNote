package com.example.lhh.mdnote.data;

import com.example.lhh.mdnote.Note;

import java.util.List;

/**
 * Created by LHH on 2016/4/25.
 */
public interface NoteDao {
    List<Note> fetchAll();
    void insert(Note note);
    void add(Note note);
    void delete(Note note);

}
