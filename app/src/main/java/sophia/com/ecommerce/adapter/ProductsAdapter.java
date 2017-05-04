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
import sophia.com.ecommerce.data.Item;

/**
 * Created by archimede on 04/05/17.
 */

public class ProductsAdapter extends BaseAdapter {

    private Context ctx;
    private List<Item> itemList;

    public ProductsAdapter(Context ctx, List<Item> itemList){
        this.ctx = ctx;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList == null ? null : itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemList == null ? 0 : itemList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextHolder th = null;
        if (v == null) {
            LayoutInflater lInf = (LayoutInflater)
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = lInf.inflate(R.layout.item_grid_layout, null);

            TextView nameView = (TextView) v.findViewById(R.id.name);
            TextView descrView = (TextView) v.findViewById(R.id.descr);
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);

            th = new TextHolder();
            th.nameView = nameView;
            th.descrView = descrView;
            th.imageView = imageView;
            v.setTag(th);
        }
        else
            th = (TextHolder) v.getTag();
        th.nameView.setText(itemList.get(position).getTitle());
        th.descrView.setText(itemList.get(position).getDescription());

        try{
            Picasso.with(ctx).load(itemList.get(position).getPhotoAtIndex(0)).into(th.imageView);
        }catch (ArrayIndexOutOfBoundsException ex) {

        }


        return v;
    }

    static class TextHolder {
        TextView nameView;
        TextView descrView;
        ImageView imageView;
    }
}
