package com.iamsm.myapplication;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private RealmResults<Student> mStudentRealmResults;
    private Context mContext;
    private int count;

    public MyAdapter(RealmResults<Student> students, Context context) {
        mStudentRealmResults = students;
        mContext = context;
        count = 0;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Student student=mStudentRealmResults.get(position);
        if(student.getDept().equals("CSE") || student.getDept().equals("Computer Science & Engineering"))
            holder.r1.setBackgroundColor(Color.parseColor("#00FF00"));
        else if(student.getDept().equals("IT") || student.getDept().equals("Information Technology"))
            holder.r1.setBackgroundColor(Color.parseColor("#0000FF"));
        else if(student.getDept().equals("EE") || student.getDept().equals("Electrical Engineering"))
            holder.r1.setBackgroundColor(Color.parseColor("#FF0000"));
        else if(student.getDept().equals("ECE") || student.getDept().equals("Electronics & Communication Engineering"))
            holder.r1.setBackgroundColor(Color.parseColor("#FFFF00"));
        else
            holder.r1.setBackgroundColor(Color.parseColor("#FF00FF"));
        holder.name.setText(student.getName());
        holder.dept.setText(student.getDept());
        holder.roll.setText("Roll No.:"+student.getRoll()+"");
        holder.phone.setText(student.getPhone());
        holder.gender.setText(student.getGender());

    }

    @Override
    public int getItemCount() {
        return mStudentRealmResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView dept;
        private TextView roll;
        private TextView phone;
        private TextView gender;
        private RelativeLayout r1;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            count++;
            name=itemView.findViewById(R.id.tv_Name);
            dept=itemView.findViewById(R.id.tv_Dept);
            roll=itemView.findViewById(R.id.tv_Roll);
            phone=itemView.findViewById(R.id.tv_Phone);
            gender=itemView.findViewById(R.id.tv_Gender);
            r1=itemView.findViewById(R.id.rootView);
        }
    }
}

