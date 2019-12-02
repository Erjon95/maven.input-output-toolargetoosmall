package com.github.perschola;

import org.junit.Assert;
import org.junit.Test;

public class MyObjectTest {
    /**
     * This method is used as a reference for how to build tests
     */
    @Test
    public void testRun() { // TODO - implement tests
        // Given
        InputEvaluator myObject = new InputEvaluator();

        // when
        myObject.run();

        //then
        Assert.assertNotNull(myObject.toString());
    }
}
