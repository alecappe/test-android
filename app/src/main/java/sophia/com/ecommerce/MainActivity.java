package sophia.com.ecommerce;

import android.content.ClipData;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import sophia.com.ecommerce.data.Item;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Item item;
    private Button buttonLeft;
    private Button buttonRight;
    private int currentPhotoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        titleTextView = (TextView)findViewById(R.id.titleTextView);
        descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);

        buttonLeft = (Button) findViewById(R.id.actionButtonLeft);
        buttonRight = (Button)findViewById(R.id.actionButtonRight);

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","activityButton clicked");

                try{
                    currentPhotoIndex--;
                    if(currentPhotoIndex<0){
                        currentPhotoIndex = item.getPhotos().length - 1;
                    }
                    imageView.setImageDrawable(getDrawable(item.getPhotoAtIndex(currentPhotoIndex)));
                }catch (ArrayIndexOutOfBoundsException e){
                    Log.d("MainActivity", "Errore immagine non trovata");
                }


            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","activityButton clicked");

                try{
                    currentPhotoIndex++;
                    if(currentPhotoIndex==item.getPhotos().length){
                        currentPhotoIndex = 0;
                    }
                    imageView.setImageDrawable(getDrawable(item.getPhotoAtIndex(currentPhotoIndex)));
                }catch (ArrayIndexOutOfBoundsException e){
                    Log.d("MainActivity", "Errore immagine non trovata");
                }


            }
        });




        int[] photos = new int[]{R.drawable.android1, R.drawable.item};
        int[] rating = new int[]{1,2,3,4,5};
        String lorem = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, ";



        item = new Item(1, "item 1", lorem, 19.90,photos, true,rating);
       // Item item2 = new Item(1, "item 1", 10.5, "item description", photo, 3,"shipping comment");

        titleTextView.setText(item.getTitle());
        descriptionTextView.setText(item.getDescription());

        //Item item2 = new Item(2, "item 2", 5.3, "item description", photo, 5,"shipping comment");

      //  Log.d("MainActivity", item1.toString());
      //  Log.d("MainActivity", String.valueOf(item1.equals((item2))));


    }
}