package dev.megashopper.items;

public class items {
    private int item_id;
    private String title;
    private String description;
    private int price;
    private int category_id;

    public items() {
    }

    public items(int item_id, String title, String description, int price, int category_id) {
        this.item_id = item_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "electronics{" +
                "item_id=" + item_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category_id=" + category_id +
                '}';
    }
}
