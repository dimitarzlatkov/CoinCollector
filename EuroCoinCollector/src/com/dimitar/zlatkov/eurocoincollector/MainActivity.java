package com.dimitar.zlatkov.eurocoincollector;

import java.util.List;

import com.dimitar.zlatkov.eurocoincollector.db.Database;
import com.dimitar.zlatkov.eurocoincollector.db.DatabaseHelper;
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
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText text = (EditText) findViewById(R.id.text_field_id);
		Button button = (Button) findViewById(R.id.button_id);

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
