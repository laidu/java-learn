package org.laidu.learn.calcite;

import lombok.extern.slf4j.Slf4j;
import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.SchemaPlus;

import java.sql.*;

/**
 * @author tiancai.zang
 * on 2018-10-10 17:10.
 */
@Slf4j
public class Demo {

    public void run() throws ClassNotFoundException, SQLException {

        Class.forName("org.apache.calcite.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql:local-dev");

        CalciteConnection calciteConnection =
                connection.unwrap(CalciteConnection.class);

        SchemaPlus rootSchema = calciteConnection.getRootSchema();
        rootSchema.add("hr", new ReflectiveSchema(new Hr()));
        rootSchema.add("foodmart", new ReflectiveSchema(new Foodmart()));
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement.executeQuery("select *\n"
                        + "from \"foodmart\".\"sales_fact_1997\" as s\n"
                        + "join \"hr\".\"emps\" as e\n"
                        + "on e.\"empid\" = s.\"cust_id\"");
        final StringBuilder buf = new StringBuilder();
        while (resultSet.next()) {
            int n = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= n; i++) {
                buf.append(i > 1 ? "; " : "")
                        .append(resultSet.getMetaData().getColumnLabel(i))
                        .append("=")
                        .append(resultSet.getObject(i));
            }
            System.out.println(buf.toString());
            buf.setLength(0);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    /** Object that will be used via reflection to create the "hr" schema. */
    public static class Hr {
        public final Employee[] emps = {
                new Employee(100, "Bill"),
                new Employee(200, "Eric"),
                new Employee(150, "Sebastian"),
        };
    }

    /** Object that will be used via reflection to create the "emps" table. */
    public static class Employee {
        public final int empid;
        public final String name;

        public Employee(int empid, String name) {
            this.empid = empid;
            this.name = name;
        }
    }

    /** Object that will be used via reflection to create the "foodmart"
     * schema. */
    public static class Foodmart {
        public final SalesFact[] sales_fact_1997 = {
                new SalesFact(100, 10),
                new SalesFact(150, 20),
        };
    }


    /** Object that will be used via reflection to create the
     * "sales_fact_1997" fact table. */
    public static class SalesFact {
        public final int cust_id;
        public final int prod_id;

        public SalesFact(int cust_id, int prod_id) {
            this.cust_id = cust_id;
            this.prod_id = prod_id;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        new Demo().run();
    }
}