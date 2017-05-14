package com.example.nguyenxuantruong.myproject.targets;

import com.example.nguyenxuantruong.myproject.Time.Day;

/**
 * Created by nguyenxuantruong on 5/8/17.
 */

public class Bill {

    private int  thangPhatSinh, ngayPhatSinh, namPhatSinh;
    private boolean chiTieu; //0-thu   1-chi
    private String noiDung, ghiChu, soTien,hinhthucthanhtoan,kyHan;

    public Bill(int i, int i1, int i2, boolean b, String s, String s1, String s2, String atm) {
        Day day = new Day();
        this.thangPhatSinh = day.getDate();
        this.namPhatSinh = day.getMonth();
        this.ngayPhatSinh = day.getYear();
        this.chiTieu = false;
        this.noiDung = "";
        this.soTien = "";
        this.ghiChu = "";
        this.hinhthucthanhtoan="vi";
        this.kyHan ="Không có";
    }

    public Bill(){
        Day day = new Day();
        this.thangPhatSinh = day.getDate();
        this.namPhatSinh = day.getMonth();
        this.ngayPhatSinh = day.getYear();
        this.chiTieu = false;
        this.noiDung = "";
        this.soTien = "";
        this.ghiChu = "";
        this.hinhthucthanhtoan="vi";
    }

    public Bill(int ngayPhatSinh,
                int thangPhatSinh,
                int namPhatSinh,
                String noiDung,
                String soTien,
                String ghiChu,
                boolean chiTieu) {
        this.thangPhatSinh = thangPhatSinh;
        this.namPhatSinh = namPhatSinh;
        this.ngayPhatSinh = ngayPhatSinh;
        this.chiTieu = chiTieu;
        this.noiDung = noiDung;
        this.soTien = soTien;
        this.ghiChu = ghiChu;
    }

    public String getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public int getThangPhatSinh() {
        return thangPhatSinh;
    }

    public void setThangPhatSinh(int thangPhatSinh) {
        this.thangPhatSinh = thangPhatSinh;
    }

    public int getNgayPhatSinh() {
        return ngayPhatSinh;
    }

    public void setNgayPhatSinh(int ngayPhatSinh) {
        this.ngayPhatSinh = ngayPhatSinh;
    }

    public boolean isChiTieu() {
        return chiTieu;
    }

    public void setChiTieu(boolean chiTieu) {
        this.chiTieu = chiTieu;
    }

    public int getNamPhatSinh() {
        return namPhatSinh;
    }

    public void setNamPhatSinh(int namPhatSinh) {
        this.namPhatSinh = namPhatSinh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public String getTime(){
        return ngayPhatSinh+"/"+thangPhatSinh+"/"+namPhatSinh;
    }

}
