package src.User;

import java.util.*;
import java.io.*;



abstract class AbstractUser implements UserActions {
    protected String name;
    protected String email;
    protected String password;
    protected userModification.Role role;
    protected String id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public userModification.Role getRole() {
        return role;
    }

    @Override
    public void setRole(userModification.Role role) {
        this.role = role;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}

public class User extends AbstractUser {
    private static ArrayList<UserActions> users = new ArrayList<>();
    static private int userCount;
    private static final File USERCOUNTFILE = new File("src/src/Database/users_counts.txt");

    public User() {
        if (USERCOUNTFILE.exists()) {
            try {
                try (Scanner Reader = new Scanner(USERCOUNTFILE)) {
                    while (Reader.hasNextLine()) {
                        userCount = Integer.parseInt(Reader.nextLine());
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException("File not found 2");
            }
        } else {
            try {
                if (USERCOUNTFILE.createNewFile()) {
                    try (FileWriter Writer = new FileWriter(USERCOUNTFILE)) {
                        Writer.write("0");
                    }
                    userCount = 0;
                } else {
                    throw new RuntimeException("File not created");
                }
            } catch (IOException e) {
                throw new RuntimeException("File not found" + e);
            }
        }
    }

    private static UserActions currentUser;

    public static UserActions getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserActions user) {
        currentUser = user;
    }

    public static int getUserCount() {
        return userCount;
    }

    public static ArrayList<UserActions> getUsers() {
        return users;
    }

    protected static void setUsers(ArrayList<UserActions> users) {
        User.users = users;
    }

    public static UserActions add(UserActions user) {
        users.add(user);
        userCount++;
        try {
            FileWriter Writer = new FileWriter(USERCOUNTFILE);
            Writer.write(Integer.toString(userCount));
            Writer.close();

            File userFile = new File("src/src/Database/Users/" + userCount + ".txt");
            if (userFile.createNewFile()) {
                Writer = new FileWriter(userFile);
                Writer.write(user.getName() + "\n" + user.getEmail() + "\n" + user.getPassword() + "\n" + user.getRole()
                        + "\n" + user.getId());
                Writer.close();
            } else {
                throw new RuntimeException("File not created");
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }

        return user;
    }

    public static void update(UserActions user) {
        try {
            try (FileWriter Writer = new FileWriter("src/src/Database/Users/" + user.getId() + ".txt")) {
                Writer.write(user.getName() + "\n" + user.getEmail() + "\n" + user.getPassword() + "\n" + user.getRole()
                        + "\n" + user.getId());
                Writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }
}