package com.example.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpecificCategoryActivity extends Activity { //this is where you see the clothes of the selected category
  //this is for all the categories
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_category);

        Bundle extraContent = getIntent().getExtras();
        category = extraContent.getString("category");

       // clothing = new ClothingCategory();








        final ListView listview = (ListView) findViewById(R.id.category_list);

        //String[] values = new String[] { "shirt0", "shirt1","shirt2", "shirt3" };

        final ArrayList<Clothes> list = new ArrayList<Clothes>();
        for (int i = 0; i < 4; ++i) {
            list.add(
                    new Clothes(
                            ("desc"+i).toString(), //contructing string desc1, desc2...
                            ("type"+i).toString(),
                            ("color"+i).toString()
                    )
            );
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
               R.layout.clothing_item_layout, list);
        listview.setAdapter(adapter);


        //TODO: want to make a more specific description screen when user taps specific list item
       // listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

//            @Override
//            public void onItemClick(AdapterView<?> parent, final View view,
//                                    int position, long id) {
//                final String item = (String) parent.getItemAtPosition(position);
//                view.animate().setDuration(2000).alpha(0)
//                        .withEndAction(new Runnable() {
//                            @Override
//                            public void run() {
//                                list.remove(item);
//                                adapter.notifyDataSetChanged();
//                                view.setAlpha(1);
//                            }
//                        });
//            }

      //  });
    }

    private class StableArrayAdapter extends ArrayAdapter<Clothes> {

        private final Context context;
        private final ArrayList<Clothes> values;

       // HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  ArrayList<Clothes> objects) {
            super(context, textViewResourceId, objects);
            //for (int i = 0; i < objects.size(); ++i) {
               // mIdMap.put(objects.get(i), i);
           // }
            this.context = context;
            this.values = objects;
        }

//        @Override
//        public long getItemId(int position) {
//            String item = getItem(position);
//            return mIdMap.get(item);
//        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.clothing_item_layout, parent, false);
            TextView textView1 = (TextView) rowView.findViewById(R.id.firstLine);
            TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
            TextView textView3 = (TextView) rowView.findViewById(R.id.thirdLine);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            textView1.setText(values.get(position).getColor());
            textView2.setText(values.get(position).getDescription());
            textView3.setText(values.get(position).getType());
            // change the icon for Windows and iPhone
//            String s = values[position];
//            if (s.startsWith("iPhone")) {
//                imageView.setImageResource(R.drawable.no);
//            } else {
//                imageView.setImageResource(R.drawable.ok);
//            }

            return rowView;
        }

    }

}


