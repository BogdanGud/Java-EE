package ua.bogdangud.restaraunt.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table
public class Dish {

    @Id
    @SequenceGenerator(name="dish_id_seq",
            sequenceName="dish_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="dish_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name = "name")
    private String dishName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Fetch(FetchMode.JOIN)
    private  CategoryDish categoryDish;

    @Column(name = "price")
    private double price;

    @Column(name = "weight")
    private double weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public CategoryDish getCategoryDish() {
        return categoryDish;
    }

    public void setCategoryDish(CategoryDish categoryDish) {
        this.categoryDish = categoryDish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", categoryDish=" + categoryDish +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
