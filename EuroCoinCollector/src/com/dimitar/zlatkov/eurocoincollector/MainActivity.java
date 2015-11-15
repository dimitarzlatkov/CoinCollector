package com.dimitar.zlatkov.eurocoincollector;

import java.util.List;

import com.dimitar.zlatkov.eurocoincollector.db.Database;
import com.dimitar.zlatkov.eurocoincollector.db.DatabaseHelper;
import com.dimitar.zlatkov.eurocoincollector.db.bean.Coin;
import com.dimitar.zlatkov.eurocoincollector.db.bean.Country;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText text = (EditText) findViewById(R.id.text_field_id);
		Button button = (Button) findViewById(R.id.button_id);
		
		
		Database db1 = new Database(MainActivity.this);
		Country con = db1.getCountryByCode("DE");
		text.setText(con.getCountryName());
		
		List<Country> allCountries1 = db1.getAllCountries();
		final TextView text1 = (TextView) findViewById(R.id.text_field_id1);
		
		text1.setText("Country: "+ "\n");
		for (int i=0;i<allCountries1.size();i++){
			text1.append(i +" "+allCountries1.get(i).getCountryCode() +" "+allCountries1.get(i).getCountryName()+"\n");
		}
		
		List<Coin> coins = db1.getCoinsByCountry("DE");
		final TextView text2 = (TextView) findViewById(R.id.text_field_id2);
		text2.setText("Coins"+"\n");
		
		for (int i=0;i<coins.size();i++){
			text2.append(i +" "+coins.get(i).getFacialValue() +" "+coins.get(i).getCurrencyType()+"\n");
		}
		
//		List<Coin> Ccoins = db1.getCommemorativeCoinsByCountry("ES");
//		final TextView text3 = (TextView) findViewById(R.id.text_field_id3);
//		text3.setText("Commemorative Coins"+"\n");
//		
//		for (int i=0;i<Ccoins.size();i++){
//			text3.append(i +" "+Ccoins.get(i).getDescription() +"\n");
//		}
		
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Database db = new Database(MainActivity.this);
				List<Country> allCountries = db.getAllCountries();
				Toast.makeText(MainActivity.this,
						allCountries.size()+"", Toast.LENGTH_LONG)
						.show();
				
			}
		});

		DatabaseHelper db = new DatabaseHelper(this);
		SQLiteDatabase readableDatabase = db.getReadableDatabase();
		Cursor rawQuery = readableDatabase.rawQuery("Select * from countries",
				null);
		rawQuery.moveToFirst();

	}

}
