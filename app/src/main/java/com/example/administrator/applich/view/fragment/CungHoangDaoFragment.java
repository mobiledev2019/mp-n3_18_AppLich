package com.example.administrator.applich.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.applich.R;
import com.example.administrator.applich.view.activity.MainActivity;

public class CungHoangDaoFragment extends Fragment{
    public static String tieuDeToolbar;
    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment;
    LinearLayout lnBachDuong;
    LinearLayout lnKimNguu;
    LinearLayout lnSongTu;
    LinearLayout lnCuGiai;
    LinearLayout lnSuTu;
    LinearLayout lnXuNu;
    LinearLayout lnThienBinh;
    LinearLayout lnThienYet;
    LinearLayout lnNhanMa;
    LinearLayout lnMaKet;
    LinearLayout lnBaoBinh;
    LinearLayout lnSongNgu;
    View view;
    ImageView imgBack;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_cunghoangdao,container,false);
        initView();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        lnBachDuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Bạch Dương";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnKimNguu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Kim Ngưu";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnSongTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Song Tử";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnCuGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Cự Giải";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnSuTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Sư Tử";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnXuNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Xử Nữ";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnThienBinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Thiên Bình";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnThienYet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Thiên Yết";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnNhanMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Nhân Mã";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnMaKet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Ma Kết";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnBaoBinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Bảo Bình";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnSongNgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tieuDeToolbar="Song Ngư";
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoChiTietFragment.class.getSimpleName())==null){
                    CungHoangDaoChiTietFragment cungHoangDaoChiTietFragment = new CungHoangDaoChiTietFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoChiTietFragment,TuViTronDoiFragment.class.getSimpleName());
                }
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
        lnBachDuong=view.findViewById(R.id.ln_bachduong);
        lnKimNguu=view.findViewById(R.id.ln_kimnguu);
        lnSongTu=view.findViewById(R.id.ln_songtu);
        lnCuGiai=view.findViewById(R.id.ln_cugiai);
        lnSuTu=view.findViewById(R.id.ln_sutu);
        lnXuNu=view.findViewById(R.id.ln_xunu);
        lnThienBinh=view.findViewById(R.id.ln_thienbinh);
        lnThienYet=view.findViewById(R.id.ln_thienyet);
        lnNhanMa=view.findViewById(R.id.ln_nhanma);
        lnMaKet=view.findViewById(R.id.ln_maket);
        lnBaoBinh=view.findViewById(R.id.ln_baobinh);
        lnSongNgu=view.findViewById(R.id.ln_songngu);
        cungHoangDaoChiTietFragment =new CungHoangDaoChiTietFragment();
    }
}
