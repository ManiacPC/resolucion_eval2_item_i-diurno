package cl.inacap.evaluacionii_item_i;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import cl.inacap.evaluacionii_item_i.models.Tarea;

public class MainActivity extends AppCompatActivity {
    private ListView lstTareas;
    private Tarea t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lstTareas = (ListView) findViewById(R.id.lstTareas);
        this.t = new Tarea(getBaseContext());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmación");
        builder.setMessage("¿Desea borrar el elemento?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Se supone que se eliminó", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog dialog = builder.create();

        ArrayAdapter<Tarea> adapter = new ArrayAdapter<Tarea>(
                this, // Contexto - getBaseContext(), getApplicationContext();
                android.R.layout.simple_list_item_1,
                t.obtenerTareas()
        );

        this.lstTareas.setAdapter(adapter);

        this.lstTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Tarea tareaSeleccionada = new Tarea(getBaseContext()).obtenerTareas().get(position);
                Tarea tareaSeleccionada = t.obtenerTareas().get(position);
                Intent intento = new Intent(MainActivity.this, EditTareaActivity.class);
                intento.putExtra("tareaEditar", tareaSeleccionada);
                startActivity(intento);
            }
        });

        // TYPO !!!
        this.lstTareas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.show();
                return true;
            }
        });

    }
}
