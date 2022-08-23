package demo;

public class A {
    public void print() {
        System.out.println("A");
    }

    static class B extends A {
        @Override
        public void print() {
            super.print();
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        A b = new B();
        b.print();
    }
}

