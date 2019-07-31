package com.stackroute;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JdbcBasicDemo jdbc=new JdbcBasicDemo();
        jdbc.displayUser();
        jdbc.getUserByName("shiv");


        DatabaseMetaDataDemo databaseMetaDataDemo = new DatabaseMetaDataDemo();
        databaseMetaDataDemo.metaDataUser();


        ResultSetMetaDataDemo resultSetMetaDataDemo=new ResultSetMetaDataDemo();
        resultSetMetaDataDemo.displayResultSetMetaData();



        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.displayRowSet();


        JdbcBatchProcessingDemo jdbcBatchProcessingDemo=new JdbcBatchProcessingDemo();
        jdbcBatchProcessingDemo.batchProcessing();

        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.displayJdbcTransaction();
    }
}
