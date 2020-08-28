package com.example.lt_day14.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lt_day14.MainActivity;
import com.example.lt_day14.R;

public class FirstFragment extends Fragment {
    private static FirstFragment INSTANCE;

    public static FirstFragment getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new FirstFragment();
        }
        return INSTANCE;
    }
    private String name;
    public FirstFragment() {
    }
    public FirstFragment(String name) {
        this.name = name;
    }
    public FirstFragment(int contentLayoutId, String name) {
        super(contentLayoutId);
        this.name = name;
    }
    private TextView tvFisrt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        tvFisrt = view.findViewById(R.id.tv_first);
        tvFisrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goi fragment second khi click textview
                ((MainActivity) getActivity()).showSecondFragment();//ep kieu
            }
        });
        return view;
    }
}
