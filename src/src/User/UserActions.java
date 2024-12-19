/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.User;

/**
 *
 * @author Racoon
 */
public interface UserActions {
    String getName();

    String getEmail();

    String getPassword();

    userModification.Role getRole();

    String getId();

    void setName(String name);

    void setEmail(String email);

    void setPassword(String password);

    void setRole(userModification.Role role);

    void setId(String id);
}