package com.noteapplication.cs398;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDataAccess_Impl implements NoteDataAccess {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Note> __insertionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Note> __deletionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Note> __updateAdapterOfNote;

  public NoteDataAccess_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNote = new EntityInsertionAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Table` (`title`,`content`,`time`,`Todo`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        if (value.getNoteTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNoteTitle());
        }
        if (value.getNoteContent() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNoteContent());
        }
        if (value.getNoteTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNoteTime());
        }
        final int _tmp = value.getNoteTag() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getId());
      }
    };
    this.__deletionAdapterOfNote = new EntityDeletionOrUpdateAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfNote = new EntityDeletionOrUpdateAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Table` SET `title` = ?,`content` = ?,`time` = ?,`Todo` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        if (value.getNoteTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNoteTitle());
        }
        if (value.getNoteContent() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNoteContent());
        }
        if (value.getNoteTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNoteTime());
        }
        final int _tmp = value.getNoteTag() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getId());
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public Object insert(final Note note, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNote.insert(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Note note, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNote.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Note note, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNote.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Note>> getNotes() {
    final String _sql = "Select * from `Table` order by id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Table"}, false, new Callable<List<Note>>() {
      @Override
      public List<Note> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNoteTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfNoteContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfNoteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfNoteTag = CursorUtil.getColumnIndexOrThrow(_cursor, "Todo");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Note> _result = new ArrayList<Note>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Note _item;
            final String _tmpNoteTitle;
            if (_cursor.isNull(_cursorIndexOfNoteTitle)) {
              _tmpNoteTitle = null;
            } else {
              _tmpNoteTitle = _cursor.getString(_cursorIndexOfNoteTitle);
            }
            final String _tmpNoteContent;
            if (_cursor.isNull(_cursorIndexOfNoteContent)) {
              _tmpNoteContent = null;
            } else {
              _tmpNoteContent = _cursor.getString(_cursorIndexOfNoteContent);
            }
            final String _tmpNoteTime;
            if (_cursor.isNull(_cursorIndexOfNoteTime)) {
              _tmpNoteTime = null;
            } else {
              _tmpNoteTime = _cursor.getString(_cursorIndexOfNoteTime);
            }
            final boolean _tmpNoteTag;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfNoteTag);
            _tmpNoteTag = _tmp != 0;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new Note(_tmpNoteTitle,_tmpNoteContent,_tmpNoteTime,_tmpNoteTag,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Note>> getNoteById(final int id) {
    final String _sql = "Select * from `Table` where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Table"}, false, new Callable<List<Note>>() {
      @Override
      public List<Note> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNoteTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfNoteContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfNoteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfNoteTag = CursorUtil.getColumnIndexOrThrow(_cursor, "Todo");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Note> _result = new ArrayList<Note>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Note _item;
            final String _tmpNoteTitle;
            if (_cursor.isNull(_cursorIndexOfNoteTitle)) {
              _tmpNoteTitle = null;
            } else {
              _tmpNoteTitle = _cursor.getString(_cursorIndexOfNoteTitle);
            }
            final String _tmpNoteContent;
            if (_cursor.isNull(_cursorIndexOfNoteContent)) {
              _tmpNoteContent = null;
            } else {
              _tmpNoteContent = _cursor.getString(_cursorIndexOfNoteContent);
            }
            final String _tmpNoteTime;
            if (_cursor.isNull(_cursorIndexOfNoteTime)) {
              _tmpNoteTime = null;
            } else {
              _tmpNoteTime = _cursor.getString(_cursorIndexOfNoteTime);
            }
            final boolean _tmpNoteTag;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfNoteTag);
            _tmpNoteTag = _tmp != 0;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new Note(_tmpNoteTitle,_tmpNoteContent,_tmpNoteTime,_tmpNoteTag,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
