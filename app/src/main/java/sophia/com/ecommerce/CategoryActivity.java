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

import java.util.ArrayList;
import java.util.List;

import sophia.com.ecommerce.data.CategoryModel;

public class CategoryActivity extends AppCompatActivity {
    private ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView1 = (ListView)findViewById(R.id.listView1);

        List<CategoryModel> categoryModelList = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            categoryModelList.add(new CategoryModel(i, "title" + i, "descr" + i));
        }


        ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.text_view_row);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("CategoryAcrivity", String.valueOf(position));
            }
        });
    }

}
