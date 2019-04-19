package com.example.administrator.applich.view.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.applich.R;
import com.example.administrator.applich.view.activity.MainActivity;

import java.util.Calendar;

public class TuViTronDoiFragment extends Fragment{
    ImageView imgBack;
    public static String ngaySinh;
    public static int gioiTinh=1;
    KetQuaTuViTronDoiFragment ketQuaTuViTronDoiFragment;
    Button btnXemKetQua;
    View view;
    Button btnNam;
    Button btnNu;
    ImageView imgChonNgaySinh;
    public static TextView txtNgaySinh;
    Calendar c;
    DatePickerDialog dbd;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_tuvitrondoi,container,false);
        initView();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        btnNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh=1;
                btnNam.setBackgroundResource(R.drawable.radio_flat_selected);
                btnNu.setBackgroundResource(R.drawable.radio_flat_regular);
                btnNam.setTextColor(getResources().getColor(R.color.colorWhite));
                btnNu.setTextColor(getResources().getColor(R.color.colorUnChecked));
            }
        });
        btnNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh=0;
                btnNu.setBackgroundResource(R.drawable.radio_flat_selected);
                btnNam.setBackgroundResource(R.drawable.radio_flat_regular);
                btnNam.setTextColor(getResources().getColor(R.color.colorUnChecked));
                btnNu.setTextColor(getResources().getColor(R.color.colorWhite));
            }
        });
        btnXemKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity().getSupportFragmentManager().findFragmentByTag(KetQuaTuViTronDoiFragment.class.getSimpleName())==null){
                    KetQuaTuViTronDoiFragment ketQuaTuViTronDoiFragment = new KetQuaTuViTronDoiFragment();
                    ((MainActivity)getActivity()).addFragment(ketQuaTuViTronDoiFragment,KetQuaTuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        imgChonNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c=Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);
                dbd=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        if(mDay<10){
                            if(mMonth+1<10){
                                txtNgaySinh.setText("0"+mDay+"/"+"0"+(mMonth+1)+"/"+mYear);
                            }
                            else{
                                txtNgaySinh.setText("0"+mDay+"/"+(mMonth+1)+"/"+mYear);
                            }
                        }
                        else if(mDay>=10&&mMonth+1>=10){
                            txtNgaySinh.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
                        }
                        else if(mDay>=10&&mMonth+1<10){
                            txtNgaySinh.setText(mDay+"/0"+(mMonth+1)+"/"+mYear);
                        }
                        if(mMonth+1<10){
                            if(mDay<10){
                                txtNgaySinh.setText("0"+mDay+"/"+"0"+(mMonth+1)+"/"+mYear);
                            }
                            else{
                                txtNgaySinh.setText(mDay+"/"+"0"+(mMonth+1)+"/"+mYear);
                            }
                        }
                        else if(mMonth+1>=10&&mDay>=10){
                            txtNgaySinh.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
                        }
                        else if(mMonth+1>=10&&mDay<10){
                            txtNgaySinh.setText("0"+mDay+"/"+(mMonth+1)+"/"+mYear);
                        }
                        ngaySinh=txtNgaySinh.getText().toString();
                    }
                },day,month,year);
                dbd.show();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    private void initView() {
        imgBack=view.findViewById(R.id.img_back);
        txtNgaySinh=view.findViewById(R.id.txt_ngaysinh);
        ngaySinh=txtNgaySinh.getText().toString();
        imgChonNgaySinh=view.findViewById(R.id.img_chonngaysinh);
        ketQuaTuViTronDoiFragment=new KetQuaTuViTronDoiFragment();
        btnXemKetQua=view.findViewById(R.id.btn_xemketqua);
        btnNam=view.findViewById(R.id.btn_nam);
        btnNu=view.findViewById(R.id.btn_nu);
        btnNam.setBackgroundResource(R.drawable.radio_flat_selected);
        btnNam.setTextColor(getResources().getColor(R.color.colorWhite));
        btnNu.setTextColor(getResources().getColor(R.color.colorUnChecked));
    }
}
