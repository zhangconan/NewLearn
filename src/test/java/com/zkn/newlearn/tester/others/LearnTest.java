package com.zkn.newlearn.tester.others;

/**
 * Created by zkn on 2017/9/30.
 */
public class LearnTest {

    public static void main(String[] args) {
        System.out.println("ebok");
        LearnTest learnTest = new LearnTest();
        learnTest.add();
        Zhang zhang1 = new Zhang();
        zhang1.add();
    }

    public void add(){
        int i = 1;
        int j = 2;
        System.out.println(i+j);
        sum();
    }

    private void sum(){
        int i = 1;
        int j = 4;
        System.out.println(i+j);
    }
}

class Ttttt {

    public void add() {
        int i = 2;
        int j = 4;

        int z = i + j;
        System.out.println(z);
    }
}
class Zhang{

    public void add(){
        int l = 22;
        int h = 36;

        int q = l+h;
        System.out.println(q);
    }
}

