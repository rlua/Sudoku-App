package com.example.myfirstapp;

//import java.util.ArrayList;
//import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    
    static final int SpinnerIds[][]=
    	{
    	{R.id.Spinner00,R.id.Spinner01,R.id.Spinner02,R.id.Spinner03,R.id.Spinner04,R.id.Spinner05,R.id.Spinner06,R.id.Spinner07,R.id.Spinner08,},
    	{R.id.Spinner10,R.id.Spinner11,R.id.Spinner12,R.id.Spinner13,R.id.Spinner14,R.id.Spinner15,R.id.Spinner16,R.id.Spinner17,R.id.Spinner18,},
    	{R.id.Spinner20,R.id.Spinner21,R.id.Spinner22,R.id.Spinner23,R.id.Spinner24,R.id.Spinner25,R.id.Spinner26,R.id.Spinner27,R.id.Spinner28,},
    	{R.id.Spinner30,R.id.Spinner31,R.id.Spinner32,R.id.Spinner33,R.id.Spinner34,R.id.Spinner35,R.id.Spinner36,R.id.Spinner37,R.id.Spinner38,},
    	{R.id.Spinner40,R.id.Spinner41,R.id.Spinner42,R.id.Spinner43,R.id.Spinner44,R.id.Spinner45,R.id.Spinner46,R.id.Spinner47,R.id.Spinner48,},
    	{R.id.Spinner50,R.id.Spinner51,R.id.Spinner52,R.id.Spinner53,R.id.Spinner54,R.id.Spinner55,R.id.Spinner56,R.id.Spinner57,R.id.Spinner58,},
    	{R.id.Spinner60,R.id.Spinner61,R.id.Spinner62,R.id.Spinner63,R.id.Spinner64,R.id.Spinner65,R.id.Spinner66,R.id.Spinner67,R.id.Spinner68,},
    	{R.id.Spinner70,R.id.Spinner71,R.id.Spinner72,R.id.Spinner73,R.id.Spinner74,R.id.Spinner75,R.id.Spinner76,R.id.Spinner77,R.id.Spinner78,},
    	{R.id.Spinner80,R.id.Spinner81,R.id.Spinner82,R.id.Spinner83,R.id.Spinner84,R.id.Spinner85,R.id.Spinner86,R.id.Spinner87,R.id.Spinner88,},
    	};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
 
    	
        for(int i=0; i<9; i++)
        {
        	for(int j=0;j<9;j++)
        	{
        		Spinner spinner = (Spinner) findViewById(SpinnerIds[i][j]);
/*
        	switch(i)
        	{
        	case 0: spinner = (Spinner) findViewById(R.id.Spinner00); break;
        	case 1: spinner = (Spinner) findViewById(R.id.Spinner01); break;
        	case 2: spinner = (Spinner) findViewById(R.id.Spinner02); break;
        	case 3: spinner = (Spinner) findViewById(R.id.Spinner03); break;
        	case 4: spinner = (Spinner) findViewById(R.id.Spinner04); break;
        	case 5: spinner = (Spinner) findViewById(R.id.Spinner05); break;
        	case 6: spinner = (Spinner) findViewById(R.id.Spinner06); break;
        	case 7: spinner = (Spinner) findViewById(R.id.Spinner07); break;
        	default: spinner = (Spinner) findViewById(R.id.Spinner08);
        	}
*/      

        		// Create an ArrayAdapter using the string array and a default spinner layout
        		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        		R.array.digits1to9, android.R.layout.simple_spinner_item);
        /*List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        */
        		// Specify the layout to use when the list of choices appears
        		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        		// Apply the adapter to the spinner
        		spinner.setAdapter(adapter);
        	}
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    	/*
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        */
    	
    	int values[][]=new int[9][9];
    	for(int i=0;i<9;i++)
    	{
    		for(int j=0;j<9;j++)
    		{
    			Spinner sp = (Spinner) findViewById(SpinnerIds[i][j]);
    			//System.out.println(sp.getSelectedItem().toString());
    			values[i][j]=sp.getSelectedItemPosition();
    		}
    	}
    	
    	SudokuSolver ss=new SudokuSolver();
    	//ss.initmatrix(values);
    	ss.Solve(values);
    	
    	for(int i=0;i<9;i++)
    	{
    		for(int j=0;j<9;j++)
    		{
    			Spinner sp = (Spinner) findViewById(SpinnerIds[i][j]);
    			sp.setSelection(ss.getCellValue(i, j));
    		}
    	}
    }
    
    public void clearCells(View view) {
        // Do something in response to button
    	for(int i=0;i<9;i++)
    	{
    		for(int j=0;j<9;j++)
    		{
    			Spinner sp = (Spinner) findViewById(SpinnerIds[i][j]);
    			sp.setSelection(0);
    		}
    	}
    }
}
