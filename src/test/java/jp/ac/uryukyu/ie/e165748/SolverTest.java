package jp.ac.uryukyu.ie.e165748;

import static org.junit.Assert.*;

/**
 * Created by e165748 on 2/1/17.
 */
public class SolverTest {
    static Solver p = new Solver();
    public static void main(String[] args){
        p.setPlayerName("Test");
        assertTrue(p.getPlayerName().equals("Test"));
    }
}

