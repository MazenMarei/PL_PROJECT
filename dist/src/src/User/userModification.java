package src.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class userModification extends User {

    public enum Role {
        INVENTORY,
        ADMIN,
        CLIENT
    }

    private static final File USERFOLDER = new File("src/src/Database/Users");

    public userModification() {
        super();

        File[] listOfUsersFolder = USERFOLDER.listFiles();
        ArrayList<UserActions> users = User.getUsers();

        for (File file : listOfUsersFolder) {
            if (file.isFile()) {
                try {
                    Scanner Reader = new Scanner(file);
                    String name = Reader.nextLine();
                    String email = Reader.nextLine();
                    String password = Reader.nextLine();
                    Role role = Role.valueOf(Reader.nextLine().toUpperCase());
                    String id = Reader.nextLine();
                    Reader.close();
                    UserActions dbUser = new User();
                    dbUser.setName(name);
                    dbUser.setEmail(email);
                    dbUser.setPassword(password);
                    dbUser.setRole(role);
                    dbUser.setId(id);
                    users.add(dbUser);
                    Reader.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("User File not found");
                }

            }
        }

        User.setUsers(users);
    }

    public boolean Register(String name, String email, String password, Role role) throws IllegalArgumentException {

        if (name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long");
        }

        if (!email.matches("^(.+)@(.+)$")) {
            throw new IllegalArgumentException("Invalid email Formate. Should be in the form of email@domain.com");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (!(role instanceof Role)) {
            throw new IllegalArgumentException("Invalid role must be either admin , client or invintory");
        }

        if (role == Role.ADMIN && User.getCurrentUser() != null) {
            if (User.getCurrentUser().getRole() != Role.ADMIN) {
                throw new IllegalArgumentException("Only admin can create new admin");
            }
        } else if (role == Role.ADMIN && User.getCurrentUser() == null) {
            throw new IllegalArgumentException("Only admin can create new admin");
        }

        if (!User.getUsers().isEmpty()) {
            for (UserActions user : User.getUsers()) {
                if (user.getEmail().equals(email)) {
                    throw new IllegalArgumentException("Email already exists");
                }
            }
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setId(Integer.toString(User.getUserCount() + 1));

        User.add(user);
        return true;
    }

    public boolean Login(String email, String password) {
        for (UserActions user : User.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                User.setCurrentUser(user);
                return true;
            }
        }

        throw new IllegalArgumentException("Invalid email or password");
    }

    public void Logout() {
        User.setCurrentUser(null);
    }

    public void Update(String name, String email, String password) {
        if (User.getCurrentUser() == null) {
            throw new IllegalArgumentException("No user is logged in");
        }

        String oldEmail = User.getCurrentUser().getEmail();
        String oldName = User.getCurrentUser().getName();
        String oldPassword = User.getCurrentUser().getPassword();

        if (!oldEmail.equals(email) && oldEmail != null) {
            for (UserActions user : User.getUsers()) {
                if (user.getEmail().equals(email)) {
                    throw new IllegalArgumentException("Email already exists");
                }
            }
        }

        if (name != null) {

            if (name.equals(oldName)) {
                throw new IllegalArgumentException("Name must be different from the old name");
            }

            if (name.length() < 3) {
                throw new IllegalArgumentException("Name must be at least 3 characters long");
            }
            User.getCurrentUser().setName(name);
        }

        if (email != null) {

            if (email.equals(oldEmail)) {
                throw new IllegalArgumentException("Email must be different from the old email");
            }

            if (!email.matches("^(.+)@(.+)$")) {
                throw new IllegalArgumentException("Invalid email Formate. Should be in the form of email@domail.com");
            }

            User.getCurrentUser().setEmail(email);
        }
        if (password != null) {

            if (password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 8 characters long");
            }

            if (password.equals(oldPassword)) {
                throw new IllegalArgumentException("Password must be different from the old password");
            }

            User.getCurrentUser().setPassword(password);
        }

        User.update(User.getCurrentUser());
    }
}