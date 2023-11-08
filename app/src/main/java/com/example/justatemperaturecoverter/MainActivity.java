package com.example.justatemperaturecoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.justatemperaturecoverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());

        binding.ctof.setOnClickListener(this);
        binding.ftoc.setOnClickListener(this);

    }

    public double getinput(EditText edt)
    {
        if(edt.getText().toString().equals("")) // if no input given
            return 0 ;
        else
            return Double.parseDouble(edt.getText().toString()) ; // return float value of input
    }

    @Override
    public void onClick(View view)
    {
        double temperature = getinput(binding.tempinput) ;
        int id = view.getId() ;
        double ans = 0.0f ;

        if(id == R.id.ctof) // celsius to fahrenheit
        {
            ans = (temperature * 9.0 / 5) + 32;
            binding.result.setText("Fahrenheit Temperature is " + (float)ans);
        }
        else if(id == R.id.ftoc)
        {
            ans = (temperature - 32) * 5.0/9 ;
            binding.result.setText("Celsius Temperature is " + (float)ans);
        }
    }
}