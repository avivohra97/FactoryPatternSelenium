package DriverFactoryPattern;
public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager = null;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                break;
        }
        return driverManager;
    }
}
