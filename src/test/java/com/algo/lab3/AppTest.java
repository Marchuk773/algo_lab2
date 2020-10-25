package com.algo.lab3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.algo.lab_3.algoritm.LongPoker;

public class AppTest {

    @Test
    public void testPoker() {
        LongPoker poker1 = new LongPoker("poker1.txt");
        assertEquals(7, poker1.solve());
        System.out.println(poker1.solve());

        LongPoker poker2 = new LongPoker("poker2.txt");
        assertEquals(3, poker2.solve());
        System.out.println(poker2.solve());

        LongPoker poker3 = new LongPoker("poker3.txt");
        assertEquals(4, poker3.solve());
        System.out.println(poker3.solve());

        LongPoker poker4 = new LongPoker("poker4.txt");
        assertEquals(20, poker4.solve());
        System.out.println(poker4.solve());

    }

}
