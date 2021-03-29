package homework24.entities;

public class Category {
    private long id_category;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
