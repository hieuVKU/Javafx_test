package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

    public static Connection getConnection() {
        Connection sConn = null;

        //Khai báo chuỗi kết nối
        String strDbUrl = "jdbc:sqlserver://localhost:1433; databaseName=StudentManagement;user=sa;password=123456789;"
                + "encrypt=true;trustServerCertificate=true";
        if (sConn == null) {
            try {
                sConn = DriverManager.getConnection(strDbUrl);
                System.out.println("Ket noi thanh cong");
                DatabaseMetaData data = (DatabaseMetaData) sConn.getMetaData();
                // hien thi thong tin sql khi ket noi thanh cong
                System.out.println("Driver Name: " + data.getDriverName());
                System.out.println("Driver Version: " + data.getDriverVersion());
                System.out.println("Product Name: " + data.getDatabaseProductName());
                System.out.println("Version: " + data.getDatabaseProductVersion());
            } catch (SQLException ex) {
                System.out.println("Khong the ket noi den CSDL \n" + ex);
            }
        }
        return sConn;
    }
}
