package com.example.administrator.applich.view.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.applich.R;
import com.example.administrator.applich.adapter.GioHoangDaoAdapter;
import com.example.administrator.applich.data.GioHoangDao;
import com.example.administrator.applich.data.Lunar;
import com.example.administrator.applich.data.Solar;
import com.example.administrator.applich.database.DatabaseHelper;
import com.example.administrator.applich.view.activity.MainActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiTietNgayCuaDoiNgayFragment extends Fragment{
    Map<Integer,String>map=new HashMap<>();
    TextView txtTietKhi;
    TextView txtHyThan;
    TextView txtTaiThan;
    TextView txtHacThan;
    List<GioHoangDao>listGioHoangDao;
    String canchingay;
    TextView txtKiemTraNgay;
    TextView txtMenhNgay;
    TextView txtMenhThang;
    ImageView imgBack;
    TextView txtMenhNam;
    String namSinhCanChi;
    String thangSinhCanChi;
    String ngaySinhCanChi;
    int can,chi;
    RecyclerView recyclerViewGioHoangDao;
    TextView txtCanChiGio;
    TextView txtCanChiThang;
    TextView txtCanChiNgay;
    int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    int n;
    int ngay,thang,nam;
    TextView txtThu;
    TextView txtNgayAmLich;
    TextView txtNgayDuongLich;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_chitietngaycuadoingay,container,false);
        initView();
        catchEvent();
        ganDuLieu();
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

    private void ganDuLieu() {
        ngay= DoiNgayFragment.solar.solarDay;
        thang= DoiNgayFragment.solar.solarMonth;
        nam=DoiNgayFragment.solar.solarYear;
        int cc,yy,c;
        cc=nam/100;
        yy = nam - ((nam/100)*100);
        c = (cc/4) - 2*cc-1;
        nam = 5*yy/4;
        thang = 26*(thang+1)/10;
        n = (c+nam+thang+ngay)%7;
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
        if(DoiNgayFragment.thangDuong!=""){
            ngay= Integer.parseInt(DoiNgayFragment.ngayDuong);
            thang= Integer.parseInt(DoiNgayFragment.thangDuong);
            nam= Integer.parseInt(DoiNgayFragment.namDuong);
            txtNgayDuongLich.setText(DoiNgayFragment.ngayDuong+" Tháng "+DoiNgayFragment.thangDuong+", "+DoiNgayFragment.namDuong);
            DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
            try {
                databaseHelper.createDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
            databaseHelper.openDataBase();
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
                        if(DoiNgayFragment.namDuong.equals(tam)){
                            namSinhCanChi=filed2;
                            txtNgayAmLich.setText(DoiNgayFragment.ngayAm+" Tháng "+DoiNgayFragment.thangAm+", "+filed2);
                            String t="";
                            for(int ha=0;ha<filed2.length();ha++){
                                if(filed2.charAt(ha)!=' '){
                                    t+=filed2.charAt(ha);
                                }
                                else{
                                    break;
                                }
                            }
                            taiThan(t);
                            hyThan(t);
                        }
                    }
                }
                cursorTuVi.moveToNext();
            }
        }
        else{
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            txtNgayDuongLich.setText(calendar.get(Calendar.DAY_OF_MONTH)+" Tháng "+(calendar.get(Calendar.MONTH)+1)+", "+calendar.get(Calendar.YEAR));
            Solar solar=new Solar();
            solar.solarDay= calendar.get(Calendar.DAY_OF_MONTH);
            solar.solarMonth= calendar.get(Calendar.MONTH)+1;
            solar.solarYear= calendar.get(Calendar.YEAR);
            MainActivity.LunarSolarConverter lunarSolarConverter= new MainActivity.LunarSolarConverter();
            Lunar lunar=lunarSolarConverter.SolarToLunar(solar);
            Log.d("kiemtrangayamcualua",lunar.lunarDay+"");
            String nam= String.valueOf(solar.solarYear);
            DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
            try {
                databaseHelper.createDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
            databaseHelper.openDataBase();
            Cursor cursorTuVi=databaseHelper.query("tbl_tuvi",null,null,null,null,null,null);
            cursorTuVi.moveToFirst();
            while (!cursorTuVi.isAfterLast()){
                Log.d("kkk","abc");
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
                        if(nam.equals(tam)){
                            namSinhCanChi=filed2;
                            txtNgayAmLich.setText(lunar.lunarDay+" Tháng "+lunar.lunarMonth+", "+filed2);
                            String t="";
                            for(int ha=0;ha<filed2.length();ha++){
                                if(filed2.charAt(ha)!=' '){
                                    t+=filed2.charAt(ha);
                                }
                                else{
                                    break;
                                }
                            }
                            taiThan(t);
                            hyThan(t);
                        }
                    }
                }
                cursorTuVi.moveToNext();
            }
        }
        String canchingay= MainActivity.GETLUNARDAYCANCHINAME(DoiNgayFragment.solar.solarDay,DoiNgayFragment.solar.solarMonth,DoiNgayFragment.solar.solarYear);
        txtCanChiNgay.setText("Ngày "+canchingay);
        this.canchingay=canchingay;
        String canchithang= MainActivity.GETLUNARMONTHCANCHINAME(DoiNgayFragment.lunar.lunarYear,DoiNgayFragment.lunar.lunarMonth);//truyen vao thang nam am lich
        txtCanChiThang.setText("Tháng "+canchithang);
        Calendar rightNow = Calendar.getInstance();
        int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY);
        if(currentHourIn24Format>1&&currentHourIn24Format<=3){
            txtCanChiGio.setText("Giờ "+"Sửu");
        }
        else if(currentHourIn24Format>3&&currentHourIn24Format<=5){
            txtCanChiGio.setText("Giờ "+"Dần");
        }
        else if(currentHourIn24Format>5&&currentHourIn24Format<=7){
            txtCanChiGio.setText("Giờ "+"Mão");
        }
        else if(currentHourIn24Format>7&&currentHourIn24Format<=9){
            txtCanChiGio.setText("Giờ "+"Thìn");
        }
        else if(currentHourIn24Format>9&&currentHourIn24Format<=11){
            txtCanChiGio.setText("Giờ "+"Tị");
        }
        else if(currentHourIn24Format>11&&currentHourIn24Format<=13){
            txtCanChiGio.setText("Giờ "+"Ngọ");
        }
        else if(currentHourIn24Format>13&&currentHourIn24Format<=15){
            txtCanChiGio.setText("Giờ "+"Mùi");
        }
        else if(currentHourIn24Format>15&&currentHourIn24Format<=17){
            txtCanChiGio.setText("Giờ "+"Thân");
        }
        else if(currentHourIn24Format>17&&currentHourIn24Format<=19){
            txtCanChiGio.setText("Giờ "+"Dậu");
        }
        else if(currentHourIn24Format>19&&currentHourIn24Format<=21){
            txtCanChiGio.setText("Giờ "+"Tuất");
        }
        else if(currentHourIn24Format>21&&currentHourIn24Format<=23){
            txtCanChiGio.setText("Giờ "+"Hợi");
        }
        else{
            txtCanChiGio.setText("Giờ "+"Tý");
        }
        Log.d("kiemtra",namSinhCanChi);
        if(namSinhCanChi!=null){
            int gan=0;
            String can="",chi="";
            for(int i=0;i<namSinhCanChi.length();i++){
                if(namSinhCanChi.charAt(i)!=' '){
                    can+=namSinhCanChi.charAt(i);
                }
                else{
                    gan=i;
                    break;
                }
            }
            for(int i=gan+1;i<namSinhCanChi.length();i++){
                chi+=namSinhCanChi.charAt(i);
            }
            Log.d("kiemtra",can+"  "+chi);
            if(can.equals("Giáp")||can.equals("Ất")){
                this.can=1;
            }
            if(can.equals("Bính")||can.equals("Đinh")){
                this.can=2;
            }
            if(can.equals("Mậu")||can.equals("Kỷ")){
                this.can=3;
            }
            if(can.equals("Canh")||can.equals("Tân")){
                this.can=4;
            }
            if(can.equals("Nhâm")||can.equals("Qúy")){
                this.can=5;
            }
            if(chi.equals("Tý")||chi.equals("Sửu")||chi.equals("Ngọ")||chi.equals("Mùi")){
                this.chi=0;
            }
            if(chi.equals("Dần")||chi.equals("Mão")||chi.equals("Thân")||chi.equals("Dậu")){
                this.chi=1;
            }
            if(chi.equals("Thìn")||chi.equals("Tỵ")||chi.equals("Tuất")||chi.equals("Hợi")){
                this.chi=2;
            }
            if(this.can+this.chi<=5){
                if(this.can+this.chi==1){
                    txtMenhNam.setText("Mệnh năm: Kim");
                }
                if(this.can+this.chi==2){
                    txtMenhNam.setText("Mệnh năm: Thủy");
                }
                if(this.can+this.chi==3){
                    Log.d("kiemtra","3");
                    txtMenhNam.setText("Mệnh năm: Hỏa");
                }
                if(this.can+this.chi==4){
                    txtMenhNam.setText("Mệnh năm: Thổ");
                }
                if(this.can+this.chi==5){
                    txtMenhNam.setText("Mệnh năm: Mộc");
                }
            }
            else{
                int t=this.can+this.chi-5;
                if(t==1){
                    txtMenhNam.setText("Mệnh năm: Kim");
                }
                if(t==2){
                    txtMenhNam.setText("Mệnh năm: Thủy");
                }
                if(t==3){
                    txtMenhNam.setText("Mệnh năm: Hỏa");
                }
                if(t==4){
                    txtMenhNam.setText("Mệnh năm: Thổ");
                }
                if(t==5){
                    txtMenhNam.setText("Mệnh năm: Mộc");
                }
            }
        }
        else{
            txtMenhNam.setText("Mệnh năm: Đang cập nhật");
        }
        String d=tinhMenh(canchingay);
        txtMenhNgay.setText("Mệnh ngày: "+d);
        String t=tinhMenh(canchithang);
        txtMenhThang.setText("Mệnh tháng: "+t);
        kiemTraNgayHoangDao(DoiNgayFragment.lunar.lunarMonth);
        int gan=0;
        for(int i=0;i<canchingay.length();i++){
            if(canchingay.charAt(i)==' '){
                gan=i;
                break;
            }
        }
        String ngay="";
        for(int i=gan+1;i<canchingay.length();i++){
            ngay+=canchingay.charAt(i);
        }
        kiemTraGioHoangDao(ngay);
        hacThan(canchingay);
        tinhTietKhi(DoiNgayFragment.solar.solarMonth,DoiNgayFragment.solar.solarDay);
    }

    private void tinhTietKhi(int solarMonth,int solarDay) {
        int so[]={0,106,121,204,219,305,321,405,420,506,521,606,621,707,723,807,823,908,923,1008,1023,1107,1122,1207,1222,1232};
        String tietkhiString[]={"Đông Chí","Tiểu Hàn","Đại Hàn","Lập Xuân","Vũ Thủy","Kinh Trập","Xuân Phân","Thanh Minh","Cốc Vũ","Lập Hạ","Tiểu Mãn","Mang Chủng","Hạ Chí","Tiểu Thử","Đại Thử","Lập Thu","Xử Thử","Bạch Lộ","Thu Phân","Hàn Lộ","Sương Giáng","Lập Đông","Tiểu Tuyết","Đại Tuyết","Đông Chí","Tiểu Hàn"};
        int mmdd=solarMonth * 100 + solarDay;
        for(int i=0;i<so.length;i++){
            if(mmdd<so[i]){
                txtTietKhi.setText(tietkhiString[i]+" - "+tietkhiString[i-1]);
                break;
            }
        }
    }

    private void kiemTraGioHoangDao(String ngay) {
        if(ngay.equals("Tý")||ngay.equals("Ngọ")){
            listGioHoangDao.add(new GioHoangDao("Tý","23h - 1h",R.mipmap.ti));
            listGioHoangDao.add(new GioHoangDao("Sửu","1h - 3h",R.mipmap.suu));
            listGioHoangDao.add(new GioHoangDao("Mão","5h - 7h",R.mipmap.mao));
            listGioHoangDao.add(new GioHoangDao("Ngọ","11h - 13h",R.mipmap.ngo));
            listGioHoangDao.add(new GioHoangDao("Thân","15h - 17h",R.mipmap.than));
            listGioHoangDao.add(new GioHoangDao("Dậu","17h - 19h",R.mipmap.dau));
        }
        if(ngay.equals("Sửu")||ngay.equals("Mùi")){
            listGioHoangDao.add(new GioHoangDao("Dần","3h - 5h",R.mipmap.dan));
            listGioHoangDao.add(new GioHoangDao("Mão","5h - 7h",R.mipmap.mao));
            listGioHoangDao.add(new GioHoangDao("Tỵ","9h - 11h",R.mipmap.ty));
            listGioHoangDao.add(new GioHoangDao("Thân","15h - 17h",R.mipmap.than));
            listGioHoangDao.add(new GioHoangDao("Tuất","19h - 21h",R.mipmap.tuat));
            listGioHoangDao.add(new GioHoangDao("Hợi","21h - 23h",R.mipmap.hoi));
        }
        if(ngay.equals("Dần")||ngay.equals("Thân")){
            listGioHoangDao.add(new GioHoangDao("Tý","23h - 1h",R.mipmap.ti));
            listGioHoangDao.add(new GioHoangDao("Sửu","1h - 3h",R.mipmap.suu));
            listGioHoangDao.add(new GioHoangDao("Thìn","7h - 9h",R.mipmap.thin));
            listGioHoangDao.add(new GioHoangDao("Tỵ","9h - 11h",R.mipmap.ty));
            listGioHoangDao.add(new GioHoangDao("Mùi","13h - 15h",R.mipmap.mui));
            listGioHoangDao.add(new GioHoangDao("Tuất","19h - 21h",R.mipmap.tuat));
        }
        if(ngay.equals("Mão")||ngay.equals("Dậu")){
            listGioHoangDao.add(new GioHoangDao("Tý","23h - 1h",R.mipmap.ti));
            listGioHoangDao.add(new GioHoangDao("Dần","3h - 5h",R.mipmap.dan));
            listGioHoangDao.add(new GioHoangDao("Mão","5h - 7h",R.mipmap.mao));
            listGioHoangDao.add(new GioHoangDao("Ngọ","11h - 13h",R.mipmap.ngo));
            listGioHoangDao.add(new GioHoangDao("Mùi","13h - 15h",R.mipmap.mui));
            listGioHoangDao.add(new GioHoangDao("Dậu","17h - 19h",R.mipmap.dau));
        }
        if(ngay.equals("Thìn")||ngay.equals("Tuất")){
            listGioHoangDao.add(new GioHoangDao("Dần","3h - 5h",R.mipmap.dan));
            listGioHoangDao.add(new GioHoangDao("Thìn","7h - 9h",R.mipmap.thin));
            listGioHoangDao.add(new GioHoangDao("Tỵ","9h - 11h",R.mipmap.ty));
            listGioHoangDao.add(new GioHoangDao("Thân","15h - 17h",R.mipmap.than));
            listGioHoangDao.add(new GioHoangDao("Dậu","17h - 19h",R.mipmap.dau));
            listGioHoangDao.add(new GioHoangDao("Hợi","21h - 23h",R.mipmap.hoi));
        }
        if(ngay.equals("Tỵ")||ngay.equals("Hợi")){
            listGioHoangDao.add(new GioHoangDao("Sửu","1h - 3h",R.mipmap.suu));
            listGioHoangDao.add(new GioHoangDao("Thìn","7h - 9h",R.mipmap.thin));
            listGioHoangDao.add(new GioHoangDao("Ngọ","11h - 13h",R.mipmap.ngo));
            listGioHoangDao.add(new GioHoangDao("Mùi","13h - 15h",R.mipmap.mui));
            listGioHoangDao.add(new GioHoangDao("Tuất","19h - 21h",R.mipmap.tuat));
            listGioHoangDao.add(new GioHoangDao("Hợi","21h - 23h",R.mipmap.hoi));
        }
        GioHoangDaoAdapter gioHoangDaoAdapter = new GioHoangDaoAdapter(listGioHoangDao,getActivity());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),3);
        recyclerViewGioHoangDao.setLayoutManager(gridLayoutManager);
        recyclerViewGioHoangDao.setAdapter(gioHoangDaoAdapter);

    }

    private void initView() {
        txtTietKhi=view.findViewById(R.id.txt_tietkhi);
        txtHacThan=view.findViewById(R.id.txt_hacthan);
        txtHyThan=view.findViewById(R.id.txt_hythan);
        txtTaiThan=view.findViewById(R.id.txt_taithan);
        listGioHoangDao=new ArrayList<>();
        txtKiemTraNgay=view.findViewById(R.id.txt_kiemtrangay);
        txtMenhNgay=view.findViewById(R.id.txt_menhngay);
        txtMenhThang=view.findViewById(R.id.txt_menhthang);
        imgBack=view.findViewById(R.id.img_back);
        txtMenhNam=view.findViewById(R.id.txt_menhnam);
        recyclerViewGioHoangDao=view.findViewById(R.id.recyclerview_giohoangdao);
        txtCanChiGio=view.findViewById(R.id.txt_canchigio);
        txtCanChiThang=view.findViewById(R.id.txt_canchithang);
        txtCanChiNgay=view.findViewById(R.id.txt_canchingay);
        txtThu=view.findViewById(R.id.txt_thu);
        txtNgayDuongLich=view.findViewById(R.id.txt_ngayduonglich);
        txtNgayAmLich=view.findViewById(R.id.txt_ngayamlich);
    }

    public void tinhTruc(int thang){

    }

    public void kiemTraNgayHoangDao(int thang){
        int gan=0;
        for(int i=0;i<canchingay.length();i++){
            if(canchingay.charAt(i)==' '){
                gan=i;
                break;
            }
        }
        String ngay="";
        for(int i=gan+1;i<canchingay.length();i++){
            ngay+=canchingay.charAt(i);
        }
        if(thang==1||thang==7){
            if(ngay.equals("Tý")||ngay.equals("Sửu")||ngay.equals("Tỵ")||ngay.equals("Mùi")){
                txtKiemTraNgay.setText("Ngày hoàng đạo");
            }
            if(ngay.equals("Ngọ")||ngay.equals("Mão")||ngay.equals("Hợi")||ngay.equals("Dậu")){
                txtKiemTraNgay.setText("Ngày hắc đạo");
            }
        }
        if(thang==2||thang==8){
            if(ngay.equals("Dần")||ngay.equals("Mão")||ngay.equals("Mùi")||ngay.equals("Dậu")){
                txtKiemTraNgay.setText("Ngày hoàng đạo");
            }
            if(ngay.equals("Thân")||ngay.equals("Tỵ")||ngay.equals("Sửu")||ngay.equals("Hợi")){
                txtKiemTraNgay.setText("Ngày hắc đạo");
            }
        }
        if(thang==3||thang==9){
            if(ngay.equals("Tuất")||ngay.equals("Mùi")||ngay.equals("Sửu")||ngay.equals("Hợi")){
                txtKiemTraNgay.setText("Ngày hắc đạo");
            }
            if(ngay.equals("Thìn")||ngay.equals("Tỵ")||ngay.equals("Dậu")||ngay.equals("Hợi")){
                txtKiemTraNgay.setText("Ngày hoàng đạo");
            }

        }
        if(thang==4||thang==10){
            if(ngay.equals("Ngọ")||ngay.equals("Mùi")||ngay.equals("Sửu")||ngay.equals("Dậu")){
                txtKiemTraNgay.setText("Ngày hoàng đạo");
            }
            if(ngay.equals("Tý")||ngay.equals("Dậu")||ngay.equals("Tỵ")||ngay.equals("Mão")){
                txtKiemTraNgay.setText("Ngày hắc đạo");
            }
        }
        if(thang==6||thang==12){
            if(ngay.equals("Tuất")||ngay.equals("Hợi")||ngay.equals("Mão")||ngay.equals("Tỵ")){
                txtKiemTraNgay.setText("Ngày hoàng đạo");
            }
            if(ngay.equals("Thìn")||ngay.equals("Sửu")||ngay.equals("Dậu")||ngay.equals("Mùi")){
                txtKiemTraNgay.setText("Ngày hắc đạo");
            }
        }
        if(thang==5||thang==11){
            if(ngay.equals("Thân")||ngay.equals("Dậu")||ngay.equals("Sửu")||ngay.equals("Mão")){
                txtKiemTraNgay.setText("Ngày hoàng đạo");
            }
            if(ngay.equals("Dần")||ngay.equals("Hợi")||ngay.equals("Mùi")||ngay.equals("Tỵ")){
                txtKiemTraNgay.setText("Ngày hắc đạo");
            }
        }
    }
    public String tinhMenh(String s){
        if(s!=null){
            int gan=0;
            String can="",chi="";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=' '){
                    can+=s.charAt(i);
                }
                else{
                    gan=i;
                    break;
                }
            }
            for(int i=gan+1;i<s.length();i++){
                chi+=s.charAt(i);
            }
            Log.d("kiemtra",can+"  "+chi);
            if(can.equals("Giáp")||can.equals("Ất")){
                this.can=1;
            }
            if(can.equals("Bính")||can.equals("Đinh")){
                this.can=2;
            }
            if(can.equals("Mậu")||can.equals("Kỷ")){
                this.can=3;
            }
            if(can.equals("Canh")||can.equals("Tân")){
                this.can=4;
            }
            if(can.equals("Nhâm")||can.equals("Qúy")){
                this.can=5;
            }
            if(chi.equals("Tý")||chi.equals("Sửu")||chi.equals("Ngọ")||chi.equals("Mùi")){
                this.chi=0;
            }
            if(chi.equals("Dần")||chi.equals("Mão")||chi.equals("Thân")||chi.equals("Dậu")){
                this.chi=1;
            }
            if(chi.equals("Thìn")||chi.equals("Tỵ")||chi.equals("Tuất")||chi.equals("Hợi")){
                this.chi=2;
            }
            if(this.can+this.chi<=5){
                if(this.can+this.chi==1){
                    return "Kim";
                }
                if(this.can+this.chi==2){
                    return "Thủy";
                }
                if(this.can+this.chi==3){
                    return "Hỏa";
                }
                if(this.can+this.chi==4){
                    return "Thổ";
                }
                if(this.can+this.chi==5){
                    return "Mộc";
                }
            }
            else{
                int t=this.can+this.chi-5;
                if(t==1){
                    return "Kim";
                }
                if(t==2){
                    return "Thủy";
                }
                if(t==3){
                    return "Hỏa";
                }
                if(t==4){
                    return "Thổ";
                }
                if(t==5){
                    return "Mổ";
                }
            }
        }
        else{
            return null;
        }
        return null;
    }

    public void taiThan(String can) {
        if(can.equals("Giáp")||can.equals("Kỷ")){
            txtTaiThan.setText("Đông Bắc");
        }
        if(can.equals("Ất")||can.equals("Canh")){
            txtTaiThan.setText("Tây Bắc");
        }
        if(can.equals("Bính")||can.equals("Tân")){
            txtTaiThan.setText("Tây Nam");
        }
        if(can.equals("Đinh")||can.equals("Nhâm")){
            txtTaiThan.setText("Chính Nam");
        }
    }

    public void hyThan(String can){
        if(can.equals("Giáp")||can.equals("Ất")){
            txtHyThan.setText("Đông Nam");
        }
        if(can.equals("Bính")||can.equals("Đinh")){
            txtHyThan.setText("Đông");
        }
        if(can.equals("Mậu")){
            txtHyThan.setText("Bắc");
        }
        if(can.equals("Kỷ")){
            txtHyThan.setText("Nam");
        }
        if(can.equals("Canh")||can.equals("Tân")){
            txtHyThan.setText("Tây Nam");
        }
        if(can.equals("Nhâm")){
            txtHyThan.setText("Tây");
        }
    }

    public void hacThan(String lunarDayName){
        if(lunarDayName.equals("Kỷ Dậu")||lunarDayName.equals("Canh Tuất")||lunarDayName.equals("Tân Hợi")||lunarDayName.equals("Nhâm Tý")||lunarDayName.equals("Qúy Sửu")||lunarDayName.equals("Giáp Dần")){
            txtHacThan.setText("Đông Bắc");
        }
        if(lunarDayName.equals("Ất Mão")||lunarDayName.equals("Bính Thìn")||lunarDayName.equals("Nhâm Tỵ")||lunarDayName.equals("Mậu Ngọ")||lunarDayName.equals("Kỷ Mùi")){
            txtHacThan.setText("Đông");
        }
        if(lunarDayName.equals("Canh Thân")||lunarDayName.equals("Tân Dậu")||lunarDayName.equals("Nhâm Tuất")||lunarDayName.equals("Qúy Hợi")||lunarDayName.equals("Giáp Tý")||lunarDayName.equals("Ất Sửu")){
            txtHacThan.setText("Đông Nam");
        }
        if(lunarDayName.equals("Bính Dần")||lunarDayName.equals("Đinh Mão")||lunarDayName.equals("Mậu Thìn")||lunarDayName.equals("Kỷ Tỵ")||lunarDayName.equals("Canh Ngọ")){
            txtHacThan.setText("Nam");
        }
        if(lunarDayName.equals("Tân Mùi")||lunarDayName.equals("Nhâm Thân")||lunarDayName.equals("Qúy Dậu")||lunarDayName.equals("Giáp Tuất")||lunarDayName.equals("Ất Hợi")||lunarDayName.equals("Bính Tý")){
            txtHacThan.setText("Tây Nam");
        }
        if(lunarDayName.equals("Đinh Sửu")||lunarDayName.equals("Mậu Dần")||lunarDayName.equals("Kỷ Mão")||lunarDayName.equals("Canh Thìn")||lunarDayName.equals("Tân Tỵ")){
            txtHacThan.setText("Tây");
        }
        if(lunarDayName.equals("Nhâm Ngọ")||lunarDayName.equals("Qúy Mùi")||lunarDayName.equals("Giáp Thân")||lunarDayName.equals("Ất Dậu")||lunarDayName.equals("Bính Tuất")||lunarDayName.equals("Đinh Hợi")){
            txtHacThan.setText("Tây Bắc");
        }
        if(lunarDayName.equals("Mậu Tý")||lunarDayName.equals("Kỷ Sửu")||lunarDayName.equals("Canh Dần")||lunarDayName.equals("Tân Mão")||lunarDayName.equals("Nhâm Thìn")){
            txtHacThan.setText("Bắc");
        }
    }
}
