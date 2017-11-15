package ua.com.todd.sqlite.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.com.todd.sqlite.User;
import ua.com.todd.sqlite.data.QueryExecutor;

public class UserDAO {

    public static final String COLUMN_NAME = "name";

    private SQLiteDatabase database;
    private Context context;

    public UserDAO(SQLiteDatabase database, Context context) {
        this.database = database;
        this.context = context;
    }

    public boolean insertUser(User user)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", user.getName());

        database.insert("users", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        Cursor res =  database.rawQuery( "select * from users where id="+id+"", null );
        return res;
    }

    public Integer deleteUser(Integer id)
    {
        return database.delete("users",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public void deleteAll()
    {
        database.delete("users", null, null);
    }

    public List<String> getAllUsers()
    {
        ArrayList<String> array_list = new ArrayList();
        Cursor res =  database.rawQuery( "select * from users", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
