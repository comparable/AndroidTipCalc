package com.julie.tipcal;
	import java.text.DecimalFormat;
	import android.os.Bundle;
	import android.app.Activity;
	import android.content.Context;
	import android.view.View;
	import android.view.inputmethod.InputMethodManager;
	import android.widget.EditText;
	import android.widget.TextView;
	import android.widget.Toast;	
	
	public class MainActivity extends Activity {
	
		public EditText etAmount;
		public TextView tvTip;
		public TextView tvTotal;
		private double rate = 0;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			etAmount = (EditText) findViewById(R.id.etAmount);
			tvTip = (TextView) findViewById(R.id.tvTip);
			tvTotal = (TextView) findViewById(R.id.tvTotal);
		}
		
		//when 10% button clicked
		public void onTen(View v){
			rate = 0.10;
			calc(rate);
			hideSoftKeyboard(v);
		}
		
		//when 15% button clicked
		public void onFifteen(View v){
			rate = 0.15;
			calc(rate);
			hideSoftKeyboard(v);
		}
			
		//when 20% button clicked
		public void onTwenty(View v){
			rate = 0.20;
			calc(rate);
			hideSoftKeyboard(v);
		}	
		
		//calculating tip 
		public void calc(double rate){		
			if(etAmount.getText().toString().isEmpty()){
		//If it's empty then Toast 
				Toast.makeText(this, "Please Enter Amount",Toast.LENGTH_SHORT).show();
			} else {	
			String input = etAmount.getText().toString();
			double amt = Double.parseDouble(input);
			double tip = amt * rate;
			double total = tip + amt;
			String tipAmount = new DecimalFormat("####0.00").format(tip);
			String totalAmount = new DecimalFormat("####0.00").format(total);
			tvTip.setText("$"+tipAmount);
			tvTotal.setText("$"+totalAmount);
			}
		}
		
		//Hide Keyboard after typing amount
		public void hideSoftKeyboard(View view){
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	
	}
