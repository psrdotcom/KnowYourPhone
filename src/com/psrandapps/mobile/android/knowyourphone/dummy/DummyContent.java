package com.psrandapps.mobile.android.knowyourphone.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psrandapps.mobile.android.knowyourphone.features.TelephoneManagerOptions;

import android.content.Context;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static Context context;
    
    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Phone Type", new TelephoneManagerOptions(context).getPhoneType()));
//        addItem(new DummyItem("2", "Item 2"));
//        addItem(new DummyItem("3", "Item 3"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String title;
        public String content;

        public DummyItem(String id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        public String getTitle()
        {
        	return title;
        }
        
        @Override
        public String toString() {
            return content;
        }
    }
}
