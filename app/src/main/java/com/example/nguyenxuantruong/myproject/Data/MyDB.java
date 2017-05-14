package com.example.nguyenxuantruong.myproject.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nguyenxuantruong.myproject.targets.Bill;

import java.util.ArrayList;

/**
 * Created by nguyenxuantruong on 5/9/17.
 */

public class MyDB extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME ="list_bill.db";
    private final static String DATABASE_TABLE = "Bill";


    public final static String KEY_ID = "_id";
    public final static String KEY_NGAY = "ngayPhatSinh";
    public final static String KEY_THANG = "thangPhatSinh";
    public final static String KEY_NAM = "namPhatSinh";
    public final static String KEY_NOI_DUNG = "noiDung";
    public final static String KEY_SO_TIEN = "soTien";
    public final static String KEY_GHI_CHU = "ghiChu";
    public final static String KEY_CHI_TIEU = "chiTieu";
    public final static String KEY_HINH_THUC_THANH_TOAN = "httt";
    public final static String KEY_KY_HAN = "kyHan";

    SQLiteDatabase db;

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + "( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         KEY_NGAY + " INTEGER, "  + KEY_THANG + " INTEGER, " + KEY_NAM + " INTEGER, " + KEY_NOI_DUNG +
                        " TEXT, " + KEY_GHI_CHU + " TEXT, " + KEY_SO_TIEN + " TEXT NOT NULL, " + KEY_CHI_TIEU + " TEXT, " +
                KEY_HINH_THUC_THANH_TOAN + " TEXT, " + KEY_KY_HAN + " TEXT );"
                );
            Log.e("create db", "OK");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +  DATABASE_TABLE );
    }

    public void addBill(Bill bill){
        ContentValues cv = new ContentValues();
        cv.put(KEY_NGAY,bill.getNgayPhatSinh());
        cv.put(KEY_THANG,bill.getThangPhatSinh());
        cv.put(KEY_NAM,bill.getNamPhatSinh());
        cv.put(KEY_NOI_DUNG,bill.getNoiDung());
        cv.put(KEY_GHI_CHU,bill.getGhiChu());
        cv.put(KEY_SO_TIEN,bill.getSoTien());
        cv.put(KEY_CHI_TIEU,bill.isChiTieu());
        cv.put(KEY_HINH_THUC_THANH_TOAN,bill.getHinhthucthanhtoan());
        cv.put(KEY_KY_HAN,bill.getKyHan());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(DATABASE_TABLE,null,cv);
        db.close();
        Log.e("added","succesful!");
    }

    public ArrayList<Bill> getData(int type){
        db = getReadableDatabase();
        Bill bill = new Bill();
        ArrayList<Bill> arrayList = new ArrayList<>();
        String[] cols = {KEY_NGAY,KEY_THANG,KEY_NAM,KEY_HINH_THUC_THANH_TOAN,KEY_KY_HAN,KEY_CHI_TIEU,
        KEY_GHI_CHU,KEY_SO_TIEN,KEY_NOI_DUNG};
        Cursor c = db.query(DATABASE_TABLE,cols,null,null,null,null,null);

        for (c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            bill.setNgayPhatSinh(Integer.valueOf(c.getString(c.getColumnIndex(KEY_NGAY))));
            bill.setNamPhatSinh(Integer.valueOf(c.getString(c.getColumnIndex(KEY_NAM))));
            bill.setThangPhatSinh(Integer.valueOf(c.getString(c.getColumnIndex(KEY_THANG))));
            bill.setGhiChu(c.getString(c.getColumnIndex(KEY_GHI_CHU)));
            bill.setSoTien(c.getString(c.getColumnIndex(KEY_SO_TIEN)));
            bill.setKyHan(c.getString(c.getColumnIndex(KEY_KY_HAN)));
            bill.setChiTieu(Boolean.valueOf(c.getString(c.getColumnIndex(KEY_CHI_TIEU))));
            //Log.e("hihi",bill.getNoiDung());
            arrayList.add(bill);
        }

//        switch(type){
//            case 1 :
//                break;
//        }
        db.close();
        return arrayList;
    }

    public String databaseToString(){
        String result= new String();
        db  = getReadableDatabase();
        String query = "SELECT * FROM " + DATABASE_TABLE + " WHERE 1";

        Cursor c = db.rawQuery(query,null);

        for (c.moveToFirst() ; !c.isAfterLast();c.moveToFirst()){
            result += c.getString(c.getColumnIndex(KEY_ID)) + c.getString(c.getColumnIndex(KEY_NGAY)) +
                    c.getString(c.getColumnIndex(KEY_THANG)) + c.getString(c.getColumnIndex(KEY_NAM));
        }
        db.close();
        return result;
    }

    
}
