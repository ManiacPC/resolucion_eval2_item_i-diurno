package cl.inacap.evaluacionii_item_i.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;

import cl.inacap.evaluacionii_item_i.helpers.DatabaseHelper;

public class Tarea implements Serializable {
    private int codTarea;
    private String titulo;
    private String descripcion;
    private int prioridad;
    private String fecha;

    private DatabaseHelper helper;

    public Tarea() { }

    public Tarea(Context context) {
        this.helper = new DatabaseHelper(context);
    }

    public Tarea(int codTarea, String titulo, String descripcion, int prioridad, String fecha) {
        this.codTarea = codTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fecha = fecha;
    }

    public Tarea(Context context, int codTarea, String titulo, String descripcion, int prioridad, String fecha) {
        this.codTarea = codTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fecha = fecha;
        this.helper = new DatabaseHelper(context);
    }

    public boolean insertar(Tarea tarea){
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues c = new ContentValues();

        c.put("TITULO", tarea.getTitulo());
        c.put("DESCRIPCION", tarea.getDescripcion());
        c.put("PRIORIDAD", tarea.getPrioridad());
        c.put("FECHA", tarea.getFecha());
        try {
            db.insert("tarea",null, c);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    public boolean insertar(){
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues c = new ContentValues();

        c.put("TITULO", this.titulo);
        c.put("DESCRIPCION", this.descripcion);
        c.put("PRIORIDAD", this.prioridad);
        c.put("FECHA", this.fecha);
        try {
            db.insert("tarea",null, c);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    public boolean actualizar(Tarea tareaEditar) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("TITULO", tareaEditar.getTitulo());
        c.put("DESCRIPCION", tareaEditar.getDescripcion());
        c.put("PRIORIDAD", String.valueOf(tareaEditar.getPrioridad()));
        c.put("FECHA", tareaEditar.getFecha());
        int filasAfectadas;
        try {
            filasAfectadas = db.update("tarea",c,"codtarea = ?", new String[]{ String.valueOf(tareaEditar.getCodTarea()) });
            return (filasAfectadas == 1 ? true : false);
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    public boolean actualizar() {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("TITULO", this.titulo);
        c.put("DESCRIPCION", this.descripcion);
        c.put("PRIORIDAD", String.valueOf(this.prioridad));
        c.put("FECHA", this.fecha);
        int filasAfectadas;
        try {
            filasAfectadas = db.update("tarea",c,"codtarea = ?", new String[]{ String.valueOf(this.codTarea) });
            return (filasAfectadas == 1 ? true : false);
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    public ArrayList<Tarea> obtenerTareas() {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        ArrayList<Tarea> tareas = new ArrayList<Tarea>();

        // Cursor consulta = db.rawQuery("SELECT * FROM tarea WHERE codTarea = ?", new String[]{ String.valueOf(1) });
        Cursor consulta = db.rawQuery("SELECT * FROM tarea", null);
        if(consulta.moveToFirst()){
            do {
                int codTarea = consulta.getInt(0);
                String titulo = consulta.getString(1);
                String descripcion = consulta.getString(2);
                int prioridad = consulta.getInt(3);
                String fecha = consulta.getString(4);
                tareas.add(new Tarea(codTarea,titulo,descripcion, prioridad,fecha));
            } while(consulta.moveToNext());
            return tareas;
        } else {
            return null;
        }
    }


    public int getCodTarea() {
        return codTarea;
    }

    public void setCodTarea(int codTarea) {
        this.codTarea = codTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString(){
        return this.codTarea + ": " + this.titulo + "(" + this.descripcion + ") - " + this.fecha;
    }
}
