package bg.softuni.pathfinder.model.views;

import bg.softuni.pathfinder.model.enums.LevelEnum;

public class UserProfileView {
    private String username;
    private String email;
    private String fullNane;
    private int age;
    private LevelEnum level;

    public String getUsername() {
        return username;
    }

    public UserProfileView setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullNane() {
        return fullNane;
    }

    public UserProfileView setFullNane(String fullNane) {
        this.fullNane = fullNane;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserProfileView setAge(int age) {
        this.age = age;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserProfileView setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}
