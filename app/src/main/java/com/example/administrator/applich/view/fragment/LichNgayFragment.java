package com.example.administrator.applich.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.applich.R;
import com.example.administrator.applich.adapter.CustomPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LichNgayFragment extends Fragment{
    int day,month,year,n;
    Calendar calendar;
    TextView txtThangNam;
    TextView txtNgay;
    String mung="";
    TextView txtThu;
    TextView txtMung;
    String weekday_name;
    String ngay;
    String date;
    String dateVn;
    ViewPager viewPager;
    View view;
    int[] mResources = {
            R.mipmap.img_001,
            R.mipmap.img_002,
            R.mipmap.img_003,
            R.mipmap.img_004,
            R.mipmap.img_005,
            R.mipmap.img_006,
            R.mipmap.img_007,
            R.mipmap.img_008,
            R.mipmap.img_009,
            R.mipmap.img_010,
            R.mipmap.img_011,
            R.mipmap.img_012,
            R.mipmap.img_013,
            R.mipmap.img_014,
            R.mipmap.img_015,
            R.mipmap.img_016,
            R.mipmap.img_017,
            R.mipmap.img_018,
            R.mipmap.img_019,
            R.mipmap.img_020,
            R.mipmap.img_021,
            R.mipmap.img_022,
            R.mipmap.img_023,
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_lichngay,container,false);
        initView();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                day=calendar.get(Calendar.DAY_OF_MONTH);
                month=calendar.get(Calendar.MONTH)+1;
                year=calendar.get(Calendar.YEAR);
                Log.d("kiemtrapage",i+"");
                int t=day+i;
                txtMung.setText(t+"");
                int cc,yy,c;
                cc=year/100;
                yy = year - ((year/100)*100);
                c = (cc/4) - 2*cc-1;
                year = 5*yy/4;
                month = 26*(month+1)/10;
                n = (c+year+month+t)%7;
                if(n==0){
                    txtThu.setText("CHỦ NHẬT");
                }
                else if(n==1){
                    txtThu.setText("THỨ HAI");
                }
                else if(n==2){
                    txtThu.setText("THỨ BA");
                }
                else if(n==3){
                    txtThu.setText("THỨ TƯ");
                }
                else if(n==4){
                    txtThu.setText("THỨ NĂM");
                }
                else if(n==5){
                    txtThu.setText("THỨ SÁU");
                }
                else if(n==6){
                    txtThu.setText("THỨ BẢY");
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        txtNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
                if(weekday_name.equals("Monday")){
                    ngay="THỨ HAI";
                }
                else if(weekday_name.equals("Tuesday")){
                    ngay="THỨ BA";
                }
                else if(weekday_name.equals("Wednesday")){
                    ngay="THỨ TỨ";
                }
                else if(weekday_name.equals("Thursday")){
                    ngay="THỨ NĂM";
                }
                else if(weekday_name.equals("Friday")){
                    ngay="THỨ SÁU";
                }
                else if(weekday_name.equals("Saturday")){
                    ngay="THỨ BẢY";
                }
                else if(weekday_name.equals("Sunday")){
                    ngay="CHỦ NHẬT";
                }
                txtThu.setText(ngay);
                txtMung.setText(calendar.get(Calendar.DAY_OF_MONTH)+"");
            }
        });
    }

    private void initView() {
        txtNgay=view.findViewById(R.id.txt_ngay);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH)+1;
        year=calendar.get(Calendar.YEAR);
        txtThangNam=view.findViewById(R.id.txt_thangnam);
        txtThangNam.setText("Tháng "+(calendar.get(Calendar.MONTH)+1)+" "+calendar.get(Calendar.YEAR));
        txtThu=view.findViewById(R.id.txt_thu);
        txtMung=view.findViewById(R.id.txt_mung);
        date=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        dateVn=new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        Log.d("kiemtrangay",weekday_name);
        if(weekday_name.equals("Monday")){
            ngay="THỨ HAI";
        }
        else if(weekday_name.equals("Tuesday")){
            ngay="THỨ BA";
        }
        else if(weekday_name.equals("Wednesday")){
            ngay="THỨ TỨ";
        }
        else if(weekday_name.equals("Thursday")){
            ngay="THỨ NĂM";
        }
        else if(weekday_name.equals("Friday")){
            ngay="THỨ SÁU";
        }
        else if(weekday_name.equals("Saturday")){
            ngay="THỨ BẢY";
        }
        else if(weekday_name.equals("Sunday")){
            ngay="CHỦ NHẬT";
        }
        mung="";
        mung+=dateVn.charAt(0);
        mung+=dateVn.charAt(1);
        txtThu.setText("");
        txtThu.setText(ngay);
        txtMung.setText("");
        txtMung.setText(mung);
        viewPager=view.findViewById(R.id.viewpaper);
        CustomPagerAdapter customPagerAdapter=new CustomPagerAdapter(getActivity(),mResources);
        viewPager.setAdapter(customPagerAdapter);
    }
}
