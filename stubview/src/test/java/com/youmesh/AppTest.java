package com.youmesh;

import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private final static Logger LOG = Logger.getLogger(AppTest.class.getName());
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        LOG.info("Called testApp");
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        LOG.info("Called setUp");
    }
    
    @Override
    protected void tearDown() throws Exception
    {
        super.setUp();
        LOG.info("Called tearDown");
    }
}
