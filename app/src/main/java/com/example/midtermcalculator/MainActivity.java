package com.example.midtermcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{


    private String displayString = "";
    boolean additionBool = false;
    boolean subtractionBool = false;
    boolean multiplicationBool = false;
    boolean divisionBool = false;
    boolean defaultDisplay = false;
    int decimalCount = 0;
    double value1 = 0.0;
    double value2 = 0.0;

    Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton,
    sevenButton, eightButton, nineButton, decimalButton, additionButton, subtractionButton,
    divisionButton, multiplicationButton, equalsButton, clearButton;

    TextView displayTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view references
        additionButton = findViewById(R.id.additionbutton);
        subtractionButton = findViewById(R.id.subtractionbutton);
        multiplicationButton = findViewById(R.id.multiplicationbutton);
        divisionButton = findViewById(R.id.divisionbutton);
        equalsButton = findViewById(R.id.equalsbutton);

        zeroButton = findViewById(R.id.zerobutton);
        oneButton = findViewById(R.id.onebutton);
        twoButton = findViewById(R.id.twobutton);
        threeButton = findViewById(R.id.threebutton);
        fourButton = findViewById(R.id.fourbutton);
        fiveButton = findViewById(R.id.fivebutton);
        sixButton = findViewById(R.id.sixbutton);
        sevenButton = findViewById(R.id.sevenbutton);
        eightButton = findViewById(R.id.eightbutton);
        nineButton = findViewById(R.id.ninebutton);
        decimalButton = findViewById(R.id.dotbutton);

        clearButton = findViewById(R.id.clearbutton);

        displayTV = findViewById(R.id.Display);

        // click listeners
        additionButton.setOnClickListener(this);
        subtractionButton.setOnClickListener(this);
        multiplicationButton.setOnClickListener(this);
        divisionButton.setOnClickListener(this);
        equalsButton.setOnClickListener(this);

        zeroButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        decimalButton.setOnClickListener(this);

        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.additionbutton)
        {
            if (displayString != "")
            {
                value1 = Double.parseDouble(displayString);
                displayString = "+";
                additionBool = true;
                subtractionBool = false;
                multiplicationBool = false;
                divisionBool = false;
            }
        }
        else if (view.getId() == R.id.subtractionbutton)
        {
            if (displayString != "")
            {
                value1 = Double.parseDouble(displayString);
                displayString = "\u2212";
                additionBool = false;
                subtractionBool = true;
                multiplicationBool = false;
                divisionBool = false;
            }
        }
        else if (view.getId() == R.id.multiplicationbutton)
        {
            if (displayString != "")
            {
                value1 = Double.parseDouble(displayString);
                displayString = "\u00D7";
                additionBool = false;
                subtractionBool = false;
                multiplicationBool = true;
                divisionBool = false;
            }
        }
        else if (view.getId() == R.id.divisionbutton)
        {
            if (displayString != "")
            {
                value1 = Double.parseDouble(displayString);
                displayString = "\u00F7";
                additionBool = false;
                subtractionBool = false;
                multiplicationBool = false;
                divisionBool = true;
            }
        }
        else if (view.getId() == R.id.equalsbutton)
        {
            value2 = Double.parseDouble(displayString);

            if (additionBool == true)
            {
                displayString = Double.toString(value1 + value2);
            }
            else if (subtractionBool == true)
            {
                displayString = Double.toString(value1 - value2);
            }
            else if (multiplicationBool == true)
            {
                displayString = Double.toString(value1 * value2);
            }
            else if (divisionBool == true)
            {
                displayString = Double.toString(value1 / value2);
            }
        }
        else if (view.getId() == R.id.clearbutton)
        {
            defaultDisplay = true;
            additionBool = false;
            subtractionBool = false;
            divisionBool = false;
            multiplicationBool = false;
            decimalCount = 0;
            displayString = "";
        }
        else if (view.getId() == R.id.dotbutton)
        {
            if (decimalCount <= 0)
            {
                displayString = displayString + ".";
                decimalCount++;
            }

        }
        else
        {
            if (displayString == "+" || displayString == "\u00D7" || displayString == "\u00F7" ||
                    displayString == "\u2212")
            {
                displayString = "";
            }

            if (view.getId() == R.id.onebutton)
            {
                displayString = displayString + "1";
            }
            else if (view.getId() == R.id.twobutton)
            {
                displayString = displayString + "2";
            }
            else if (view.getId() == R.id.threebutton)
            {
                displayString = displayString + "3";
            }
            else if (view.getId() == R.id.fourbutton)
            {
                displayString = displayString + "4";
            }
            else if (view.getId() == R.id.fivebutton)
            {
                displayString = displayString + "5";
            }
            else if (view.getId() == R.id.sixbutton)
            {
                displayString = displayString + "6";
            }
            else if (view.getId() == R.id.sevenbutton)
            {
                displayString = displayString + "7";
            }
            else if (view.getId() == R.id.eightbutton)
            {
                displayString = displayString + "8";
            }
            else if (view.getId() == R.id.ninebutton)
            {
                displayString = displayString + "9";
            }
            else
            {
                displayString = displayString + "0";
            }
        }
            defaultDisplay = updateScreen(defaultDisplay);
    }
    private boolean updateScreen(boolean defaultDisplay){
        if(defaultDisplay == true)
        {
            displayTV.setText(R.string.display);
        }
        else
        {
            displayTV.setText(displayString);
        }
        return false;
    }
}