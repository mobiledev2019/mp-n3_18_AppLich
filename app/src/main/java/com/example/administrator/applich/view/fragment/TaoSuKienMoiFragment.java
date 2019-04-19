package com.example.administrator.applich.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.applich.R;

public class TaoSuKienMoiFragment extends Fragment{
    ImageView imgBack;
    LinearLayout lnSinhNhat;
    LinearLayout lnGiaDinh;
    LinearLayout lnCongViec;
    LinearLayout lnKyNiem;
    LinearLayout lnCaNhan;
    LinearLayout lnHenHo;
    LinearLayout lnViecHy;
    LinearLayout lnKhac;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_taosukienmoi,container,false);
        initView();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        lnSinhNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lnGiaDinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lnCongViec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lnKyNiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lnCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lnHenHo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lnViecHy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lnKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        lnSinhNhat=view.findViewById(R.id.ln_sinhnhat);
        lnGiaDinh=view.findViewById(R.id.ln_giadinh);
        lnCongViec=view.findViewById(R.id.ln_congviec);
        lnKyNiem=view.findViewById(R.id.ln_kyniem);
        lnCaNhan=view.findViewById(R.id.ln_canhan);
        lnHenHo=view.findViewById(R.id.ln_henho);
        lnViecHy=view.findViewById(R.id.ln_viechy);
        lnKhac=view.findViewById(R.id.ln_khac);
    }
}
