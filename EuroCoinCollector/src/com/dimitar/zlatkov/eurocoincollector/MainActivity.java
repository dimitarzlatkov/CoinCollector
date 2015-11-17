package com.dimitar.zlatkov.eurocoincollector;

import java.util.List;

import com.dimitar.zlatkov.eurocoincollector.db.Database;
import com.dimitar.zlatkov.eurocoincollector.db.DatabaseHelper;
import com.dimitar.zlatkov.eurocoincollector.db.bean.Coin;
import com.dimitar.zlatkov.eurocoincollector.db.bean.Country;
import com.dimitar.zlatkov.eurocoincollector.db.tasks.GetCountriesAsyncTask;
import com.dimitar.zlatkov.eurocoincollector.db.tasks.GetCountriesAsyncTask.OnFinishListener;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.list_view_id);
		GetCountriesAsyncTask task = new GetCountriesAsyncTask(this,
				new GetAllCountresListener());
		task.execute();

	}

	private class GetAllCountresListener implements OnFinishListener {

		@Override
		public void onFinished(List<Country> countries) {
			CountriesAdapter adapter = new CountriesAdapter(MainActivity.this,
					countries);
			listView.setAdapter(adapter);

		}

	}
}
