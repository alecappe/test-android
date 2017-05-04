package sophia.com.ecommerce.data;

/**
 * Created by archimede on 04/05/17.
 */

public class CategoryModel {

    private int ID;
    private String title;
    private String description;

    public CategoryModel(int ID, String title, String description) {
        this.ID = ID;
        this.title = title;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
