package com.dimitar.zlatkov.eurocoincollector.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dimitar.zlatkov.eurocoincollector.db.bean.Coin;
import com.dimitar.zlatkov.eurocoincollector.db.bean.Country;

public class Database {

	private static final String GET_COUNTRY_BY_CODE = "Select * from "
			+ DatabaseConstants.COUNTRIES_TABLE + " where "
			+ DatabaseConstants.COUNTRIES_CODE_COLUMN + "= ?";
	private static final String GET_ALL_COUNTRIES = "Select * from "
			+ DatabaseConstants.COUNTRIES_TABLE;
	private static final String GET_COINS_BY_COUNTRY = "Select * from "
			+ DatabaseConstants.COINS_TABLE + " where "
			+ DatabaseConstants.COINS_COUNTRY_CODE_COLUMN + "=?";
	private static final String GET_COMMEMORATIVE_COINS_BY_COUNTRY = "Select * from "
			+ DatabaseConstants.COINS_TABLE
			+ " where "
			+ DatabaseConstants.COINS_COMMEMORATIVE_COLUMN
			+ " = ? and "
			+ DatabaseConstants.COINS_COUNTRY_CODE_COLUMN + "=?";

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
		Cursor cursor = db.rawQuery(GET_ALL_COUNTRIES, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Country country = new Country();
			String name = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_NAME_COLUMN));
			String code = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_CODE_COLUMN));
			int id = cursor.getInt(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_ID_COLUMN));
			String flag = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COUNTRIES_FLAG_COLUMN));
			country.setCountryName(name);
			country.setCountryCode(code);
			country.setId(id);
			country.setImageUrl(flag);
			result.add(country);

			cursor.moveToNext();
		}
		helper.close();
		return result;
	}

	public List<Coin> getCoinsByCountry(String contryCode) {
		List<Coin> result = new ArrayList<Coin>();
		SQLiteDatabase db = helper.getReadableDatabase();
		Country country = getCountryByCode(contryCode);
		String[] args = new String[1];
		args[0] = contryCode;

		Cursor cursor = db.rawQuery(GET_COINS_BY_COUNTRY, args);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Coin coin = new Coin();

			int id = cursor.getInt(cursor
					.getColumnIndex(DatabaseConstants.COINS_ID_COLUMN));
			int facial_value = cursor
					.getInt(cursor
							.getColumnIndex(DatabaseConstants.COINS_FACIAL_VALUE_COLUMN));
			double value = cursor.getDouble(cursor
					.getColumnIndex(DatabaseConstants.COINS_VALUE_COLUMN));
			String image = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_IMAGE_COLUMN));
			String description = cursor
					.getString(cursor
							.getColumnIndex(DatabaseConstants.COINS_DESCRIPTION_COLUMN));
			String shape = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_SHAPE_COLUMN));
			double weight = cursor.getDouble(cursor
					.getColumnIndex(DatabaseConstants.COINS_WEIGHT_COLUMN));
			double diameter = cursor.getDouble(cursor
					.getColumnIndex(DatabaseConstants.COINS_DIAMETER_COLUMN));
			String thickness = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_THICKNESS_COLUMN));
			boolean commemorative = cursor
					.getInt(cursor
							.getColumnIndex(DatabaseConstants.COINS_COMMEMORATIVE_COLUMN))>0;
			boolean have_it = cursor.getInt(cursor
					.getColumnIndex(DatabaseConstants.COINS_HAVE_IT_COLUMN))>0;
			String currency_type = cursor
					.getString(cursor
							.getColumnIndex(DatabaseConstants.COINS_CURRENCY_TYPE_COLUMN));
			String memo = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_MEMO_COLUMN));

			coin.setId(id);
			coin.setCountry(country);
			coin.setFacialValue(facial_value);
			coin.setCoinValue(value);
			coin.setImageUrl(image);
			coin.setDescription(description);
			coin.setShape(shape);
			coin.setWeight(weight);
			coin.setDiameter(diameter);
			coin.setThickness(thickness);
			coin.setCommemorative(commemorative);
			coin.setHaveIt(have_it);
			coin.setCurrencyType(currency_type);
			coin.setMemo(memo);

			result.add(coin);

			cursor.moveToNext();
		}
		helper.close();
		return result;
	}

	public List<Coin> getCommemorativeCoinsByCountry(String contryCode, boolean isCommemorative) {
		List<Coin> result = new ArrayList<Coin>();
		SQLiteDatabase db = helper.getReadableDatabase();
		Country country = getCountryByCode(contryCode);
		
		String[] args = new String[2];
		args[0] = isCommemorative+"";
		args[1] = contryCode;

		Cursor cursor = db.rawQuery(GET_COMMEMORATIVE_COINS_BY_COUNTRY, args);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Coin coin = new Coin();

			int id = cursor.getInt(cursor
					.getColumnIndex(DatabaseConstants.COINS_ID_COLUMN));
			int facial_value = cursor
					.getInt(cursor
							.getColumnIndex(DatabaseConstants.COINS_FACIAL_VALUE_COLUMN));
			double value = cursor.getDouble(cursor
					.getColumnIndex(DatabaseConstants.COINS_VALUE_COLUMN));
			String image = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_IMAGE_COLUMN));
			String description = cursor
					.getString(cursor
							.getColumnIndex(DatabaseConstants.COINS_DESCRIPTION_COLUMN));
			String shape = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_SHAPE_COLUMN));
			double weight = cursor.getDouble(cursor
					.getColumnIndex(DatabaseConstants.COINS_WEIGHT_COLUMN));
			double diameter = cursor.getDouble(cursor
					.getColumnIndex(DatabaseConstants.COINS_DIAMETER_COLUMN));
			String thickness = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_THICKNESS_COLUMN));
			boolean commemorative = cursor
					.getInt(cursor
							.getColumnIndex(DatabaseConstants.COINS_COMMEMORATIVE_COLUMN))>0;
			boolean have_it = cursor.getInt(cursor
					.getColumnIndex(DatabaseConstants.COINS_HAVE_IT_COLUMN))>0;
			String currency_type = cursor
					.getString(cursor
							.getColumnIndex(DatabaseConstants.COINS_CURRENCY_TYPE_COLUMN));
			String memo = cursor.getString(cursor
					.getColumnIndex(DatabaseConstants.COINS_MEMO_COLUMN));

			coin.setId(id);
			coin.setCountry(country);
			coin.setFacialValue(facial_value);
			coin.setCoinValue(value);
			coin.setImageUrl(image);
			coin.setDescription(description);
			coin.setShape(shape);
			coin.setWeight(weight);
			coin.setDiameter(diameter);
			coin.setThickness(thickness);
			coin.setCommemorative(commemorative);
			coin.setHaveIt(have_it);
			coin.setCurrencyType(currency_type);
			coin.setMemo(memo);

			result.add(coin);

			cursor.moveToNext();
		}
		helper.close();
		return result;
	}

}
