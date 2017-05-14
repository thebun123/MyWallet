package com.example.nguyenxuantruong.myproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nguyenxuantruong.myproject.Graph.GraphActivity;
import com.example.nguyenxuantruong.myproject.Time.Day;
import com.example.nguyenxuantruong.myproject.targets.Targets;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView date;
    private Button thongKe, chiTieu, guiTK, thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        showToday();


    }

    private void showToday() {
        Day day = new Day();
        date.setText(day.today());
    }

    private void initView() {
        //findView
        date = (TextView) findViewById(R.id.tvToday);
        thongKe = (Button) findViewById(R.id.bThong_ke);
        chiTieu = (Button) findViewById(R.id.bChi_tieu);
        guiTK = (Button) findViewById(R.id.bGui_tk);
        thoat = (Button) findViewById(R.id.bOut);

        //setOnclick
        thongKe.setOnClickListener(this);
        chiTieu.setOnClickListener(this);
        guiTK.setOnClickListener(this);
        thoat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.bThong_ke :
                Intent i = new Intent(MainActivity.this,GraphActivity.class);
                startActivity(i);
                break;

            case R.id.bChi_tieu :
                Intent intent = new Intent(MainActivity.this, Targets.class);
                intent.putExtra("type","add");
                startActivity(intent);
                break;

            case R.id.bGui_tk :
                Intent t=new Intent(MainActivity.this,ShowBills.class);
                startActivity(t);
                break;

            case R.id.bOut :
                finish();
                break;
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode==RESULT_OK){
//            if(requestCode==1){
//                Log.e("da",data.getStringExtra("noidung"));
//
//                Bill bill = new Bill(19, 8, 2017, true, "mua Mac", "26000000", "Macbook pro 2015", "atm");
//                bill.setSoTien(data.getStringExtra("tien"));
//                bill.setSoTien(data.getStringExtra("ghichu"));
//                bill.setSoTien(data.getStringExtra("nam") +"");
//                bill.setSoTien(data.getStringExtra("ngay")+"");
//                bill.setSoTien(data.getStringExtra("thang")+"");
//                bill.setSoTien(data.getStringExtra("noidung"));
//                bill.setSoTien(data.getStringExtra("chitieu"));
//
////                Log.e("data","tien" + " : " + data.getStringExtra("tien"));
////                Log.e("data","ghichu" + " : " + data.getStringExtra("ghichu"));
////                Log.e("data","nam" + " : " + data.getStringExtra("nam") +"");
////                Log.e("data","ngay" + " : " + data.getStringExtra("ngay")+"");
////                Log.e("data","thang" + " : " + data.getStringExtra("thang")+"");
////                Log.e("data","noidung" + " : " + data.getStringExtra("noidung"));
////                Log.e("data","chitieu" + " : " + data.getStringExtra("chitieu"));
////                Log.e("data","kyhan" + " : " + data.getStringExtra("kyhan"));
//
////                Log.e("done",bill.getNgayPhatSinh()+"");
////                Log.e("done",bill.getThangPhatSinh() +"");
////                Log.e("done",bill.getNamPhatSinh() +"");
////                Log.e("done",bill.getSoTien());
////                Log.e("done",bill.getNoiDung());
////                Log.e("done",bill.getGhiChu());
////                Log.e("done",bill.isChiTieu() +"");
//            }
//        }
//
//    }
}
