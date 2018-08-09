package id.co.asyst.yeni.pizzaorderyeni;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.co.asyst.yeni.pizzaorderyeni.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    EditText editText;
    ImageView imageView;
    Button submitButton;
    TextView textView;
    String firstString;

    CheckBox checkDaging;
    RadioGroup radioDaging;
    String selectDaging = "";

    CheckBox checkKeju;
    RadioGroup radioKeju;
    String selectKeju = "";

    CheckBox checkBuah;
    RadioGroup radioBuah;
    String selectBuah = "";
    ArrayList<String> listFood = new ArrayList<String>();
    String foods = "";

    Switch switchUp;
    Button pesanSkrg;

    RadioButton dg1;
    RadioButton dg2;
    RadioButton dg3;
    RadioButton kj1;
    RadioButton kj2;
    RadioButton kj3;
    RadioButton bh1;
    RadioButton bh2;
    RadioButton bh3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AWAL
        editText = findViewById(R.id.edit_text);
        imageView = findViewById(R.id.img_view);
        textView = findViewById(R.id.text_view);
        submitButton = findViewById(R.id.submit_button);
        imageView.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        //DAGING
        checkDaging = findViewById(R.id.check_daging);
        checkDaging.setOnCheckedChangeListener(this);

        radioDaging = findViewById(R.id.radio_daging);
        radioDaging.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.daging_s)).setChecked(true);
        //KEJU
        checkKeju = findViewById(R.id.check_keju);
        checkKeju.setOnCheckedChangeListener(this);

        radioKeju = findViewById(R.id.radio_keju);
        radioKeju.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.keju_s)).setChecked(true);
        //BUAH
        checkBuah = findViewById(R.id.check_buah);
        checkBuah.setOnCheckedChangeListener(this);

        radioBuah = findViewById(R.id.radio_buah);
        radioBuah.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.buah_s)).setChecked(true);
        //switch
        switchUp = findViewById(R.id.switch_up);
        switchUp.setOnCheckedChangeListener(this);
        //button pesan
        pesanSkrg = findViewById(R.id.pesan_skrg);
        pesanSkrg.setOnClickListener(this);

//Disable
        //checbox
        checkBuah.setEnabled(false);
        checkDaging.setEnabled(false);
        checkKeju.setEnabled(false);

        //radio button
        dg1 = findViewById(R.id.daging_s);
        dg2 = findViewById(R.id.daging_m);
        dg3 = findViewById(R.id.daging_l);
        dg1.setOnCheckedChangeListener(this);
        dg2.setOnCheckedChangeListener(this);
        dg3.setOnCheckedChangeListener(this);

        kj1 = findViewById(R.id.keju_s);
        kj2 = findViewById(R.id.keju_m);
        kj3 = findViewById(R.id.keju_l);
        kj1.setOnCheckedChangeListener(this);
        kj2.setOnCheckedChangeListener(this);
        kj3.setOnCheckedChangeListener(this);

        bh1 = findViewById(R.id.buah_s);
        bh2 = findViewById(R.id.buah_m);
        bh3 = findViewById(R.id.buah_l);
        bh1.setOnCheckedChangeListener(this);
        bh2.setOnCheckedChangeListener(this);
        bh3.setOnCheckedChangeListener(this);

        dg1.setEnabled(false);
        dg2.setEnabled(false);
        dg3.setEnabled(false);

        kj1.setEnabled(false);
        kj2.setEnabled(false);
        kj3.setEnabled(false);

        bh1.setEnabled(false);
        bh2.setEnabled(false);
        bh3.setEnabled(false);

        pesanSkrg.setEnabled(false);
        switchUp.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.submit_button:
                firstString = editText.getText().toString();
                if (!TextUtils.isEmpty(firstString)) {
                    checkBuah.setEnabled(true);
                    checkDaging.setEnabled(true);
                    checkKeju.setEnabled(true);

                    dg1.setEnabled(true);
                    dg2.setEnabled(true);
                    dg3.setEnabled(true);

                    kj1.setEnabled(true);
                    kj2.setEnabled(true);
                    kj3.setEnabled(true);

                    bh1.setEnabled(true);
                    bh2.setEnabled(true);
                    bh3.setEnabled(true);
                    pesanSkrg.setEnabled(true);
                    switchUp.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "Welcome " + firstString + "! Lanjutkan Pemesanan :)", Toast.LENGTH_SHORT).show();
                } else {
                    checkBuah.setEnabled(false);
                    checkDaging.setEnabled(false);
                    checkKeju.setEnabled(false);

                    dg1.setEnabled(false);
                    dg2.setEnabled(false);
                    dg3.setEnabled(false);

                    kj1.setEnabled(false);
                    kj2.setEnabled(false);
                    kj3.setEnabled(false);

                    bh1.setEnabled(false);
                    bh2.setEnabled(false);
                    bh3.setEnabled(false);
                    pesanSkrg.setEnabled(false);
                    switchUp.setEnabled(false);
                }
                break;

            case R.id.img_view:

                break;

            case R.id.pesan_skrg:
                firstString = editText.getText().toString();
                if (!TextUtils.isEmpty(firstString)) {

                    foods = " ";
                    for (int i = 0; i < listFood.size(); i++) {
                        foods = foods + " " + listFood.get(i);
                    }
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Confirmation")
                            .setCancelable(false)
                            .setMessage("Are You Sure ?")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                    String result = "Nama Pemesan : " + firstString + "\n Ukuran Pizza: " +
                                            selectDaging + ", " + selectKeju + ", " + selectBuah + "\n Jenis Pizza: " + foods;
                                    intent.putExtra(Constant.KEY_RESULT, result);
                                    startActivity(intent);
                                    finish();

                                }
                            })
                            .setNegativeButton("NO", null).show();
                    break;
                }

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.check_daging:
                if (isChecked) {
                    listFood.add("Pizza Daging, ");
                } else {
                    listFood.remove("Pizza Daging");
                }

                break;
            case R.id.check_keju:
                if (isChecked) {
                    listFood.add("Pizza Keju, ");
//
                } else {
                    listFood.remove("Pizza Keju");
                }
                break;
            case R.id.check_buah:
                if (isChecked) {
                    listFood.add("Pizza Buah, ");
                } else {
                    listFood.remove("Pizza Buah");
                }
                break;
            case R.id.switch_up:
                Log.d("MainAct testSwitch", String.valueOf(isChecked));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.daging_s:
                selectDaging = "S";
                break;
            case R.id.daging_m:
                selectDaging = "M";
                break;
            case R.id.daging_l:
                selectDaging = "L";
                break;
            case R.id.keju_s:
                selectKeju = "S";
                break;
            case R.id.keju_m:
                selectKeju = "M";
                break;
            case R.id.keju_l:
                selectKeju = "L";
                break;
            case R.id.buah_s:
                selectBuah = "S";
                break;
            case R.id.buah_m:
                selectBuah = "M";
                break;
            case R.id.buah_l:
                selectBuah = "L";
                break;
        }

    }
}
