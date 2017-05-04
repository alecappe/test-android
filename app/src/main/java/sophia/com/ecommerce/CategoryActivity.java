package sophia.com.ecommerce;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CategoryActivity extends AppCompatActivity {
    private ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView1 = (ListView)findViewById(R.id.listView1);
        final String[] cols = new String[]{
                "Elemento 1",
                "Elemento 2",
                "Elemento 3",
                "Elemento 4",
                "Elemento 5",
                "Elemento 6",
                "Elemento 7",
                "Elemento 8",
                "Elemento 9",
                "Elemento 10",
                "Elemento 11",
                "Elemento 12",
                "Elemento 13",
                "Elemento 14",
                "Elemento 15",
                "Elemento 16",
                "Elemento 17",
                "Elemento 18"
        };


        ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.text_view_row , cols);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("CategoryAcrivity", String.valueOf(position));
                Log.d("CategoryAcrivity", cols[position]);
            }
        });
    }

}
