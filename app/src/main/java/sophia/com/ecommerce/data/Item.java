package sophia.com.ecommerce.data;

import java.util.Arrays;

/**
 * Created by archimede on 18/04/17.
 */

public class Item {
    private int id;
    private String title;
    private String descr;
    private double price;
    private int[] photos;
    private boolean disponibility;
    private int[] rating;




    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", price=" + price +
                ", photos=" + Arrays.toString(photos) +
                ", disponibility=" + disponibility +
                ", rating=" + rating +
                '}';
    }


    public Item(int id, String title, String descr, double price, int[] photos, boolean disponibility, int[] rating) {
        this.id = id;
        this.title = title;
        this.descr = descr;
        this.price = price;
        this.photos = photos;
        this.disponibility = disponibility;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return descr;
    }

    public void setDescription(String descr) {
        this.descr = descr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int[] getPhotos() {
        return photos;
    }

    public void setPhotos(int[] photos) {
        this.photos = photos;
    }

    public boolean isDisponibility() {
        return disponibility;
    }

    public void setDisponibility(boolean disponibility) {
        this.disponibility = disponibility;
    }
    public int[] getRating() {
        return rating;
    }

    public void setRating(int[] rating) {
        this.rating = rating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (Double.compare(item.price, price) != 0) return false;
        if (disponibility != item.disponibility) return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (descr != null ? !descr.equals(item.descr) : item.descr != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photos, item.photos)) return false;
        return Arrays.equals(rating, item.rating);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(photos);
        result = 31 * result + (disponibility ? 1 : 0);
        result = 31 * result + Arrays.hashCode(rating);
        return result;
    }
    public int getPhotoAtIndex(int index) throws ArrayIndexOutOfBoundsException{
        return photos[index];
    }

}
