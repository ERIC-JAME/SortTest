package com.company;

class AOO{
    public AOO() {

    }
    public void say(){
        System.out.println("我是弗雷");
    }
}
class BOO extends AOO{
    public BOO() {
    }
    @Override
    public void say() {
        System.out.println("我是自雷");

    }

}
public class TestOverride {
    public static void main(String[] args) {
        AOO o = new BOO();
        o.say();
    }
}
