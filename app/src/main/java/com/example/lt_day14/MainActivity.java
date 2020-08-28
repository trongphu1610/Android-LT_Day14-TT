package com.example.lt_day14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lt_day14.fragment.FirstFragment;
import com.example.lt_day14.fragment.SeconFragmnet;

public class MainActivity extends AppCompatActivity {
    private int backCount = 0;
    private long time = System.currentTimeMillis();//system.cureen lay thoi gian hien tai

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        fragmenttransition là một phiên giao dịch có thể làm nhiều việc cùng lúc
        transaction.add(R.id.fl_container, FirstFragment.getINSTANCE());//add firstfragment vào framelayout
        transaction.commit();
    }

    public void showSecondFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        fragmenttransition là một phiên giao dịch có thể làm nhiều việc cùng lúc
        transaction.replace(R.id.fl_container, new SeconFragmnet());//add SeconFragmnet vào framelayout
        transaction.addToBackStack(null);// khi thoát ra thì về từng fragment chứ k thoát ra
        transaction.commit();
    }

    public void onBackPressed() {
        long current = System.currentTimeMillis();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (current- time <3000){
            backCount = 0;
        }
        if (fragment instanceof SeconFragmnet) {
            backCount++;
            if (backCount < 2) {
                time = current;
                Toast.makeText(this, "Please don't exist! I'm doung something for you", Toast.LENGTH_SHORT).show();
                return;
            }else {
                super.onBackPressed();
            }
        }
        super.onBackPressed();

    }
}