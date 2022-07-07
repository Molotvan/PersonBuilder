public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String currentCity;

    public Person(String name, String surname, int age, String currentCity) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.currentCity = currentCity;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String currentCity) {
        this.name = name;
        this.surname = surname;
        this.currentCity = currentCity;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() throws Exception{
        if (hasAge()) {
        return age;}
        else {
            throw new Exception("Возраст не указан");
        }
    }

    public String getCurrentCity() throws Exception{
        if (hasAddress()) {
            return currentCity;}
        else {
            throw new Exception("Адрес не известен");
        }
    }

    public void setAge(int age) throws Exception{
        if(hasAge()){
            happyBirthday();
        }
        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Возраст некорректен");
        }else{
            this.age = age;
        }
    }

    boolean  hasAge () {
            return (age != 0);
        }

         boolean  hasAddress () {
            return (currentCity != null);
        }

        public void happyBirthday () {
            if (hasAge()) {
                age = age + 1;
            }
        }

        public PersonBuilder childBuilder(){
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname)
                    .setAddress(this.currentCity);
        return childBuilder;
        }

    @Override
    public String toString() {
        if(!hasAge() && !hasAddress()){
        return "Имя: " + name + "\n" + "Фамилия: " + surname + "\n" + "Возраст: " + "Неизвестен" + "\n"
                + "Адрес: " + "Неизвестен";
        }else if(!hasAge()){
            return "Имя: " + name + "\n" + "Фамилия: " + surname + "\n" + "Возраст: " + "Неизвестен" + "\n"
                    + "Адрес: " + currentCity;
        }else if(!hasAddress()){
            return "Имя: " + name + "\n" + "Фамилия: " + surname + "\n" + "Возраст: " + age + "\n"
                    + "Адрес: " + "Неизвестен";
        }else return "Имя: " + name + "\n" + "Фамилия: " + surname + "\n" + "Возраст: " + age + "\n"
                    + "Адрес: " + currentCity;
    }

    @Override
    public int hashCode() {
        return this.surname.hashCode();
    }
}
