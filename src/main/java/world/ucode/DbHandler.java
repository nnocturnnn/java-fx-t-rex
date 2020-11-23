import org.sqlite.JDBC;
 
import java.sql.*;
import java.util.*;
 
public class DbHandler {

    private static final String CON_STR = "myfin.db";
    private static DbHandler instance = null;
 
    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }
 
    private Connection connection;
 
    private DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }
 
    public List<Score> getAllProducts() {
        try (Statement statement = this.connection.createStatement()) {
            List<Score> products = new ArrayList<Score>();
            ResultSet resultSet = statement.executeQuery("SELECT name, score FROM products ORDER BY score");
            while (resultSet.next()) {
                products.add(new Score(resultSet.getString("name"), resultSet.getInt("score")));
            }
            return products;
 
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addProduct(Product product) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                        "INSERT INTO Products(`name`, `score`) " +
                         "VALUES(?, ?)")) {
            statement.setObject(1, product.name);
            statement.setObject(2, product.score);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}