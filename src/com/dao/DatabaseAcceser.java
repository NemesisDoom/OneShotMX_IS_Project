/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class DatabaseAcceser {

    private final static String CONFIG_PATH = "config.ini";
    private final static String DATABASE_TOKEN = "[DATABASE_VALUES]";
    private final static String DATABASE_USERNAME = "username";
    private final static String DATABASE_PASSWORD = "password";
    private final static String DATABASE_PORT = "port";
    private final static String DATABASE_HOST = "host";
    private final static String DATABASE_NAME = "database";
    private static DatabaseAcceser INSTANCE;

    public static DatabaseAcceser getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseAcceser();
        }
        return INSTANCE;
    }

    public void loadDatabaseConfiguration() {
        Hashtable<String, String> databaseConfiguration = readConfigFile();

        String portString = databaseConfiguration.get(DATABASE_PORT);
        int portNumber = Integer.parseInt(portString);

        String username = databaseConfiguration.get(DATABASE_USERNAME);
        String password = databaseConfiguration.get(DATABASE_PASSWORD);
        String host = databaseConfiguration.get(DATABASE_HOST);
        String database = databaseConfiguration.get(DATABASE_NAME);

        DatabaseConnectionManager connManager = DatabaseConnectionManager.getInstance();
        connManager.initializeConnectionManager(username, password, host, database, portNumber);
    }

    public void testConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            DatabaseConnectionManager connManager = DatabaseConnectionManager.getInstance();
            connManager.openConnection();
            System.out.println("Connection Tested");
            connManager.closeConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private Hashtable<String, String> readConfigFile() {
        Hashtable<String, String> databaseValues = new Hashtable<String,String>();
        try {
            File configFile = new File(CONFIG_PATH);
            Scanner fileScanner = new Scanner(configFile);

            boolean foundDatabaseToken = false;

            while (fileScanner.hasNext()) {
                String actualLine = fileScanner.nextLine();

                if (actualLine.equalsIgnoreCase(DATABASE_TOKEN)) {
                    foundDatabaseToken = true;
                } else if (foundDatabaseToken) {
                    if (actualLine.contains(DATABASE_PASSWORD)) {
                        addConfigurationValue(DATABASE_PASSWORD,getLineValue(actualLine));
                    } else if (actualLine.contains(DATABASE_USERNAME)) {
                        addConfigurationValue(DATABASE_USERNAME,getLineValue(actualLine));
                    } else if (actualLine.contains(DATABASE_PORT)) {
                        addConfigurationValue(DATABASE_PORT,getLineValue(actualLine));
                    } else if (actualLine.contains(DATABASE_HOST)) {
                        addConfigurationValue(DATABASE_HOST,getLineValue(actualLine));
                    } else if (actualLine.contains(DATABASE_NAME)) {
                        addConfigurationValue(DATABASE_NAME,getLineValue(actualLine));
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Config File not Found");
        }
        return databaseValues;
    }

    private void addConfigurationValue(
        String inConfigurationKey,
        String inConfigurationValue,
        Hashtable<String,String> inoutConfigurationTable
        ){
            inoutConfigurationFile.put(inConfigurationKey,inConfigurationValue);
    }
        
    private String getLineValue(String actualLine) {
        String value = "";
        int equalIndex = actualLine.indexOf("=");
        int commaIndex = actualLine.indexOf(";");
        value = actualLine.substring(equalIndex+1, commaIndex);
        value = value.trim();
        return value;
    }
    
    
}
