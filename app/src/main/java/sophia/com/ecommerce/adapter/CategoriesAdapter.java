package sophia.com.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sophia.com.ecommerce.R;
import sophia.com.ecommerce.data.CategoryModel;

import static sophia.com.ecommerce.R.id.imageView;

/**
 * Created by archimede on 04/05/17.
 */

public class CategoriesAdapter extends BaseAdapter {

    private Context ctx;
    private List<CategoryModel> categoryModelList;

    public CategoriesAdapter(Context ctx, List<CategoryModel> categoryModelList) {
        this.ctx = ctx;
        this.categoryModelList = categoryModelList;
    }

    @Override
    public int getCount() {
        return categoryModelList == null ? 0 : categoryModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryModelList == null ? null : categoryModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categoryModelList == null ? 0 : categoryModelList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        CategoriesAdapter.TextHolder th = null;
        if (v == null) {
            LayoutInflater lInf = (LayoutInflater)
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lInf.inflate(R.layout.text_view_row, null);

            TextView nameView = (TextView) v.findViewById(R.id.title);
            TextView descrView = (TextView) v.findViewById(R.id.descr);

            th = new TextHolder();
            th.nameView = nameView;
            th.descrView = descrView;
            v.setTag(th);
        }
        else
            th = (TextHolder) v.getTag();

        th.nameView.setText(categoryModelList.get(position).getTitle());
        th.descrView.setText(categoryModelList.get(position).getDescription());

        return v;
    }

    static class TextHolder {
        TextView nameView;
        TextView descrView;
    }

}
