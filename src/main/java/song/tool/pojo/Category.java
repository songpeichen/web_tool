package song.tool.pojo;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "category_")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
