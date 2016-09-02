package com.zkn.newlearn.tester;

/**
 * Created by wb-zhangkenan on 2016/8/10.
 */
public class ExceptionTest01 {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
