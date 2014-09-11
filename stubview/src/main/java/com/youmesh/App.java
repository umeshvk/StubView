package com.youmesh;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static Logger LOG = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        System.out.println( "Hello World!=" + System.getProperty("java.util.logging.config.file") );
        LOG.info("test log");
    }
}


/**
 
    SEVERE (highest value)
    WARNING
    INFO
    CONFIG
    FINE
    FINER
    FINEST (lowest value) 
 */
