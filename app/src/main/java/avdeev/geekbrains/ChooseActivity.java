package avdeev.geekbrains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    private RadioButton ligthBtn;
    private RadioButton darkBtn;
    public static final String THEM = "THEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);


        ligthBtn = findViewById(R.id.radio_button_1);
        darkBtn  = findViewById(R.id.radio_button_2);

        findViewById(R.id.choice_button).setOnClickListener(v -> {
            Intent i = new Intent(ChooseActivity.this, MainActivity.class);
            i.putExtra(THEM, darkBtn.isChecked());
            startActivity(i);
        });
    }
}