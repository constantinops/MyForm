package constaps.com.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNombrePersona;
    Button btSiguientePantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarElementos();
        btSiguientePantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarTexto();
            }
        });

    }
    public void iniciarElementos(){
        edtNombrePersona = findViewById(R.id.editTextNombre);
        btSiguientePantalla = findViewById(R.id.buttonSiguiente);
    }
    public  void validarTexto(){
        String nombre = edtNombrePersona.getText().toString();

        if(nombre.isEmpty()) {
            Toast.makeText(this, "Ingresa tu nombre", Toast.LENGTH_SHORT).show();
        }else if(nombre.length() <= 4){
         Toast.makeText(this,"Ingresa un nombre mayor a 4 caracteres",Toast.LENGTH_LONG).show();
        } else{
            Intent intent = new Intent(MainActivity.this,SaludoActivity.class);
            intent.putExtra("edtNombre",nombre);
            startActivity(intent);
            edtNombrePersona.setText("");
        }

    }

}
