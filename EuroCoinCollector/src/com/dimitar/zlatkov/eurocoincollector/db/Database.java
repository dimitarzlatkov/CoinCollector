package com.dimitar.zlatkov.eurocoincollector.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dimitar.zlatkov.eurocoincollector.db.bean.Country;

public class Database {

	private static final String GET_COUNTRY_BY_CODE = "Select * from "
			+ DatabaseConstants.COUNTRIES_TABLE + " where "
			+ DatabaseConstants.COUNTRIES_CODE_COLUMN + "= ?";
	private static final String GET_ALL_COUNTRIES = "Select * from "
			+ DatabaseConstants.COUNTRIES_TABLE;

	private DatabaseHelper helper;
	private Context context;

	public Database(Context context) {
		this.context = context;
		helper = new DatabaseHelper(context);
	}

	public Country getCountryByCode(String contryCode) {
		SQLiteDatabase readableDatabase = helper.getReadableDatabase();

		String[] args = new String[1];
		args[0] = contryCode;

		Cursor cursor = readableDatabase.rawQuery(GET_COUNTRY_BY_CODE, args);
		cursor.moveToFirst();

		Country country = null;
		while (!cursor.isAfterLast()) {
			country = new Country();
			int id = cursor.getInt(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_ID_COLUMN));
			String code = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_CODE_COLUMN));
			String flag = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_FLAG_COLUMN));
			String name = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_NAME_COLUMN));
			country.setCountryCode(code);
			country.setId(id);
			country.setCountryName(name);
			country.setImageUrl(flag);

			cursor.moveToNext();
		}
		helper.close();
		return country;
	}

	public List<Country> getAllCountries() {
		List<Country> result = new ArrayList<Country>();
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor rawQuery = db.rawQuery(GET_ALL_COUNTRIES, null);
		rawQuery.moveToFirst();
		while (!rawQuery.isAfterLast()) {
			Country country = new Country();
			String name = rawQuery.getString(rawQuery
					.getColumnIndex(DatabaseConstants.COUNTRIES_NAME_COLUMN));
			String code = rawQuery.getString(rawQuery
					.getColumnIndex(DatabaseConstants.COUNTRIES_CODE_COLUMN));
			int id = rawQuery.getInt(rawQuery
					.getColumnIndex(DatabaseConstants.COUNTRIES_ID_COLUMN));
			String flag = rawQuery.getString(rawQuery
					.getColumnIndex(DatabaseConstants.COUNTRIES_FLAG_COLUMN));
			country.setCountryName(name);
			country.setCountryCode(code);
			country.setId(id);
			country.setImageUrl(flag);
			result.add(country);
			rawQuery.moveToNext();
		}

		return result;
	}
}
