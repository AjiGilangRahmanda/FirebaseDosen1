package com.example.firebasedosen1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.DosenViewHolder> {

    private ArrayList<Dosen> dosenList;
    private Context context;

    public DosenAdapter(Context context) {
        this.dosenList = new ArrayList<>();
        this.context = context;
    }

    public void setDosenList(ArrayList<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DosenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dosen, parent, false);
        return new DosenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DosenViewHolder holder, int position) {
        Dosen dosen = dosenList.get(position);
        holder.tvNik.setText("NIK: " + dosen.getNik());
        holder.tvNamaDosen.setText("Nama Dosen: " + dosen.getNama());
        holder.tvJabatanAkademik.setText("Jabatan Akademik: " + dosen.getJa());
    }

    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public class DosenViewHolder extends RecyclerView.ViewHolder {

        TextView tvNik, tvNamaDosen, tvJabatanAkademik;

        public DosenViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNik = itemView.findViewById(R.id.tv_nik);
            tvNamaDosen = itemView.findViewById(R.id.tv_nama_dosen);
            tvJabatanAkademik = itemView.findViewById(R.id.tv_jabatan_akademik);
        }
    }
}
