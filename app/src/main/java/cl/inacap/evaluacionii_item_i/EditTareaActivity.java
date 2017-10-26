package cl.inacap.evaluacionii_item_i;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cl.inacap.evaluacionii_item_i.models.Tarea;

public class EditTareaActivity extends AppCompatActivity {
    private TextView lblCodTareaMostrar;
    private EditText editTitulo;
    private EditText editDescripcion;
    private EditText editPrioridad;
    private EditText editFecha;
    private Button btnGuardar;
    private Tarea t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tarea);
        this.t = (Tarea) getIntent().getSerializableExtra("tareaEditar");

        this.lblCodTareaMostrar = (TextView) findViewById(R.id.lblCodTareaMostrar);
        this.editTitulo = (EditText) findViewById(R.id.editTitulo);
        this.editDescripcion = (EditText) findViewById(R.id.editDescripcion);
        this.editPrioridad = (EditText) findViewById(R.id.editPrioridad);
        this.editFecha = (EditText) findViewById(R.id.editFecha);
        this.btnGuardar = (Button) findViewById(R.id.btnGuardar);

        this.lblCodTareaMostrar.setText(String.valueOf(t.getCodTarea()));
        this.editTitulo.setText(t.getTitulo());
        this.editDescripcion.setText(t.getDescripcion());
        this.editPrioridad.setText(String.valueOf(t.getPrioridad()));
        this.editFecha.setText(t.getFecha());

        // TYPO
        this.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int codTarea = t.getCodTarea();
                String titulo = editTitulo.getText().toString();
                String descripcion = editDescripcion.getText().toString();
                int prioridad = Integer.valueOf(editPrioridad.getText().toString());
                String fecha = editFecha.getText().toString();

               // new Tarea(getBaseContext(), codTarea, titulo, descripcion, prioridad, fecha).actualizar();
               Tarea tareaActualizar = new Tarea(getBaseContext(), codTarea, titulo, descripcion, prioridad, fecha);
               if(tareaActualizar.actualizar()) {
                   Toast.makeText(getBaseContext(), "Ha actualizado la tarea " + String.valueOf(tareaActualizar.getCodTarea()), Toast.LENGTH_LONG).show();
               } else {
                   Toast.makeText(getBaseContext(), "No se ha podido actualizar la tarea <('0' )>", Toast.LENGTH_LONG).show();
               }
            }
        });

    }
}
