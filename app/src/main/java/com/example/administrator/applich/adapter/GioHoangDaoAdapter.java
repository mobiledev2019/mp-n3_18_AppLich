package com.example.administrator.applich.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.applich.R;
import com.example.administrator.applich.data.GioHoangDao;

import java.util.List;

public class GioHoangDaoAdapter extends RecyclerView.Adapter<GioHoangDaoAdapter.GioHoangDaoViewHolder>{
    private List<GioHoangDao> gioHoangDaoList;
    private Activity activity;

    public GioHoangDaoAdapter(List<GioHoangDao> gioHoangDaoList, Activity activity) {
        this.gioHoangDaoList = gioHoangDaoList;
        this.activity = activity;
    }

    public class GioHoangDaoViewHolder extends  RecyclerView.ViewHolder {
        private TextView txtGioHoangDao;
        private TextView txtThoiGianGioHoangDao;
        private ImageView imgHinhAnh;

        public GioHoangDaoViewHolder(View itemView) {
            super(itemView);
            txtGioHoangDao =  itemView.findViewById(R.id.txt_giohoangdao);
            txtThoiGianGioHoangDao = itemView.findViewById(R.id.txt_thoigiangiohoangdao);
            imgHinhAnh =  itemView.findViewById(R.id.img_giohoangdao);
        }
    }

    @Override
    public GioHoangDaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** Get layout */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_giohoangdao,parent,false);
        return new GioHoangDaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GioHoangDaoViewHolder holder, int position) {
        /** Set Value*/
        GioHoangDao gioHoangDao = gioHoangDaoList.get(position);
        holder.txtGioHoangDao.setText(gioHoangDao.getGiohoangdao());
        holder.txtThoiGianGioHoangDao.setText(gioHoangDao.getThoigiangiohoangdao());
        holder.imgHinhAnh.setImageResource(gioHoangDao.getHinhanhgiohoangdao());
    }

    @Override
    public int getItemCount() {
        return gioHoangDaoList.size();
    }
}
