package com.example.administrator.applich.view.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.applich.R;
import com.example.administrator.applich.adapter.ViewPaperAdapter;

public class MainFragment extends Fragment{
    public static String tabSelected="";
    LinearLayout lnLichViet;
    LinearLayout lnChiaSe;
    LichNgayFragment lichNgayFragment;
    LichThangFragment lichThangFragment;
    DoiNgayFragment doiNgayFragment;
    TuViFragment tuViFragment;
    SuKienFragment suKienFragment;
    ViewPager viewPager;
    TabLayout tabLayout;
    DrawerLayout drawerLayout;
    ImageView imgDrawerLayout;
    View view;
    LinearLayout lnDanhGia;
    LinearLayout lnPhanHoi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_main,container,false);
        initView();
        setupViewPager();
        catchEvent();
        if(tabSelected.equals("")==false){
            if(tabSelected.equals("tabtuvi")){
                tabLayout.getTabAt(3).select();
                Log.d("kiemtratab","tabtuvi");
            }
        }
        return view;
    }
    private void setupViewPager() {
        ViewPaperAdapter adapter=new ViewPaperAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(lichNgayFragment);
        adapter.addFragment(lichThangFragment);
        adapter.addFragment(doiNgayFragment);
        adapter.addFragment(tuViFragment);
        adapter.addFragment(suKienFragment);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.lichngay_blue);
        tabLayout.getTabAt(1).setIcon(R.mipmap.lichthang_gray);
        tabLayout.getTabAt(2).setIcon(R.mipmap.doingay_gray);
        tabLayout.getTabAt(3).setIcon(R.mipmap.tuvi_gray);
        tabLayout.getTabAt(4).setIcon(R.mipmap.sukien_gray);
        tabLayout.getTabAt(0).setText("Lịch ngày");
        tabLayout.getTabAt(1).setText("Lịch tháng");
        tabLayout.getTabAt(2).setText("Đổi ngày");
        tabLayout.getTabAt(3).setText("Tử vi");
        tabLayout.getTabAt(4).setText("Sự kiện");
    }

    private void catchEvent() {
        imgDrawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        lnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                }
            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    tab.setIcon(R.mipmap.lichngay_blue);
                    tabLayout.getTabAt(1).setIcon(R.mipmap.lichthang_gray);
                    tabLayout.getTabAt(2).setIcon(R.mipmap.doingay_gray);
                    tabLayout.getTabAt(3).setIcon(R.mipmap.tuvi_gray);
                    tabLayout.getTabAt(4).setIcon(R.mipmap.sukien_gray);
                }
                else if(tab.getPosition()==1){
                    tab.setIcon(R.mipmap.lichthang_blue);
                    tabLayout.getTabAt(0).setIcon(R.mipmap.lichngay_gray);
                    tabLayout.getTabAt(2).setIcon(R.mipmap.doingay_gray);
                    tabLayout.getTabAt(3).setIcon(R.mipmap.tuvi_gray);
                    tabLayout.getTabAt(4).setIcon(R.mipmap.sukien_gray);
                }
                else if(tab.getPosition()==2){
                    tab.setIcon(R.mipmap.doingay_blue);
                    tabLayout.getTabAt(1).setIcon(R.mipmap.lichthang_gray);
                    tabLayout.getTabAt(0).setIcon(R.mipmap.lichngay_gray);
                    tabLayout.getTabAt(3).setIcon(R.mipmap.tuvi_gray);
                    tabLayout.getTabAt(4).setIcon(R.mipmap.sukien_gray);
                }
                else if(tab.getPosition()==3){
                    tab.setIcon(R.mipmap.tuvi_blue);
                    tabLayout.getTabAt(1).setIcon(R.mipmap.lichthang_gray);
                    tabLayout.getTabAt(2).setIcon(R.mipmap.doingay_gray);
                    tabLayout.getTabAt(0).setIcon(R.mipmap.lichngay_gray);
                    tabLayout.getTabAt(4).setIcon(R.mipmap.sukien_gray);
                }
                else if(tab.getPosition()==4){
                    tab.setIcon(R.mipmap.sukien_blue);
                    tabLayout.getTabAt(1).setIcon(R.mipmap.lichthang_gray);
                    tabLayout.getTabAt(2).setIcon(R.mipmap.doingay_gray);
                    tabLayout.getTabAt(3).setIcon(R.mipmap.tuvi_gray);
                    tabLayout.getTabAt(0).setIcon(R.mipmap.lichngay_gray);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        lnChiaSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBodyText = "";
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(intent, ""));
            }
        });
        lnLichViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                tabLayout.getTabAt(0).select();
            }
        });
        lnPhanHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{""});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Phản hồi email..."));
                } catch (android.content.ActivityNotFoundException ex) {
                }
            }
        });
    }

    private void initView() {
        lnPhanHoi=view.findViewById(R.id.ln_phanhoi);
        lnDanhGia=view.findViewById(R.id.ln_danhgia);
        lnLichViet=view.findViewById(R.id.ln_lichviet);
        lnChiaSe=view.findViewById(R.id.ln_chise);
        lichNgayFragment=new LichNgayFragment();
        lichThangFragment=new LichThangFragment();
        doiNgayFragment=new DoiNgayFragment();
        tuViFragment=new TuViFragment();
        suKienFragment=new SuKienFragment();
        viewPager=view.findViewById(R.id.viewpaper);
        tabLayout=view.findViewById(R.id.tablayout);
        imgDrawerLayout=view.findViewById(R.id.img_drawerlayout);
        drawerLayout=view.findViewById(R.id.drawerlayout);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getActivity().getMenuInflater().inflate(R.menu.share_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_item_share:
//
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                String shareBodyText = "Check it out. Your message goes here";
//                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
//                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
