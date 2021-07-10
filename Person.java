public class Person {
    private static Person ourInstance = new Person();

    public static Person getInstance() {
        return ourInstance;
    }

    private Person() {
    }

    public static void main(String[] args) {
        Person person= Person.getInstance();
        System.out.println(person);
        Person person1= Person.getInstance();
        System.out.println(person1);
    }
}
