package sophia.com.ecommerce;

import android.content.Intent;
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

import sophia.com.ecommerce.adapter.CategoriesAdapter;
import sophia.com.ecommerce.data.CategoryModel;

public class CategoryActivity extends AppCompatActivity {
    private ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView1 = (ListView)findViewById(R.id.listView1);

        final List<CategoryModel> categoryModelList = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            categoryModelList.add(new CategoryModel(i, "Category " + i, "description " + i));
        }




        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this, categoryModelList);

        listView1.setAdapter(categoriesAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CategoryActivity.this, ProductsActivity.class);

                i.putExtra("id", categoryModelList.get(position).getID());
                i.putExtra("title", categoryModelList.get(position).getTitle());
                startActivity(i);
            }
        });
    }

}
