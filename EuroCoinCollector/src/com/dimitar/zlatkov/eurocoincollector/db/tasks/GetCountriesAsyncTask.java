package com.dimitar.zlatkov.eurocoincollector.db.tasks;

import java.util.List;

import com.dimitar.zlatkov.eurocoincollector.db.Database;
import com.dimitar.zlatkov.eurocoincollector.db.bean.Country;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class GetCountriesAsyncTask extends AsyncTask<Void, Void, List<Country>> {

	private ProgressDialog dialog;
	private Context context;
	private OnFinishListener listener;

	public GetCountriesAsyncTask(Context context, OnFinishListener listener) {
		dialog = new ProgressDialog(context);
		this.context = context;
		this.listener = listener;

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		dialog.show();
	}

	@Override
	protected List<Country> doInBackground(Void... params) {
		Database db = new Database(context);
		List<Country> countries = db.getAllCountries();
		return countries;
	}

	@Override
	protected void onPostExecute(List<Country> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		dialog.dismiss();
		listener.onFinished(result);
	}

	public interface OnFinishListener {
		public void onFinished(List<Country> countries);
	}
}
