package ua.com.todd.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import ua.com.todd.sqlite.data.DatabaseHelper;
import ua.com.todd.sqlite.data.DatabaseManager;
import ua.com.todd.sqlite.data.QueryExecutor;
import ua.com.todd.sqlite.data.dao.UserDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseManager.initializeInstance(new DatabaseHelper(this));

        DatabaseManager.getInstance().executeQuery(new QueryExecutor() {
            @Override
            public void run(SQLiteDatabase database) {
                new UserDAO(database, MainActivity.this).insertUser(new User("Timmy")); // your class
            }
        });

        DatabaseManager.getInstance().executeQuery(new QueryExecutor() {
            @Override
            public void run(SQLiteDatabase database) {
                List<String> l  = new UserDAO(database, MainActivity.this).getAllUsers(); // your class
                l.toString();
            }
        });

        // execute query on current thread
        DatabaseManager.getInstance().executeQuery(new QueryExecutor() {
            @Override
            public void run(SQLiteDatabase database) {
                new UserDAO(database, MainActivity.this).deleteAll(); // your class
            }
        });

        // execute query on separate current thread
        DatabaseManager.getInstance().executeQueryTask(new QueryExecutor() {
            @Override
            public void run(SQLiteDatabase database) {
                new UserDAO(database, MainActivity.this).deleteAll(); // your class
            }
        });

    }
}
