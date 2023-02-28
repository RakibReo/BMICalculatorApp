package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bmicalculator.databinding.ActivityMainBinding;   //import all function from view binding function

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;                    //View binding Declaration


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //binding.calculateBtn.setOnClickListener(MainActivity.this);


        binding.calculateBtn.setOnClickListener(v -> {            //lamda funtion




            String heightStr=binding.heightedt.getText().toString();              //String Declaration
            String heighttStr=binding.heightedtt.getText().toString();
            String weightStr=binding.weightedt.getText().toString();


//type casting(String to double conversion)
            double height=Double.parseDouble(heightStr);     //For take feet input in String to double
            double heightt=Double.parseDouble(heighttStr);   //For take inch input in String to double
            double weight= Double.parseDouble(weightStr);     //For take kilogram input in String to double


           double x=Conversion_feet_to_meter(height)+Conversion_inch_to_meter(heightt);// Add height(feet+inch) before two are convert to meter

            double bmiResult=weight/(x*x);              //BMI Law

           // binding.resultTv.setText("Your BMI Score: "+bmiResult);    //Without formatting decimal

            binding.resultTv.setText("Your BMI Score: "+String.format("%.1f",bmiResult));  //formatting 1 dosomik number
                //This is also for output code



            //There are if condition bellow
            if(bmiResult<18.5){

                binding.resultTvv.setText("Underweight \n You eat more: \n Fish, Poultry and Meat \n etc. ");

            }
            if(bmiResult>=18.5){
                binding.resultTvv.setText("Normal \n You eat average: \n Fruit, Fish, Poultry and Meat \n etc. ");

            }

            if(bmiResult>=25){

                binding.resultTvv.setText("Overweight \n You eat less: \n Fish, Poultry and Meat \n etc. ");

            }

            if(bmiResult>=30){

                binding.resultTvv.setText("Obese \n You eat more: \n Fruit, Rice,Vegetable \n etc. ");

            }

            if(bmiResult>=30){

                binding.resultTvv.setText("Extremely Obese \n You eat more: \n Fruit, Muri,Vegetable \n etc.");

            }


        });
    }
    //This is conversion method then call from onCreate lamda function in main class
    static double Conversion_feet_to_meter(double feet){

        return feet*0.305;
    }

    static double Conversion_inch_to_meter(double inch){

        return inch*0.0254;
    }


}
