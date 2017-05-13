package com.example.nguyenxuantruong.myproject.targets;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nguyenxuantruong.myproject.R;
import com.example.nguyenxuantruong.myproject.Time.Day;

public class Targets extends Activity {

    private String TAG = Targets.class.getSimpleName();//Lấy tn classaaa
    private RadioGroup loaiGiaoDich; //1-thu  2-chi
    private RadioButton thuNhap, chiTieu;
    private EditText ghiChu, tien;
    private TextView time;
    private Spinner spNoiDung;
    private ImageView ok, cancel,edit;
    Bill bill;
    int pos;
    Day day;

    private int year,month,date;

    String[] noiDung ={ "Hàng điện tử","Hàng hóa chất", "Hàng gia dụng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targets);

        initView();


        Bundle bun = getIntent().getExtras();
        final String type =  bun.getString("type");
        Log.e(TAG, type);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("add")){
                    getData();
                }
                else if(type.equals("edit")){
                    editData();
                }
                Intent data = new Intent();
                data.putExtra("tien",bill.getSoTien());
                data.putExtra("ghichu",bill.getGhiChu());
                data.putExtra("nam",String.valueOf(bill.getNamPhatSinh()));
                data.putExtra("ngay",String.valueOf(bill.getNgayPhatSinh()));
                data.putExtra("thang",String.valueOf(bill.getThangPhatSinh()));
                data.putExtra("noidung",bill.getNoiDung());
                data.putExtra("chitieu",String.valueOf(bill.isChiTieu()));
//                Log.e("bill",bill.getNgayPhatSinh()+"");
//                Log.e("bill",bill.getThangPhatSinh() +"");
//                Log.e("bill",bill.getNamPhatSinh() +"");
//                Log.e("bill",bill.getSoTien());
//                Log.e("bill",bill.getNoiDung());
//                Log.e("bill",bill.getGhiChu());
//                Log.e("bill",bill.isChiTieu() +"");
                setResult(RESULT_OK,data);
                finish();
            }
        });
    }

    private void editData() {
    }

    private void getData() {

         bill = new Bill();
        //date
        bill.setNgayPhatSinh(date);
        bill.setNamPhatSinh(year);
        bill.setThangPhatSinh(month);

        //ghichu
        bill.setGhiChu(ghiChu.getText().toString());

        //tien
        bill.setSoTien(tien.getText().toString());


        //type
        loaiGiaoDich.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedId) {
                switch(checkedId){
                    case R.id.rb_ex :
                        bill.setChiTieu(true);//chi
                        break;
                    case R.id.rb_im :
                        bill.setChiTieu(false);//thu
                }
            }
        });

        bill.setNoiDung(noiDung[pos]);


    }

    private void showDate(int date,int month,int year){
        time.setText(day.today());
    }

    private void initView() {
         day = new Day();
        date = day.getDate();
        month = day.getMonth();
        year = day.getYear();
        edit = (ImageView) findViewById(R.id.bEdit);
        time = (TextView) findViewById(R.id.tvTime);
        loaiGiaoDich = (RadioGroup) findViewById(R.id.rgType);
        thuNhap = (RadioButton) findViewById(R.id.rb_im);
        chiTieu = (RadioButton) findViewById(R.id.rb_ex);
        ghiChu = (EditText) findViewById(R.id.etNote);
        tien = (EditText) findViewById(R.id.etCost);
        ok = (ImageView) findViewById(R.id.ivDone);
        cancel = (ImageView) findViewById(R.id.ivCancel);
        spNoiDung = (Spinner) findViewById(R.id.spMain);

        showDate(date,month +1,year);

        //mo cai nay ra, face time di
        ArrayAdapter<String> adapterND = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,noiDung);
        //adapterND.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spNoiDung.setAdapter(adapterND);

        spNoiDung.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, position +"");
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(111);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if(id==111){
            return new DatePickerDialog(this,myDateListener,year,month,date);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener()

    {
        @Override
        public void onDateSet(DatePicker view, int a, int b, int c) {
            date = c;
            month = b;
            year = a;
            showDate(date, (month)+1, year);
        }
    };
}


