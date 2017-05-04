package sophia.com.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class ProductsActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Bundle b = getIntent().getExtras();

        String title = b.getString("title", "");

        setTitle(title);

        gridView = (GridView)findViewById(R.id.gridView);
    }
}
