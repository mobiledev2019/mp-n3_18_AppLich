package com.example.administrator.applich.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.applich.R;
import com.example.administrator.applich.network.ApiClient;
import com.example.administrator.applich.network.DataService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CungHoangDaoChiTietFragment extends Fragment{
    ImageView imgBack;
    TextView txtToolbar;
    Call<JsonElement>call;
    DataService dataService;
    TextView txtNoiDungTuViTrongNgay;
    String ngay;
    TextView txtNgayTrongTuan;
    String date;
    String dateVn;
    ImageView imgCungHoangDao;
    View view;
    String weekday_name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_cunghoangdaochitiet,container,false);
        initView();
        date=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        dateVn=new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        Log.d("kiemtrangay",weekday_name);
        if(weekday_name.equals("Monday")){
            ngay="thứ 2";
        }
        else if(weekday_name.equals("Tuesday")){
            ngay="thứ 3";
        }
        else if(weekday_name.equals("Wednesday")){
            ngay="thứ 4";
        }
        else if(weekday_name.equals("Thursday")){
            ngay="thứ 5";
        }
        else if(weekday_name.equals("Friday")){
            ngay="thứ 6";
        }
        else if(weekday_name.equals("Saturday")){
            ngay="thứ 7";
        }
        else if(weekday_name.equals("Sunday")){
            ngay="chủ nhật";
        }
        getData();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    private void initView() {
        txtToolbar=view.findViewById(R.id.txt_toolbar);
        if(CungHoangDaoFragment.tieuDeToolbar.equals("Bạch Dương")){
            txtToolbar.setText("Bạch Dương");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Kim Ngưu")){
            txtToolbar.setText("Kim Ngưu");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Song Tử")){
            txtToolbar.setText("Song Tử");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Cự Giải")){
            txtToolbar.setText("Cự Giải");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Sư Tử")){
            txtToolbar.setText("Sư Tử");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Xử Nữ")){
            txtToolbar.setText("Xử Nữ");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Thiên Bình")){
            txtToolbar.setText("Thiên Bình");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Thiên Yết")){
            txtToolbar.setText("Thiên Yết");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Nhân Mã")){
            txtToolbar.setText("Nhân Mã");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Ma Kết")){
            txtToolbar.setText("Ma Kết");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Bảo Bình")){
            txtToolbar.setText("Bảo Bình");
        }
        else if(CungHoangDaoFragment.tieuDeToolbar.equals("Song Ngư")){
            txtToolbar.setText("Song Ngư");
        }
        txtNoiDungTuViTrongNgay=view.findViewById(R.id.txt_noidungtuvitrongngay);
        txtNgayTrongTuan=view.findViewById(R.id.txt_ngaytrongtuan);
        imgCungHoangDao=view.findViewById(R.id.img_cunghoangdao);
        imgBack=view.findViewById(R.id.img_back);
    }

    private void getData() {
        if(ngay.equals("chủ nhật")==false){
            txtNgayTrongTuan.setText("Tử vi "+ngay+" ngày "+dateVn+" của "+txtToolbar.getText().toString());
        }
        else{
            txtNgayTrongTuan.setText("Tử vi chủ nhật"+" ngày "+dateVn+" của "+txtToolbar.getText().toString());
        }
        if(txtToolbar.getText().equals("Bạch Dương")){
            imgCungHoangDao.setImageResource(R.mipmap.bachduong);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","bd",date);
        }
        else if(txtToolbar.getText().equals("Kim Ngưu")){
            imgCungHoangDao.setImageResource(R.mipmap.kimnguu);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","kn",date);
        }
        else if(txtToolbar.getText().equals("Song Tử")){
            imgCungHoangDao.setImageResource(R.mipmap.songtu);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","sot",date);
        }
        else if(txtToolbar.getText().equals("Cự Giải")){
            imgCungHoangDao.setImageResource(R.mipmap.cugiai);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","cg",date);
        }
        else if(txtToolbar.getText().equals("Sư Tử")){
            imgCungHoangDao.setImageResource(R.mipmap.sutu);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","sut",date);
        }
        else if(txtToolbar.getText().equals("Xử Nữ")){
            imgCungHoangDao.setImageResource(R.mipmap.xunu);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","xn",date);
        }
        else if(txtToolbar.getText().equals("Thiên Bình")){
            imgCungHoangDao.setImageResource(R.mipmap.thienbinh);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","tb",date);
        }
        else if(txtToolbar.getText().equals("Thiên Yết")){
            imgCungHoangDao.setImageResource(R.mipmap.thienyet);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","hc",date);
        }
        else if(txtToolbar.getText().equals("Nhân Mã")){
            imgCungHoangDao.setImageResource(R.mipmap.nhanma);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","nm",date);
        }
        else if(txtToolbar.getText().equals("Ma Kết")){
            imgCungHoangDao.setImageResource(R.mipmap.maket);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","mk",date);
        }
        else if(txtToolbar.getText().equals("Bảo Bình")){
            imgCungHoangDao.setImageResource(R.mipmap.baobinh);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","bb",date);
        }
        else if(txtToolbar.getText().equals("Song Ngư")){
            imgCungHoangDao.setImageResource(R.mipmap.songngu);
            dataService= ApiClient.getService();
            call=dataService.getCungHoangDao("gethoro","getdetail","sn",date);
        }
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                JsonElement content;
                if(response.isSuccessful()){
                    JsonObject jsonObject=response.body().getAsJsonObject();
                    Log.d("kiemtra",jsonObject.toString());
                    JsonArray jsonArray=jsonObject.getAsJsonArray("zodiacs");
                    for(int i=0;i<jsonArray.size();i++){
                        JsonObject jsonObjectNoiDung= (JsonObject) jsonArray.get(i);
                        content=jsonObjectNoiDung.get("content");
                        String noidung=content.getAsString();
                        Log.d("kiemtranoidung",noidung);
                        txtNoiDungTuViTrongNgay.setText(noidung);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("kiemtracunghoangdao",t.getMessage().toString());
            }
        });
    }
}
