package ua.bogdangud.restarauntrest.model;


import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @SequenceGenerator(name="position_id_seq",
            sequenceName="position_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="position_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name = "name")
    private String positionName;

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + positionName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
