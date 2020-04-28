package constaps.com.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SaludoActivity extends AppCompatActivity {
    public String nombre;
    private RadioButton rdbSaludo,rdbDespedida;
    private SeekBar sebEdad;
    private TextView edtMostrarEdad;
    private Button btnSiguiente;
    private int value = 18;
    private final int valorMenor = 16;
    private  final int valorMayor = 60;
    public static  final int radioSaludo = 1;
    public  static  final int radioAdios = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            nombre = bundle.getString("edtNombre");
        }
        iniciarElementos();
        barraProgreso();
        validarBtnSiguiente();

    }
    public void iniciarElementos(){
        rdbSaludo = findViewById(R.id.radioButtonSaludo);
        rdbDespedida = findViewById(R.id.radioButtonDespedida);
        btnSiguiente = findViewById(R.id.buttonSiguiente);
        sebEdad = findViewById(R.id.seekBar2Edad);
        edtMostrarEdad = findViewById(R.id.textViewEdad);
    }
    public void barraProgreso(){
        sebEdad.setProgress(18);
        sebEdad.setMax(100);
        edtMostrarEdad.setText(sebEdad.getProgress()+"Edad");
        sebEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                //   edtMostrarEdad.setText(progress+""+sebEdad.getMax());
                // edtMostrarEdad.setText(String.valueOf(progress));
                value = i;
                edtMostrarEdad.setText(""+value+"Edad");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
               // Toast.makeText(getApplicationContext(),"arrastrar",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                value = sebEdad.getProgress();
                edtMostrarEdad.setText(value+"Edad");
                if(value > valorMayor){
                    btnSiguiente.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Los valores aceptables es  menor a 60",Toast.LENGTH_SHORT).show();

                }else if(value < valorMenor){
                    btnSiguiente.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Los valores aceptables son mayor a 16",Toast.LENGTH_SHORT).show();

                }else{
                    btnSiguiente.setVisibility(View.VISIBLE);
                }

            }
        });



    }

    public void validarBtnSiguiente(){

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaludoActivity.this,CompartirMensageActivity.class);
                intent.putExtra("edtPantalla1",nombre);
                intent.putExtra("edad",value);
                int opcion = (rdbSaludo.isChecked()) ? radioSaludo : radioAdios;
                intent.putExtra("rdOpcion",opcion);
                startActivity(intent);
                Toast.makeText(SaludoActivity.this,sebEdad.getProgress()+"",Toast.LENGTH_SHORT).show();

            }
        });





    }




}
