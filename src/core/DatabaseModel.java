package core;

import java.sql.*;
import javax.sql.*;

import java.util.*;

import java.lang.reflect.*;

public abstract class DatabaseModel
{
    private Connection mysql;
    private Statement query;
    
    private String tableName;
    private int numberOfColumns = 0;
    private Vector<String> columnNames;
    
    private int id;
    
    public DatabaseModel()
    {
        /**
         * Get Class name so we know what the corresponding MySQL table is
         */
        setTableName(this.getClass().getSimpleName());
        
        try
        {
            Class.forName("com.mysql.jdbc.driver").newInstance();
            mysql = DriverManager.getConnection("jdbc:mysql://"
                + "localhost/webquiz?user=root&password=asdasd");
            query = mysql.createStatement();
        }
        catch (SQLException exc)
        {
            System.err.println("MySQL Exception: " + exc.toString());
        }
        catch (Exception exc)
        {
            System.err.println(exc.getMessage());
        }
        
        columnNames = new Vector<String>();
    }
    
    /**
     * Conversion constructor that takes an ID number that relates to the 
     * primary key of the table the class is representing. The column headers
     * are then used from the DB to fill in the attributes of the object.
     *
     * @param   id  The ID number relating to the record in the database.
     */
    public DatabaseModel(int id)
    {
        this();
        
        setId(id);
        
        String mysqlQuery = "SELECT * FROM " + getTableName() + 
            " WHERE id = " + getId() + ";";
        
        try
        {
            ResultSet item = query.executeQuery(mysqlQuery);

            
            ResultSetMetaData columnNamesMeta = item.getMetaData();
            numberOfColumns = columnNamesMeta.getColumnCount();

            for (int i = 0; i < numberOfColumns; i++)
            {
                columnNames.add(columnNamesMeta.getColumnName(i));
            }

            if (item.first()) // only have one record, or item doesn't exist
            {
                Class model = this.getClass(); // get this class for analysis
                
                for (String columnName : columnNames) // for each column
                {
                    try
                    {
                        Field attribute = model.getField(columnName);
                        attribute.set(this, item.getString(columnName));
                    }
                    catch (NoSuchFieldException e)
                    {
                        System.err.println(e);
                    }
                    catch (IllegalAccessException e)
                    {
                        System.err.println(e);
                    }
                }
            }
            else
            {
                // item doesn't exist in db
            }
        }
        catch (Exception exc)
        {
            System.err.println(exc.toString());
        }
        
    }
    
    private void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    
    public String getTableName()
    {
        return tableName;
    }
    
    private void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return id;
    }
}