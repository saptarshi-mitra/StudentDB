package com.iamsm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private EditText name,dept,phone,roll;
    private Switch s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        name=findViewById(R.id.mName);
        dept=findViewById(R.id.mDept);
        phone=findViewById(R.id.mPhone);
        roll=findViewById(R.id.mRoll);
        s=findViewById(R.id.switch1);

    }

    public void onSavePressed(View v)
    {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try{
            Student student=realm.createObject(Student.class,System.currentTimeMillis()/1000);
            student.setName(name.getText().toString());
            student.setDept(dept.getText().toString());
            student.setRoll(Integer.parseInt(roll.getText().toString()));
            student.setPhone(phone.getText().toString());
            if(s.isChecked())
                student.setGender("Female");
            else
                student.setGender("Male");
            realm.commitTransaction();
            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            realm.cancelTransaction();
            Toast.makeText(mContext, "Failure" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public  void onDisplayPressed(View v)
    {
        Intent intent = new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }
}
