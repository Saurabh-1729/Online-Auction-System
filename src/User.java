public class User {
    private final int id;
    private final String name;
    private final String email;


    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

/*
id
name
email
 */
