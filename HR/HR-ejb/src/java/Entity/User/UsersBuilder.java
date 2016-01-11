/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.User;

public class UsersBuilder {

    private String email;
    private String username;
    private String permisiuni;
    private String fistName;
    private String lastName;
    private String telephone;
    private String mobile;
    private String description;

    public UsersBuilder(String email, String username, String permisiuni) {
        this.email = email;
        this.username = username;
        this.permisiuni = permisiuni;
    }

    public UsersBuilder setFistName(String fistName) {
        this.fistName = fistName;
        return this;
    }

    public UsersBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UsersBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public UsersBuilder setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public UsersBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Users createUsers() {
        return new Users(email, username, permisiuni, fistName, lastName, telephone, mobile, description);
    }

}
