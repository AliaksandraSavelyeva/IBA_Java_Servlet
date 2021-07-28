package by.alia.servletproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private int id;
    private String login;
    private byte[]  passw;
    //private String passw1;

    public User(String name, byte[] password) {
        this.login = name;
        this.passw = password;
    }

    //public User(String name, String password) {
        //this.login = name;
        //this.passw1 = password;
    //}
}

