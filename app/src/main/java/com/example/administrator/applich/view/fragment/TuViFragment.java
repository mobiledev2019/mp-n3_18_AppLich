package com.example.administrator.applich.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.applich.R;
import com.example.administrator.applich.view.activity.MainActivity;

public class TuViFragment extends Fragment{
    TuViTronDoiFragment tuViTronDoiFragment;
    CungHoangDaoFragment cungHoangDaoFragment;
    LinearLayout lnTuViTronDoi;
    LinearLayout lnCungHoangDao;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_tuvi,container,false);
        initView();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        lnTuViTronDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity().getSupportFragmentManager().findFragmentByTag(TuViTronDoiFragment.class.getSimpleName())==null){
                    TuViTronDoiFragment tuViTronDoiFragment = new TuViTronDoiFragment();
                    ((MainActivity)getActivity()).addFragment(tuViTronDoiFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
        lnCungHoangDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity().getSupportFragmentManager().findFragmentByTag(CungHoangDaoFragment.class.getSimpleName())==null){
                    CungHoangDaoFragment cungHoangDaoFragment=new CungHoangDaoFragment();
                    ((MainActivity)getActivity()).addFragment(cungHoangDaoFragment,CungHoangDaoFragment.class.getSimpleName());
                }
            }
        });
    }

    private void initView() {
        cungHoangDaoFragment=new CungHoangDaoFragment();
        tuViTronDoiFragment=new TuViTronDoiFragment();
        lnTuViTronDoi=view.findViewById(R.id.ln_tuvitrondoi);
        lnCungHoangDao=view.findViewById(R.id.ln_cunghoangdao);
    }
}
