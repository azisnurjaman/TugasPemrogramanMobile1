package com.example.pendataanpenduduk;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText TglLahir;
    EditText NIK;
    EditText Nama;
    EditText TmptLahir;
    EditText Alamat;
    RadioGroup RadioBtns01, RadioBtns02;
    RadioButton Laki, Perempuan, Kawin, BlmKawin;
    CheckBox PNS, PegawaiSwasta, Pelajar, Wiraswasta;
    String HasilNIK,HasilNama, HasilTglLahir, HasilTmptLahir, HasilAlamat, HasilJK, HasilStatus, HasilPekerjaan;
    ArrayList<String> checkedItem = new ArrayList<String>();
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NIK = (EditText) findViewById(R.id.NIK);
        Nama = (EditText) findViewById(R.id.Nama);
        TmptLahir = (EditText) findViewById(R.id.TmptLahir);
        Alamat = (EditText) findViewById(R.id.Alamat);
        RadioBtns01 = (RadioGroup) findViewById(R.id.RadioBtns01);
        Laki = (RadioButton) findViewById(R.id.Laki);
        Perempuan = (RadioButton) findViewById(R.id.Perempuan);
        RadioBtns02 = (RadioGroup) findViewById(R.id.RadioBtns02);
        Kawin = (RadioButton) findViewById(R.id.Kawin);
        BlmKawin = (RadioButton) findViewById(R.id.BlmKawin);
        PNS = (CheckBox) findViewById(R.id.PNS);
        PegawaiSwasta = (CheckBox) findViewById(R.id.PegawaiSwasta);
        Pelajar = (CheckBox) findViewById(R.id.Pelajar);
        Wiraswasta = (CheckBox) findViewById(R.id.Wiraswasta);
        ImageButton submit = (ImageButton) findViewById(R.id.submit);

        submit.setOnClickListener((v) -> {
            HasilNIK = NIK.getText().toString();
            HasilNama = Nama.getText().toString();
            HasilTmptLahir = TmptLahir.getText().toString();
            HasilTglLahir = TglLahir.getText().toString();
            HasilAlamat = Alamat.getText().toString();
            int selectedId01 = RadioBtns01.getCheckedRadioButtonId();
            if (selectedId01 == Laki.getId()){
                HasilJK = Laki.getText().toString();
            } else if (selectedId01 == Perempuan.getId()) {
                HasilJK = Perempuan.getText().toString();
            } else {
                HasilJK = "-";
            }

            if(PNS.isChecked()){
                HasilPekerjaan += PNS.getText().toString();
            }
            if(PegawaiSwasta.isChecked()){
                HasilPekerjaan += PegawaiSwasta.getText().toString();
            }
            if(Pelajar.isChecked()){
                HasilPekerjaan += Pelajar.getText().toString();
            }
            if(Wiraswasta.isChecked()){
                HasilPekerjaan += Wiraswasta.getText().toString();
            }

            int selectedId02 = RadioBtns02.getCheckedRadioButtonId();
            if (selectedId02 == Kawin.getId()){
                HasilStatus = Kawin.getText().toString();
            } else if (selectedId02 == BlmKawin.getId()) {
                HasilStatus = BlmKawin.getText().toString();
            } else {
                HasilStatus = "-";
            }

            Intent i = null;
            i = new Intent(MainActivity.this, tampil.class);
            Bundle b = new Bundle();
            b.putString("parse_nik", String.valueOf(HasilNIK));
            b.putString("parse_nama", String.valueOf(HasilNama));
            b.putString("parse_tmptLahir", String.valueOf(HasilTmptLahir));
            b.putString("parse_tglLahir", String.valueOf(HasilTglLahir));
            b.putString("parse_alamat", String.valueOf(HasilAlamat));
            b.putString("parse_jk", String.valueOf(HasilJK));
            b.putString("parse_Pekerjaan", String.valueOf(HasilPekerjaan));
            b.putString("parse_status", String.valueOf(HasilStatus));

            i.putExtras(b);
            startActivity(i);
        });
        // initiate the date picker and a button
        TglLahir = (EditText) findViewById(R.id.TglLahir);
        // perform click event on edit text
        TglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                TglLahir.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

}