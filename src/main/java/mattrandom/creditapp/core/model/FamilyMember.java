package mattrandom.creditapp.core.model;

public class FamilyMember implements Comparable<FamilyMember> {
    private final String name;
    private final Integer age;

    public FamilyMember(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(FamilyMember o) {
        return o.age.compareTo(age);
    }
}
