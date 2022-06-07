package com.gzeinnumer.b5d2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.gzeinnumer.b5d2.databinding.ActivityFragmentExampleBinding;

public class FragmentExampleActivity extends AppCompatActivity {
    private ActivityFragmentExampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentExampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("FragmentExampleActivity");

        initFirstFragment();

        binding.btnChangeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new NotBlankFragment();
                fragmentTransaction.replace(R.id.fr, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void initFirstFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new BlankFragment();
        fragmentTransaction.replace(R.id.fr, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}