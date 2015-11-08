package com.dimitar.zlatkov.eurocoincollector.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dimitar.zlatkov.eurocoincollector.helpers.IOHelper;

/**
 * Class responsible for keeping the database up-to date.
 * <p>
 * We use update scripts to migrate the schema to every new version. The scripts for a particular
 * version are included in 'database/version<version_num>' dir. The version number is controlled by
 * {@link DatabaseHelper#DATABASE_VERSION}. Every time this number is increased the database will be
 * updated correspondingly.
 * <p>
 * Format of the update script directories:
 * <ul>
 * <li>Every such directory contains a file listing all the scripts to be executed. The name of the
 * file should always be the same as {@link DatabaseHelper#VERSION_UPDATE_SCRIPTS_LIST_FILE}. In
 * this file list the name of the sequence of update files to be executed. Lines beginning with '#'
 * and blank lines are ignored while processing the file.</li>
 * <li>Include the update scripts in the corresponding folder. The names should be the same as
 * listed in the script list file. Every file should contain valid SQLite script consisting of a
 * single command and not include commit commands (commit is executed programmatically).</li>
 * </ul>
 *
 * @author dimitar.zlatkov
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    // Database constants
    private static int DATABASE_VERSION = 1;
    // Update scripts constants
    private static final String VERSION_UPDATE_SCRIPT_FILE = "v_%02d_script_list";

    /** Update scripts are stored in the assets directory. */
    protected Resources resources;
    protected Context context;
    private boolean foreignKeysEnabled;

    public DatabaseHelper(Context context) {
        super(context, DatabaseConstants.DATABASE_NAME, null, DATABASE_VERSION);
        this.resources = context.getResources();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.i(DatabaseConstants.LOG_TAG, "Creating the database");
        onUpgrade(database, 0, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int fromVersion, int toVersion) {
        Log.i(DatabaseConstants.LOG_TAG, "Upgrading the database from version " + fromVersion
                + " to version " + toVersion);
        for (int version = fromVersion + 1; version <= toVersion; ++version) {
            Log.v(DatabaseConstants.LOG_TAG, "Upgrading to version " + version);
            List<String> scriptFileNames = getScriptFileNames(version);
            for (String scriptFileName : scriptFileNames) {
                Log.v(DatabaseConstants.LOG_TAG, "Executing upgrade script: " + scriptFileName);
                String sqlString = IOHelper.getFileContent(resources, scriptFileName, context);
                database.execSQL(sqlString);
            }
        }
    }

    /**
     * Gets the file names of all update scripts of a DB version.
     *
     * @param version The version for which to fetch the scripts.
     * @return The file names of all the update scripts of the DB version.
     */
    protected List<String> getScriptFileNames(int version) {
        List<String> scriptFileNames = new ArrayList<String>();

        String scriptListFileName = String.format(VERSION_UPDATE_SCRIPT_FILE, version);
        String versionScriptListContent = IOHelper.getFileContent(resources, scriptListFileName,
                context);
        if (versionScriptListContent != null) {
            String[] lines = versionScriptListContent.split("\n");
            for (String line : lines) {
                line = line.trim();
                if (line.length() != 0 && !line.startsWith("#")) {
                    scriptFileNames.add(line);
                }
            }
        } else {
            Log.w(DatabaseConstants.LOG_TAG, "No update script list found for version " + version);
        }
        return scriptFileNames;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly() && !foreignKeysEnabled) {
            // Enable foreign key constraints
            Log.d(DatabaseConstants.LOG_TAG, "enable foreign keys");
            db.execSQL("PRAGMA foreign_keys=ON;");
            foreignKeysEnabled = true;
        }
    }
}