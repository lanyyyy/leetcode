package learn;

public class NiMingNeiBuLei {

    public static void main(String[] args) {
        Person person = new Person() {
            @Override
            public void sayHello() {
                System.out.println("Hello body");
            }
        };
        person.sayHello();
    }



    interface Person {
        void sayHello();
    }
}
