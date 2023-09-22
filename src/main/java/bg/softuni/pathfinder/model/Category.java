package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.RouteCategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RouteCategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RouteCategoryEnum getName() {
        return name;
    }

    public void setName(RouteCategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}