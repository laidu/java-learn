package org.laidu.learn.advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

/**
 * jdbc coding
 *
 * create table book
 * (
 * 	id long auto_increment,
 * 	name varchar(32) default ''
 * );
 *
 * create unique index book_id_uindex
 * 	on book (id);
 *
 * alter table book
 * 	add constraint book_pk
 * 		primary key (id);
 *
 * @author zangtiancai.
 * @date 2019-05-30 15:11.
 */
@Slf4j
public class SqlApp {

    public static String DRIVER = "org.h2.Driver";

    public static String URL = "jdbc:h2:mem:default";
    public static String USER = "";
    public static String PASSWORD = "";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(DRIVER);

        Connection connection = DriverManager.getConnection(URL);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("show databases");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }


        statement.close();
        connection.close();


    }
}
