package org.mallcu.core.test;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.mallcu.core.ClassManager;

/**
 * Tests for ClassManger.
 * 
 * @author Cesar Flores
 */
public class ClassManagerTest {

    private ClassManager classManager;
    
    @Before
    public void setUp() {
        classManager = new ClassManager();
    }
    
    @After
    public void tearDown() {
        classManager = null;
    }

    @Test(expected = NoSuchElementException.class)
    public void searchByCodeTest() {
        classManager.searchByCode("NOT-EXIST");
    }
}
