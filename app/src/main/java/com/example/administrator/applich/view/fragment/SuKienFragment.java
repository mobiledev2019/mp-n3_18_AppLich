package com.example.administrator.applich.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.applich.R;
import com.example.administrator.applich.view.activity.MainActivity;

public class SuKienFragment extends Fragment{
    ImageView imgThemSuKien;
    TaoSuKienMoiFragment taoSuKienMoiFragment;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_sukien,container,false);
        initView();
        catchEvent();
        return view;
    }

    private void catchEvent() {
        imgThemSuKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity().getSupportFragmentManager().findFragmentByTag(TaoSuKienMoiFragment.class.getSimpleName())==null){
                    TaoSuKienMoiFragment taoSuKienMoiFragment = new TaoSuKienMoiFragment();
                    ((MainActivity)getActivity()).addFragment(taoSuKienMoiFragment,TuViTronDoiFragment.class.getSimpleName());
                }
            }
        });
    }

    private void initView() {
        imgThemSuKien=view.findViewById(R.id.img_themsukien);
        taoSuKienMoiFragment=new TaoSuKienMoiFragment();
    }
}
