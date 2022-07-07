public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String currentCity;
    protected int age;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws Exception {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Возраст некорректен");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String currentCity) {
        this.currentCity = currentCity;
        return this;
    }

    public Person build() throws Exception {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не заполнены обязательные поля");
        }
        if (currentCity == null && age == 0) {
            return new Person(name, surname);
        } else if (currentCity == null) {
            return new Person(name, surname, age);
        } else if (age == 0) {
            return new Person(name, surname, currentCity);
        }
        return new Person(name, surname, age, currentCity);
    }
}
