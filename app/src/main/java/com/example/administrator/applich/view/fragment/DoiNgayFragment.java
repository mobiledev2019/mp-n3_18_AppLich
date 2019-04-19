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
import android.widget.Button;
import android.widget.DatePicker;

import com.example.administrator.applich.R;
import com.example.administrator.applich.data.Lunar;
import com.example.administrator.applich.data.Solar;
import com.example.administrator.applich.view.activity.MainActivity;

import java.util.Calendar;

public class DoiNgayFragment extends Fragment{
    public static Solar solar;
    public static Lunar lunar;
    public static String ngayDuong="",thangDuong="",namDuong="";
    public static String ngayAm="",thangAm="",namAm="";
    Button btnXemChiTietNgay;
    DatePicker datePickerDuongLich;
    DatePicker datePickerAmLich;
    ChiTietNgayCuaDoiNgayFragment chiTietNgayCuaDoiNgayFragment;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_doingay,container,false);
        initView();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        solar.solarDay= calendar.get(Calendar.DAY_OF_MONTH);
        solar.solarMonth= calendar.get(Calendar.MONTH)+1;
        Log.d("kiemtrasolar",solar.solarMonth+"");
        solar.solarYear= calendar.get(Calendar.YEAR);
        MainActivity.LunarSolarConverter lunarSolarConverter= new MainActivity.LunarSolarConverter();
        lunar=lunarSolarConverter.SolarToLunar(solar);
        Log.d("kiemtraamlich",lunar.lunarDay+"  "+lunar.lunarMonth+"  "+lunar.lunarYear);
        datePickerAmLich.init(lunar.lunarYear,lunar.lunarMonth-1,lunar.lunarDay,null);
        datePickerDuongLich.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                solar.solarDay= dayOfMonth;
                solar.solarMonth= month+1;
                solar.solarYear= year;
                ngayDuong= String.valueOf(solar.solarDay);
                thangDuong= String.valueOf(solar.solarMonth);
                namDuong= String.valueOf(solar.solarYear);
                Log.d("kiemtrathoigian",solar.solarDay+"  "+solar.solarMonth+"  "+solar.solarYear);
                MainActivity.LunarSolarConverter lunarSolarConverter= new MainActivity.LunarSolarConverter();
                lunar=lunarSolarConverter.SolarToLunar(solar);
                Log.d("kiemtraamlich",lunar.lunarDay+"  "+lunar.lunarMonth+"  "+lunar.lunarYear);
                ngayAm= String.valueOf(lunar.lunarDay);
                thangAm= String.valueOf(lunar.lunarMonth);
                namAm= String.valueOf(lunar.lunarYear);
                datePickerAmLich.init(lunar.lunarYear,lunar.lunarMonth-1,lunar.lunarDay,null);
            }
        });
        btnXemChiTietNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity().getSupportFragmentManager().findFragmentByTag(ChiTietNgayCuaDoiNgayFragment.class.getSimpleName())==null){
                    ChiTietNgayCuaDoiNgayFragment chiTietNgayCuaDoiNgayFragment = new ChiTietNgayCuaDoiNgayFragment();
                    ((MainActivity)getActivity()).addFragment(chiTietNgayCuaDoiNgayFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
    }

    private void initView() {
        solar=new Solar();
        chiTietNgayCuaDoiNgayFragment =new ChiTietNgayCuaDoiNgayFragment();
        datePickerDuongLich=view.findViewById(R.id.datepicker_duonglich);
        datePickerAmLich=view.findViewById(R.id.datepicker_amlich);
        btnXemChiTietNgay=view.findViewById(R.id.btn_xemchitietngay);
    }
}
