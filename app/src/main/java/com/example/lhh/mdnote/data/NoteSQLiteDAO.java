package com.example.lhh.mdnote.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.lhh.mdnote.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LHH on 2016/4/25.
 */
public class NoteSQLiteDAO implements NoteDao {
    private static final String TAG = NoteSQLiteDAO.class.getSimpleName();
    private static final String WHERE_ID_CLAUSE = NoteEntry._ID + " = ? ";
    private SQLiteOpenHelper databaseHelper;
    private NoteSQLiteDAO(SQLiteOpenHelper databaseHelper){
        this.databaseHelper = databaseHelper;
    }
    @Override
    public List<Note> fetchAll(){
        ArrayList<Note> result = null;
        Cursor cursor = null;
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        try{
            String[] columns = {NoteEntry.TABLE_NAME,
                    NoteEntry.TITLE,
                    NoteEntry.CONTENT,
                    NoteEntry.CREATE_AT,
                    NoteEntry.UPDATE_AT};
            cursor = database.query(NoteEntry.TABLE_NAME, columns, null, null, null, null, null);
            result = new ArrayList<>(cursor.getCount());
            for(cursor.moveToNext(); !cursor.moveToLast(); cursor.moveToNext()){
                Note note = new Note();
                note.setId(cursor.getLong(cursor.getColumnIndexOrThrow(NoteEntry._ID)));
                note.setTitle(cursor.getString((cursor.getColumnIndexOrThrow(NoteEntry.TITLE))));
                note.setContent(cursor.getString(cursor.getColumnIndexOrThrow(NoteEntry.CONTENT)));
                note.setCreateAt(new Date(cursor.getLong(cursor.getColumnIndexOrThrow(NoteEntry.CREATE_AT))));
                note.setUpdateAt(new Date(cursor.getLong(cursor.getColumnIndexOrThrow(NoteEntry.UPDATE_AT))));
                result.add(note);
            }
        }catch (Exception e){
            Log.e(TAG, "can not fetch all" + e);
        }finally {
            if(cursor != null){
                try{
                    cursor.close();
                }catch (Exception e){
                    Log.e(TAG, "can not close cursor");
                }
            }
            database.close();
        }
        return result;
    }
    @Override
    public void insert(Note note){
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        database.beginTransaction();
        try{
            ContentValues values = new ContentValues();
            values.put(NoteEntry.TITLE, note.getTitle());
            values.put(NoteEntry.CONTENT, note.getContent());
            values.put(NoteEntry.CREATE_AT, note.getCreateAt().getTime());
            values.put(NoteEntry.UPDATE_AT, note.getUpdateAt().getTime());
            Long rowId = database.insert(NoteEntry.TABLE_NAME, null, values);
        }catch (Exception e){

        }
    }
    @Override
    public void add(Note note){

    }
    @Override
    public void delete(Note note){

    }
    private static class NoteEntry implements BaseColumns{
        private static final String TABLE_NAME = "note";
        private static final String TITLE = "title";
        private static final String CONTENT = "content";
        private static final String CREATE_AT = "create_at";
        private static final String UPDATE_AT = "update_at";
    }
}
