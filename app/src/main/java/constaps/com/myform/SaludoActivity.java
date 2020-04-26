package constaps.com.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SaludoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("edtNombre");

        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();

    }
}
