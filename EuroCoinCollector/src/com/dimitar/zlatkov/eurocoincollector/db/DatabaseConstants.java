package com.dimitar.zlatkov.eurocoincollector.db;

/**
 * A class containing all database-related constants.
 *
 * @author dimitar.zlatkov
 */
public class DatabaseConstants {
    public static final String LOG_TAG = "Database";

    public static final String DATABASE_NAME = "eurocoincollector_database";

    // Table names
   public static final String COUNTRIES_TABLE = "countries";
   public static final String COINS_TABLE = "coins";

    // Column names
   public static final String COUNTRIES_ID_COLUMN = "_id";
   public static final String COUNTRIES_CODE_COLUMN = "code";
   public static final String COUNTRIES_NAME_COLUMN = "country_name";
   public static final String COUNTRIES_FLAG_COLUMN = "country_flag";

}