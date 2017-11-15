package ua.com.todd.sqlite.data;

import android.database.sqlite.SQLiteDatabase;

public interface QueryExecutor {

    public void run(SQLiteDatabase database);
}
