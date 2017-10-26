package cl.inacap.evaluacionii_item_i.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbeval2.db";
    public static final int DATABASE_VERSION = 3;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tarea(codTarea INTEGER PRIMARY KEY, titulo TEXT NOT NULL, descripcion TEXT NOT NULL);");
        db.execSQL("INSERT INTO tarea (titulo, descripcion) VALUES ('Tarea 1', 'Realizar algo hoy');");
        db.execSQL("INSERT INTO tarea (titulo, descripcion) VALUES ('Tarea 2', 'Realizar algo hoy');");
        db.execSQL("INSERT INTO tarea (titulo, descripcion) VALUES ('Tarea 3', 'Realizar algo hoy');");
        db.execSQL("INSERT INTO tarea (titulo, descripcion) VALUES ('Tarea 4', 'Realizar algo hoy');");
        db.execSQL("INSERT INTO tarea (titulo, descripcion) VALUES ('Tarea 5', 'Realizar algo hoy');");
        db.execSQL("INSERT INTO tarea (titulo, descripcion) VALUES ('Tarea 6', 'Realizar algo hoy');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 2) {
            db.execSQL("DROP TABLE tarea;");
            db.execSQL("CREATE TABLE tarea(codTarea INTEGER PRIMARY KEY, titulo TEXT NOT NULL, descripcion TEXT NOT NULL, prioridad INTEGER);");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad) VALUES ('Tarea 1', 'Realizar algo hoy', '1');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad) VALUES ('Tarea 2', 'Realizar algo hoy', '3');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad) VALUES ('Tarea 3', 'Realizar algo hoy', '2');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad) VALUES ('Tarea 4', 'Realizar algo hoy', '1');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad) VALUES ('Tarea 5', 'Realizar algo hoy', '1');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad) VALUES ('Tarea 6', 'Realizar algo hoy', '2');");
        }
        if (newVersion == 3) {
            db.execSQL("DROP TABLE tarea;");
            db.execSQL("CREATE TABLE tarea(codTarea INTEGER PRIMARY KEY, titulo TEXT NOT NULL, descripcion TEXT NOT NULL, prioridad INTEGER, fecha TEXT);");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad, fecha) VALUES ('Tarea 1', 'Realizar algo hoy', '1', '12-10-17');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad, fecha) VALUES ('Tarea 2', 'Realizar algo hoy', '3', '13-10-17');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad, fecha) VALUES ('Tarea 3', 'Realizar algo hoy', '2', '14-10-17');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad, fecha) VALUES ('Tarea 4', 'Realizar algo hoy', '1', '15-10-17');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad, fecha) VALUES ('Tarea 5', 'Realizar algo hoy', '1', '16-10-17');");
            db.execSQL("INSERT INTO tarea (titulo, descripcion, prioridad, fecha) VALUES ('Tarea 6', 'Realizar algo hoy', '2', '17-10-17');");
        }
    }
}
