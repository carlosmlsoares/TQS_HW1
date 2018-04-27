/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw1tqs;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos Soares
 */
public class MockTest {

    ConversorBean instance;
    ConversorBean mock;
  

    public MockTest() {
    }

    
    @Before
    public void setUp() {
        instance = new ConversorBean();
        mock = EasyMock.createMock(ConversorBean.class);
}
    /**
     * Test of convert method, of class ConversorBean.
     */
    @Test
    public void testConvert() {
        System.out.println("convert");
        float exp=1.2088902f;
        String curr1 = "EUR";
        String curr2 = "USD";
        int quant = 1;
        EasyMock.expect(mock.convert(instance.getCoinValue(curr1), instance.getCoinValue(curr2), quant)).andReturn(exp);
        EasyMock.replay(mock);
        
        instance.setCurrency1(curr1);
        instance.setCurrency2(curr2);
        instance.setValue(quant);
        instance.submit();
        
        assertEquals(exp, instance.getConvertedValue(), 0.2);
    }

}
