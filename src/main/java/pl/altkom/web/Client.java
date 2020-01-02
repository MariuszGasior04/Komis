package pl.altkom.web;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String region;
    private String sex;

    public Client() {
    }
    public String getData(){
        return id+" "+ firstName+" "+lastName + " " + age + " "+ region + " " + sex;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", region='" + region + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
