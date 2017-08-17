package org.mallcu.resources.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

import static org.junit.Assert.*;

import org.mallcu.resources.ClassResource;

/**
 * Class resource tests.
 * 
 * @author Cesar Flores
 */
public class ClassResourceTest {
    
    @Rule
    public final ResourceTestRule resource  = ResourceTestRule.builder()
                .addResource(new ClassResource()).build();;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getAllClassTest() {
        List clasz = resource.client()
                .target("/api/v1/class").request().get(List.class);
        assertTrue(clasz.isEmpty());
    }

}
