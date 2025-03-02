package org.example.strings;

public class StringBufferVSStringBuilder {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        StringBuilder builder = new StringBuilder("Krishna");
        builder.reverse();
        System.out.println(builder);

        String string = String.format("Hello, %s. Welcome to the %s!", "Joy", "Club");
        System.out.println(string);

        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("A");
            }
        });

        Thread t2 = new Thread( () -> {
            for (int j = 0; j < 1000; j++) {
                sb.append("B");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb.toString().length());
    }
}
