package com.example.administrator.applich.data;

public class GioHoangDao {
    String giohoangdao;
    String thoigiangiohoangdao;
    int hinhanhgiohoangdao;

    public GioHoangDao(String giohoangdao, String thoigiangiohoangdao, int hinhanhgiohoangdao) {
        this.giohoangdao = giohoangdao;
        this.thoigiangiohoangdao = thoigiangiohoangdao;
        this.hinhanhgiohoangdao = hinhanhgiohoangdao;
    }

    public String getGiohoangdao() {
        return giohoangdao;
    }

    public void setGiohoangdao(String giohoangdao) {
        this.giohoangdao = giohoangdao;
    }

    public String getThoigiangiohoangdao() {
        return thoigiangiohoangdao;
    }

    public void setThoigiangiohoangdao(String thoigiangiohoangdao) {
        this.thoigiangiohoangdao = thoigiangiohoangdao;
    }

    public int getHinhanhgiohoangdao() {
        return hinhanhgiohoangdao;
    }

    public void setHinhanhgiohoangdao(int hinhanhgiohoangdao) {
        this.hinhanhgiohoangdao = hinhanhgiohoangdao;
    }
}
