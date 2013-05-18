package com.calculadora;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText result=null;
	Double temp=new Double(0);
	Integer ope=new Integer(-1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		result = (EditText)findViewById(R.id.result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 public void click_num(View view) {
	    Button b=(Button)view;
	    String tmp=result.getText().toString()+b.getText().toString();
	    result.setText(tmp);	    
	 }
	 public void click_op(View view) {
	    Button b=(Button)view;
	    this.temp=Double.parseDouble(result.getText().toString());
	    String signo=b.getText().toString();
	   
	    if(signo.equals("+"))ope=0;
	    else if(signo.equals("-"))ope=1;
	    else if(signo.equals("*"))ope=2;
	    else if(signo.equals("/"))ope=3;
	    
	    result.setText("");
	   
	 }

	public void click_igual(View view) {
		 if(this.ope!=-1){
			 Double r=Double.parseDouble(result.getText().toString());
			 switch(ope){
			 	case  0: r=temp+r;break;
			 	case  1: r=temp-r;break;
			 	case  2: r=temp*r;break;
			 	case  3: r=temp/r;
			 }
		 result.setText(r.toString());
		 }
	 }
}
