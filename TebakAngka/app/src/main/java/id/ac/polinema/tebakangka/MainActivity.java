package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //  TODO: deklarasikan variabel di sini
    private EditText inputNumber;
    private Button buttonGuess;
    private Button buttonReset;

    int min = 1;
    int max = 100;
    int acakAngka = initRandomNumber();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: bind layout di sini
        inputNumber = findViewById(R.id.number_input);
        buttonGuess = findViewById(R.id.guess_button);
        buttonReset = findViewById(R.id.reset_button);
        //false tombol tidak aktif
        buttonReset.setEnabled(false);
    }

    private int initRandomNumber() {
        // TODO: generate angka random di sini
        int random = (int) (Math.random() * ((max - min) + 1)) + min;
        return random;
    }

    public void handleGuess(View view) {
        // TODO: Tambahkan logika untuk melakukan pengecekan angka
        if (inputNumber.getText().toString().equals("")) {
            Toast.makeText(this, "isi angka yang akan ditebak", Toast.LENGTH_SHORT).show();
        } else {
            int cekAngka = Integer.parseInt(inputNumber.getText().toString());

            if (cekAngka > max) {
                Toast.makeText(this, "Tebakan anda lebih dari maximal", Toast.LENGTH_SHORT).show();
            } else if (cekAngka < min) {
                Toast.makeText(this, "Tebakan anda kurang dari minimal", Toast.LENGTH_SHORT).show();
            } else if (cekAngka > acakAngka) {
                Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
            } else if (cekAngka < acakAngka) {
                Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
                buttonGuess.setEnabled(false);
                buttonReset.setEnabled(true);
            }

        }

    }

    public void handleReset(View view) {
        // TODO: Reset tampilan
        inputNumber.setText("");
        buttonReset.setEnabled(false);
        buttonGuess.setEnabled(true);
        acakAngka = initRandomNumber();
    }
}
