import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while(drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            String bdDriverName = driver.getClass().getName();
            int bdDriverVersion = driver.getMajorVersion();

            System.out.printf("BD: %s - Version: %d", bdDriverName, bdDriverVersion);
        }
    }
}
