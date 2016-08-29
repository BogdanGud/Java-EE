package ua.bogdangud.restarauntrest.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryDish {
    @Id
    @SequenceGenerator(name="category_dish_id_seq",
            sequenceName="category_dish_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="category_dish_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name = "name")
    private String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryDish{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
