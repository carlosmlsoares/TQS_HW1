/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw1tqs;

import java.util.List;
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
public class ConversorBeanTest {

    ConversorBean instance;
    public ConversorBeanTest() {
    }



    /**
     * Test of convert method, of class ConversorBean.
     */
    @Test
    public void testConvert() {
        instance=new ConversorBean();
        System.out.println("convert");
        float exp=1.2088902f;
        String curr1 = "EUR";
        String curr2 = "USD";
        int quant = 1;
        
        float result=instance.convert(instance.getCoinValue(curr1),instance.getCoinValue(curr2), quant);
        
        assertEquals(exp, result, 0.2);
    }
    
    
    
    
    @Test
    public void testGetCoins(){
        instance=new ConversorBean();
        int expectedSize=168;
        int realSize= instance.getCoins().size();
        assertEquals(expectedSize,realSize);
    }

}
