package constaps.com.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CompartirMensageActivity extends AppCompatActivity {
    private ImageView imgvEnviar;
    private Button compartir;
    public String nombrePersona;
    public int edadPersona;
    public int opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartir_mensage);
        iniciarElementos();
        validarImg();

    }
    public void iniciarElementos(){
        imgvEnviar = findViewById(R.id.imageViewEnviar);
        compartir = findViewById(R.id.buttonCompartir);
    }
    public void validarImg(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            nombrePersona = bundle.getString("edtPantalla1");
            edadPersona = bundle.getInt("edad");
            opcion = bundle.getInt("rdOpcion");

        }
        imgvEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartir.setVisibility(View.VISIBLE);
                imgvEnviar.setVisibility(View.INVISIBLE);
                if(opcion == 1){
                    Toast.makeText(CompartirMensageActivity.this, "Hola "+nombrePersona+" ,¿Como llevas esos"+edadPersona+" años?#MyForm",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(CompartirMensageActivity.this,"Espero verte pronto "+nombrePersona+" antes que cumplast "+(edadPersona+1)+"..#MyForm",Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}
