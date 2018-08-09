package id.co.asyst.yeni.learnfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.co.asyst.yeni.learnfragment.fragments.FourthFragment;
import id.co.asyst.yeni.learnfragment.fragments.InputButtonSheetFragment;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, FourthFragment.OnSubmitButtonListener, InputButtonSheetFragment.OnSubmitButtonListener {

    TextView namaTV, alamatTV, dateTV;
    Button inputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        namaTV = findViewById(R.id.nama_textview);
        alamatTV = findViewById(R.id.alamat_textview);
        inputButton = findViewById(R.id.input_button);
        dateTV = findViewById(R.id.date_textview);

        inputButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.input_button:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FourthFragment fourthFragment = FourthFragment.newInstance(
                        namaTV.getText().toString(),
                        alamatTV.getText().toString(),
                        dateTV.getText().toString());
                transaction.replace(android.R.id.content, fourthFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                break;
        }
    }


    @Override
    public void onSubmitButton(String name, String address, String birthday) {
        namaTV.setText(name);
        alamatTV.setText(address);
        dateTV.setText(birthday);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.input_main_menu:
                InputButtonSheetFragment inputButtonSheetFragment = InputButtonSheetFragment.newInstance(namaTV.getText().toString(), alamatTV.getText().toString(), dateTV.getText().toString());
                inputButtonSheetFragment.show(getSupportFragmentManager(), "inputbottomsheet");

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
