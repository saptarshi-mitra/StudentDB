package com.iamsm.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            count++;
            name=itemView.findViewById(R.id.tv_Name);
            dept=itemView.findViewById(R.id.tv_Dept);
            roll=itemView.findViewById(R.id.tv_Roll);
            phone=itemView.findViewById(R.id.tv_Phone);
            gender=itemView.findViewById(R.id.tv_Gender);
        }
    }
}

