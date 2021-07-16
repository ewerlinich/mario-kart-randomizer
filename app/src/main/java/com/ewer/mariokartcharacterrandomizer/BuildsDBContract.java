package com.ewer.mariokartcharacterrandomizer;

import android.provider.BaseColumns;

public class BuildsDBContract {
    private BuildsDBContract() {}

    public static class SavedEntry implements BaseColumns {
        public static final String TABLE_NAME = "builds_saved";
        public static final String COLUMN_BUILD_NAME = "build_name";
        public static final String COLUMN_BUILD_CHARACTER = "build_character";
        public static final String COLUMN_BUILD_FRAME = "build_frame";
        public static final String COLUMN_BUILD_TIRES = "build_tires";
        public static final String COLUMN_BUILD_GLIDER = "build_glider";
    }

    public static class HistoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "builds_history";
        public static final String COLUMN_BUILD_INDEX = "build_index";
        public static final String COLUMN_BUILD_CHARACTER = "build_character";
        public static final String COLUMN_BUILD_FRAME = "build_frame";
        public static final String COLUMN_BUILD_TIRES = "build_tires";
        public static final String COLUMN_BUILD_GLIDER = "build_glider";
    }
}
