package avdeev.geekbrains;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorStorege storage = new CalculatorStorege();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_layout);
        initView();
    }

    private void initView() {

        ((Button)findViewById(R.id.button1)).setOnClickListener(v -> {
            storage.addMember("1");
            setResultText("1");

        });

        ((Button)findViewById(R.id.button2)).setOnClickListener(v -> {
            storage.addMember("2");
            setResultText("2");
        });

        ((Button)findViewById(R.id.button3)).setOnClickListener(v -> {
            storage.addMember("3");
            setResultText("3");
        });

        ((Button)findViewById(R.id.button3)).setOnClickListener(v -> {
            storage.addMember("3");
            setResultText("3");
        });

        ((Button)findViewById(R.id.button4)).setOnClickListener(v -> {
            storage.addMember("4");
            setResultText("4");
        });

        ((Button)findViewById(R.id.button5)).setOnClickListener(v -> {
            storage.addMember("5");
            setResultText("5");
        });

        ((Button)findViewById(R.id.button6)).setOnClickListener(v -> {
            storage.addMember("6");
            setResultText("6");
        });

        ((Button)findViewById(R.id.button7)).setOnClickListener(v -> {
            storage.addMember("7");
            setResultText("7");
        });

        ((Button)findViewById(R.id.button8)).setOnClickListener(v -> {
            storage.addMember("8");
            setResultText("8");
        });

        ((Button)findViewById(R.id.button9)).setOnClickListener(v -> {
            storage.addMember("9");
            setResultText("9");
        });

        ((Button)findViewById(R.id.button0)).setOnClickListener(v -> {
            storage.addMember("0");
            setResultText("0");
        });

        ((Button)findViewById(R.id.buttonPlus)).setOnClickListener(v -> {
            storage.addMember("+");
            setResultText("+");
        });

        ((Button)findViewById(R.id.buttonMinus)).setOnClickListener(v -> {
            storage.addMember("-");
            setResultText("-");
        });

        ((Button)findViewById(R.id.buttonMult)).setOnClickListener(v -> {
            storage.addMember("*");
            setResultText("*");
        });

        ((Button)findViewById(R.id.buttonDev)).setOnClickListener(v -> {
            storage.addMember("/");
            setResultText("/");
        });

        ((Button)findViewById(R.id.buttonEquals)).setOnClickListener(v -> {
            storage.addMember("=");
            setResultText("=");
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("Storage", storage);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        storage = savedInstanceState.getParcelable("Storage");
        setResultText(storage.getResultText());
    }

    private void setResultText(String text) {
        String currText = (String) ((TextView)findViewById(R.id.resultText)).getText();
        ((TextView)findViewById(R.id.resultText)).setText(currText + text);
    }
}