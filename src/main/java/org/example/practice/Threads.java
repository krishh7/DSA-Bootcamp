package org.example.practice;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

class SharedResource2 {

    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}
public class Threads {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            numbers.add(5);
        }


    }
}
