package com.example.nguyenxuantruong.myproject.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nguyenxuantruong.myproject.targets.Bill;

/**
 * Created by nguyenxuantruong on 5/9/17.
 */

public class MyDB extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME ="list_bill.db";
    private final static String DATABASE_TABLE = "Bill";


    public final static String KEY_ID = "_id";
    public final static String KEY_NGAY = "ngayPhatSinh";
    public final static String KEY_THANG = "ngayPhatSinh";
    public final static String KEY_NAM = "ngayPhatSinh";
    public final static String KEY_NOI_DUNG = "ngayPhatSinh";
    public final static String KEY_SO_TIEN = "ngayPhatSinh";
    public final static String KEY_GHI_CHU = "ngayPhatSinh";
    public final static String KEY_CHI_TIEU = "ngayPhatSinh";

    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + "( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                         KEY_NGAY + " INTEGER "  + KEY_THANG + " INTEGER " + KEY_NAM + " INTEGER " + KEY_NOI_DUNG +
                        " TEXT " + KEY_GHI_CHU + " TEXT " + KEY_SO_TIEN + " TEXT " + KEY_CHI_TIEU + " TEXT );"
                );

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
        SQLiteDatabase db = getWritableDatabase();
        db.insert(DATABASE_TABLE,null,cv);
        db.close();
    }

    public void removeBill(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE " + DATABASE_TABLE + " WHERE " );
    }

    
}
