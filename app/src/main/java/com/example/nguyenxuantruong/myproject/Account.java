package com.example.nguyenxuantruong.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

/**
 * Created by Tung on 5/12/2017.
 */

public class Account extends AppCompatActivity {
    Spinner Sthuocloai=null,Skihan=null;
    Spinner Sngoaite=null;
    ImageView Isave=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        Isave=(ImageView)findViewById(R.id.Isave);
        Isave.setImageResource(R.drawable.save);

        //cai dat spinner the loai
        Sthuocloai=(Spinner)findViewById(R.id.spinnerTL);
        ArrayAdapter adapterTL = ArrayAdapter.createFromResource(this,
                R.array.thuocloai_array, android.R.layout.simple_spinner_item);
        adapterTL.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Sthuocloai.setAdapter(adapterTL);

        //cai dat spinner loại ngoại tệ
        Sngoaite=(Spinner)findViewById(R.id.spinnerNT);
        ArrayAdapter adapterNT = ArrayAdapter.createFromResource(this,
                R.array.ngoaite_array, android.R.layout.simple_spinner_item);
        adapterNT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Sngoaite.setAdapter(adapterNT);

        //cai dat spinner kì hạn
        Skihan=(Spinner)findViewById(R.id.SKiHan);
        ArrayAdapter adapterKH = ArrayAdapter.createFromResource(this,
                R.array.kihan_array, android.R.layout.simple_spinner_item);
        adapterKH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Skihan.setAdapter(adapterKH);
    }
}
