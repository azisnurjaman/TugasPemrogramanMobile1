package com.example.pendataanpenduduk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class tampil extends AppCompatActivity {
    TextView HasilNIK, HasilNama, HasilTmptLahir, HasilTglLahir, HasilAlamat, HasilJK, HasilPekerjaan, HasilStatus;
    String NIK, Nama, TmptLahir, TglLahir, Alamat, JK, Pekerjaan, Status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        HasilNIK = (TextView) findViewById(R.id.HasilNIK);
        HasilNama = (TextView) findViewById(R.id.HasilNama);
        HasilTmptLahir = (TextView) findViewById(R.id.HasilTmptLahir);
        HasilTglLahir = (TextView) findViewById(R.id.HasilTglLahir);
        HasilAlamat = (TextView) findViewById(R.id.HasilALamat);
        HasilJK = (TextView) findViewById(R.id.HasilJK);
        HasilPekerjaan = (TextView) findViewById(R.id.HasilPekerjaan);
        HasilStatus = (TextView) findViewById(R.id.HasilStatus);

        Bundle b = getIntent().getExtras();

        NIK = b.getString("parse_nik");
        Nama = b.getString("parse_nama");
        TmptLahir = b.getString("parse_tmptLahir");
        TglLahir = b.getString("parse_tglLahir");
        Alamat = b.getString("parse_alamat");
        JK = b.getString("parse_jk");
        Pekerjaan = b.getString("parse_pekerjaan");
        Status = b.getString("parse_status");

        HasilNIK.setText("NIK : "+NIK);
        HasilNama.setText("Nama : "+Nama);
        HasilTmptLahir.setText("Tempat Lahir : "+TmptLahir);
        HasilTglLahir.setText("Tanggal Lahir : "+TglLahir);
        HasilAlamat.setText("ALamat : "+Alamat);
        HasilJK.setText("Jenis Kelamin : "+JK);
        HasilPekerjaan.setText("Pekerjaan : "+Pekerjaan);
        HasilStatus.setText("Status : "+Status);

        ImageButton kembali = (ImageButton) findViewById(R.id.back);
        kembali.setOnClickListener((v)->{
            Intent i = null;
            i = new Intent(tampil.this, MainActivity.class);
            startActivity(i);
        });
    }
}