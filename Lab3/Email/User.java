package Email;

class User {
    private String name;
    private int salary;
    private String email;

    public User() {
        this.name = "";
        this.salary = 0;
        this.email = "";
    }

    public void setSalary(String newSalary) throws NumberFormatException {
        try {
            this.salary = Integer.parseInt(newSalary);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public void setEmail(String newEmail) throws MalformedEmailAddressException {
        if (newEmail.contains("@") && newEmail.indexOf("@") == newEmail.lastIndexOf("@") && newEmail.indexOf("@") > 0 && newEmail.indexOf("@") < newEmail.length() - 1) {
            this.email = newEmail;
        } else {
            throw new MalformedEmailAddressException("Malformed email address");
        }
    }
    @Override
    public String toString() {
        return "User: " + name + "\nSalary: " + salary + "\nEmail: " + email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }
}