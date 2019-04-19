package com.example.administrator.applich.view.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.applich.R;
import com.example.administrator.applich.data.Lunar;
import com.example.administrator.applich.data.Solar;
import com.example.administrator.applich.database.DatabaseHelper;
import com.example.administrator.applich.view.activity.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class KetQuaTuViTronDoiFragment extends Fragment{
    ArrayList<String> CUNG_NAM;
    ArrayList<String>CUNG_NU;
    CircleImageView cimgTuoi;
    String tongquan="";
    String cuocsong="";
    String tinhduyen="";
    String congdanh="";
    String tuoihoplaman="";
    String tuoihopkethon="";
    String tuoiki="";
    TextView txtGioiTinh;
    TextView txtNgaySinhDuongLich;
    TextView txtNgaySinhAmLich;
    ImageView imgTongQuan;
    ImageView imgCuocSong;
    ImageView imgTinhDuyen;
    ImageView imgCongDanh;
    ImageView imgTuoiHopLamAn;
    ImageView imgTuoiHopKetHon;
    ImageView imgTuoiKi;
    String ngayam="",thangam="",namam="";
    TextView txtCung;
    TextView txtMang;
    TextView txtTongQuan;
    TextView txtCuocSong;
    TextView txtTinhDuyen;
    TextView txtCongDanh;
    TextView txtTuoiHopLamAn;
    TextView txtTuoiHopKetHon;
    TextView txtTuoiKi;
    String namSinh="";
    ImageView imgBack;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_ketquatuvitrondoi,container,false);
        initView();
        int dem=0;
        Log.d("kiemtrangaysinh",TuViTronDoiFragment.ngaySinh);
        for(int i=0;i<TuViTronDoiFragment.ngaySinh.length();i++){
            if(TuViTronDoiFragment.ngaySinh.charAt(i)=='/'){
                dem++;
            }
            if(dem==2&&TuViTronDoiFragment.ngaySinh.charAt(i)!='/'){
                namSinh+=TuViTronDoiFragment.ngaySinh.charAt(i);
            }
        }
        Solar solar=new Solar();
        String mday="";
        String mmonth="";
        String myear="";
        mday+=TuViTronDoiFragment.ngaySinh.charAt(0);
        mday+=TuViTronDoiFragment.ngaySinh.charAt(1);
        mmonth+=TuViTronDoiFragment.ngaySinh.charAt(3);
        mmonth+=TuViTronDoiFragment.ngaySinh.charAt(4);
        myear+=TuViTronDoiFragment.ngaySinh.charAt(6);
        myear+=TuViTronDoiFragment.ngaySinh.charAt(7);
        myear+=TuViTronDoiFragment.ngaySinh.charAt(8);
        myear+=TuViTronDoiFragment.ngaySinh.charAt(9);
        solar.solarDay= Integer.parseInt(mday);
        solar.solarMonth= Integer.parseInt(mmonth);
        solar.solarYear= Integer.parseInt(myear);
        MainActivity.LunarSolarConverter lunarSolarConverter= new MainActivity.LunarSolarConverter();
        Lunar lunar=lunarSolarConverter.SolarToLunar(solar);

        if(lunar.lunarDay<10){
            ngayam+="0"+lunar.lunarDay;
        }
        else{
            ngayam+=lunar.lunarDay;
        }
        if(lunar.lunarMonth<10){
            thangam+="0"+lunar.lunarMonth;
        }
        else{
            thangam+=lunar.lunarMonth;
        }
        getCung(namSinh,TuViTronDoiFragment.gioiTinh);
        getDataFromAssest();
        catchEvent();
        return view;
    }

    private void getCung(String namSinh, int gioiTinh) {
        int sum = 0;
        int i = Integer.parseInt(namSinh);
        int j = 0;
        while (i > 0) {
            j = i%10;
            sum += j;
            i = i/10;
        }
        if (gioiTinh == 1) {
            txtCung.setText("Cung: "+ CUNG_NAM.get(sum % 9));
        }
        else{
            txtCung.setText("Cung: "+ CUNG_NU.get(sum % 9));
        }
    }

    private void getDataFromAssest() {

        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
        try {
            databaseHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        databaseHelper.openDataBase();
        Cursor cursor=databaseHelper.query("tbl_menh",null,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String field1=cursor.getString(0);
            String field2=cursor.getString(1);
            String nam="";
            for(int i=0;i<field1.length();i++){
                if(field1.charAt(i)==' '||field1.charAt(i)==','){
                    nam="";
                }
                else{
                    nam+=field1.charAt(i);
                }
                if(nam.length()==4){
                    if(namSinh.equals(nam)){
                        txtMang.setText("Mạng: "+field2);
                    }
                }
            }
            Log.d("kiemtrasqlite",field1+"   "+field2);
            cursor.moveToNext();
        }
        Cursor cursorTuVi=databaseHelper.query("tbl_tuvi",null,null,null,null,null,null);
        cursorTuVi.moveToFirst();
        while (!cursorTuVi.isAfterLast()){
            String filed1=cursorTuVi.getString(0);
            String filed2=cursorTuVi.getString(1);
            int filed3=cursorTuVi.getInt(2);
            String filed4=cursorTuVi.getString(3);
            String filed5=cursorTuVi.getString(4);
            String filed6=cursorTuVi.getString(5);
            String filed7=cursorTuVi.getString(6);
            String filed8=cursorTuVi.getString(7);
            String filed9=cursorTuVi.getString(8);
            String filed10=cursorTuVi.getString(9);
            String filedl1=cursorTuVi.getString(10);
            String filed12=cursorTuVi.getString(11);
            String tam="";
            for(int i=0;i<filed1.length();i++){
                if(filed1.charAt(i)==','||filed1.charAt(i)==' '){
                    tam="";
                }
                else{
                    tam+=filed1.charAt(i);
                }
                if(tam.length()==4){
                    if(namSinh.equals(tam)){
                        if(TuViTronDoiFragment.gioiTinh==filed3){
                            tongquan=filed4;
                            cuocsong=filed5;
                            tinhduyen=filed6;
                            congdanh=filed7;
                            tuoihoplaman=filed8;
                            tuoihopkethon=filed9;
                            tuoiki=filed10;
                        }
                        if(TuViTronDoiFragment.gioiTinh==0){
                            txtGioiTinh.setText("Nữ mạng "+filed2);
                            txtNgaySinhAmLich.setText("tức "+ngayam+"/"+thangam+" "+filed2+" (ÂL)");
                        }
                        else{
                            txtGioiTinh.setText("Nam mạng "+filed2);
                            txtNgaySinhAmLich.setText("tức "+ngayam+"/"+thangam+" "+filed2+" (ÂL)");
                        }
                        String tuoi="";
                        int gan=0;
                        for(int j=0;j<filed2.length();j++){
                            if(filed2.charAt(j)==' '){
                                gan=j;
                                break;
                            }
                        }
                        for(int j=gan+1;j<filed2.length();j++){
                            tuoi+=filed2.charAt(j);
                        }
                        if(tuoi.equals("Tý")){
                            cimgTuoi.setImageResource(R.mipmap.ti);
                        }
                        if(tuoi.equals("Sửu")){
                            cimgTuoi.setImageResource(R.mipmap.suu);
                        }
                        if(tuoi.equals("Dần")){
                            cimgTuoi.setImageResource(R.mipmap.dan);
                        }
                        if(tuoi.equals("Mão")){
                            cimgTuoi.setImageResource(R.mipmap.mao);
                        }
                        if(tuoi.equals("Thìn")){
                            cimgTuoi.setImageResource(R.mipmap.thin);
                        }
                        if(tuoi.equals("Tỵ")){
                            cimgTuoi.setImageResource(R.mipmap.ty);
                        }
                        if(tuoi.equals("Ngọ")){
                            cimgTuoi.setImageResource(R.mipmap.ngo);
                        }
                        if(tuoi.equals("Mùi")){
                            cimgTuoi.setImageResource(R.mipmap.mui);
                        }
                        if(tuoi.equals("Thân")){
                            cimgTuoi.setImageResource(R.mipmap.than);
                        }
                        if(tuoi.equals("Dậu")){
                            cimgTuoi.setImageResource(R.mipmap.dau);
                        }
                        if(tuoi.equals("Tuất")){
                            cimgTuoi.setImageResource(R.mipmap.tuat);
                        }
                        if(tuoi.equals("Hợi")){
                            cimgTuoi.setImageResource(R.mipmap.hoi);
                        }
                    }
                }
            }
            cursorTuVi.moveToNext();
        }
    }

    private void catchEvent() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        imgTongQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtTongQuan.getText().toString().length()==0){
                    imgTongQuan.setImageResource(R.mipmap.thugon);
                    txtTongQuan.setText(tongquan);
                }
                else{
                    imgTongQuan.setImageResource(R.mipmap.themsukientrongngay);
                    txtTongQuan.setText("");
                }
            }
        });
        imgCuocSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCuocSong.getText().toString().length()==0){
                    imgCuocSong.setImageResource(R.mipmap.thugon);
                    txtCuocSong.setText(cuocsong);
                }
                else{
                    imgCuocSong.setImageResource(R.mipmap.themsukientrongngay);
                    txtCuocSong.setText("");
                }
            }
        });
        imgTinhDuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtTinhDuyen.getText().toString().length()==0){
                    imgTinhDuyen.setImageResource(R.mipmap.thugon);
                    txtTinhDuyen.setText(tinhduyen);
                }
                else{
                    imgTinhDuyen.setImageResource(R.mipmap.themsukientrongngay);
                    txtTinhDuyen.setText("");
                }
            }
        });
        imgCongDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCongDanh.getText().toString().length()==0){
                    imgCongDanh.setImageResource(R.mipmap.thugon);
                    txtCongDanh.setText(congdanh);
                }
                else{
                    imgCongDanh.setImageResource(R.mipmap.themsukientrongngay);
                    txtCongDanh.setText("");
                }
            }
        });
        imgTuoiHopLamAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtTuoiHopLamAn.getText().toString().length()==0){
                    imgTuoiHopLamAn.setImageResource(R.mipmap.thugon);
                    txtTuoiHopLamAn.setText(tuoihoplaman);
                }
                else{
                    imgTuoiHopLamAn.setImageResource(R.mipmap.themsukientrongngay);
                    txtTuoiHopLamAn.setText("");
                }
            }
        });
        imgTuoiHopKetHon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtTuoiHopKetHon.getText().toString().length()==0){
                    imgTuoiHopKetHon.setImageResource(R.mipmap.thugon);
                    txtTuoiHopKetHon.setText(tuoihopkethon);
                }
                else{
                    imgTuoiHopKetHon.setImageResource(R.mipmap.themsukientrongngay);
                    txtTuoiHopKetHon.setText("");
                }
            }
        });
        imgTuoiKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtTuoiKi.getText().toString().length()==0){
                    imgTuoiKi.setImageResource(R.mipmap.thugon);
                    txtTuoiKi.setText(tuoiki);
                }
                else{
                    imgTuoiKi.setImageResource(R.mipmap.themsukientrongngay);
                    txtTuoiKi.setText("");
                }
            }
        });
    }

    private void initView() {
        CUNG_NAM=new ArrayList<>();
        CUNG_NU=new ArrayList<>();
        CUNG_NAM.add("Khảm");
        CUNG_NAM.add("Ly");
        CUNG_NAM.add("Cấn");
        CUNG_NAM.add("Đoài");
        CUNG_NAM.add("Càn");
        CUNG_NAM.add("Khôn");
        CUNG_NAM.add("Tốn");
        CUNG_NAM.add("Chấn");
        CUNG_NAM.add("Khôn");
        CUNG_NU.add("Cấn");
        CUNG_NU.add("Càn");
        CUNG_NU.add("Đoài");
        CUNG_NU.add("Cấn");
        CUNG_NU.add("Ly");
        CUNG_NU.add("Khảm");
        CUNG_NU.add("Khôn");
        CUNG_NU.add("Chấn");
        CUNG_NU.add("Tốn");
        cimgTuoi=view.findViewById(R.id.cimg_tuoi);
        txtGioiTinh=view.findViewById(R.id.txt_gioitinh);
        txtNgaySinhDuongLich=view.findViewById(R.id.txt_ngaysinhduonglich);
        txtNgaySinhDuongLich.setText(TuViTronDoiFragment.ngaySinh+" (DL)");
        txtNgaySinhAmLich=view.findViewById(R.id.txt_ngaysinhamlich);
        imgTongQuan=view.findViewById(R.id.img_tongquan);
        imgCuocSong=view.findViewById(R.id.img_cuocsong);
        imgTinhDuyen=view.findViewById(R.id.img_tinhduyen);
        imgCongDanh=view.findViewById(R.id.img_congdanh);
        imgTuoiHopLamAn=view.findViewById(R.id.img_tuoihoplaman);
        imgTuoiHopKetHon=view.findViewById(R.id.img_tuoihopkethon);
        imgTuoiKi=view.findViewById(R.id.img_tuoiki);
        txtCung=view.findViewById(R.id.txt_cung);
        txtTongQuan=view.findViewById(R.id.txt_tongquan);
        txtCuocSong=view.findViewById(R.id.txt_cuocsong);
        txtTinhDuyen=view.findViewById(R.id.txt_tinhduyen);
        txtCongDanh=view.findViewById(R.id.txt_congdanh);
        txtTuoiHopLamAn=view.findViewById(R.id.txt_tuoihoplaman);
        txtTuoiHopKetHon=view.findViewById(R.id.txt_tuoihopkethon);
        txtTuoiKi=view.findViewById(R.id.txt_tuoiki);
        txtMang=view.findViewById(R.id.txt_mang);
        imgBack=view.findViewById(R.id.img_back);
    }
}
