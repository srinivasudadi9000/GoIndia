package app.goindia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBHelper {
    static SQLiteDatabase db;
    static Context context;

    public DBHelper(Context context) {
        db = context.openOrCreateDatabase("COURSE", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS messages(title VARCHAR,status VARCHAR,type VARCHAR,cdt VARCHAR);");
    }

    public void insertProject(String title, String status, String type, String cdt, Context context) {
        this.context = context;
        db = context.openOrCreateDatabase("COURSE", Context.MODE_PRIVATE, null);
        db.execSQL("INSERT INTO messages VALUES('" + title + "','" + status + "','" + type + "','" + cdt + "');");
        db.close();
        Log.d("dbcreated_insert", "insertedsucess");
    }

}
