package com.asree.stock_spring_boot.interfaces.user;

public class UserProductDTO {
    String id;
    String firstName;
    String lastName;
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public UserProductDTO() {
    }

    public UserProductDTO(String id, String firstName, String lastName, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

}
