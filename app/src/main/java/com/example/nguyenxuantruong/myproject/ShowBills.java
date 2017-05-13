package com.example.nguyenxuantruong.myproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nguyenxuantruong.myproject.targets.Bill;

import java.util.ArrayList;
import java.util.List;

public class ShowBills extends AppCompatActivity {

    List<Bill> model=new ArrayList<>();
    BillAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showbill);
        initData();
        ListView list=(ListView)findViewById(R.id.showBillB);
        adapter=new BillAdapter();
        list.setAdapter(adapter);
    }
    public void initData(){
        Bill b1=new Bill(19,8,2017,true,"mua Mac","26000000","Macbook pro 2015","atm");
        model.add(b1);
        Bill b2=new Bill(19,8,2017,true,"mua Mac","26000000","Macbook pro 2015","atm");
        model.add(b2);
        Bill b3=new Bill(19,8,2017,false,"mua Mac","26000000","Macbook pro 2015","vi");
        model.add(b3);
        Bill b4=new Bill(19,8,2017,true,"mua Mac","26000000","Macbook pro 2015","atm");
        model.add(b4);
    }

    class BillAdapter extends ArrayAdapter<Bill> {
        BillAdapter(){
            super(ShowBills.this,R.layout.showbillrow,model);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            View row= convertView;
            BillHolder holder=null;
            if(row==null){
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.showbillrow,parent,false);
                holder =new  BillHolder(row);
                row.setTag(holder);
            }
            else {
                holder=(BillHolder) row.getTag();
            }
            holder.populateFrom(model.get(position));
            return row;
        }
    }

    static class BillHolder {
        private TextView NoidungB=null;
        private TextView dateB=null;
        private ImageView iconB=null;
        private TextView SotienB=null;
        private TextView loaiTK=null;
        private LinearLayout linearLayout=null;
        private ImageView iconHTTT=null; //icon hinh thuc thanh toan = atm or vi
        BillHolder(View row) {
            NoidungB=(TextView)row.findViewById(R.id.NoidungB);
            dateB=(TextView)row.findViewById(R.id.dateB);
            iconB=(ImageView)row.findViewById(R.id.iconB);
            SotienB=(TextView)row.findViewById(R.id.SotienB);
            loaiTK=(TextView)row.findViewById(R.id.loaiTaiKhoanB);
            linearLayout=(LinearLayout)row.findViewById(R.id.showrow);
            iconHTTT=(ImageView)row.findViewById(R.id.iconhinhthucthanhtoan);
        }
        //yesterday once more:maxx hay
        void populateFrom(Bill r) {
            NoidungB.setText(r.getNoiDung());
            dateB.setText(r.getTime()+"");

            SotienB.setText(r.getSoTien());
            if(r.isChiTieu()){

                iconB.setImageResource(R.drawable.buy);
                linearLayout.setBackgroundColor(Color.parseColor("#7FFFD4"));
            }
            else{

                iconB.setImageResource(R.drawable.banknotes);
                linearLayout.setBackgroundColor(Color.parseColor("#F84B2D"));

            }

            if(r.getHinhthucthanhtoan().equals("vi")){
                loaiTK.setText("vi");
                iconHTTT.setImageResource(R.drawable.wallet);
            }
            else{
                loaiTK.setText("atm");
                iconHTTT.setImageResource(R.drawable.atm);
            }

        }
    }
}
