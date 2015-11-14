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
   
   public static final String COINS_ID_COLUMN = "_id";
   public static final String COINS_COUNTRY_CODE_COLUMN = "country_code";
   public static final String COINS_FACIAL_VALUE_COLUMN = "facial_value";
   public static final String COINS_VALUE_COLUMN = "value";
   public static final String COINS_IMAGE_COLUMN = "image";
   public static final String COINS_DESCRIPTION_COLUMN = "description";
   public static final String COINS_SHAPE_COLUMN = "shape";
   public static final String COINS_WEIGHT_COLUMN = "weight";
   public static final String COINS_DIAMETER_COLUMN = "diameter";
   public static final String COINS_THICKNESS_COLUMN = "thickness";
   public static final String COINS_COMMEMORATIVE_COLUMN = "commemorative";
   public static final String COINS_HAVE_IT_COLUMN = "have_it";
   public static final String COINS_CURRENCY_TYPE_COLUMN = "currency_type";
   public static final String COINS_MEMO_COLUMN = "memo";

}