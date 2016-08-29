import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for(String name : properties.stringPropertyNames()){
            System.out.println(name + ":" +properties.getProperty(name));
        }
    }
}
