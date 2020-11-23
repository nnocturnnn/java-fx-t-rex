import org.sqlite.JDBC;
 
import java.sql.*;
import java.util.*;
 
public class DbHandler {

    private static final String CON_STR = "jdbc:sqlite:D:/myfin.db";
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
 
    public List<Product> getAllProducts() {
        try (Statement statement = this.connection.createStatement()) {
            List<Product> products = new ArrayList<Product>();
            ResultSet resultSet = statement.executeQuery("SELECT id, good, price, category_name FROM products ORDER BY score");
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                                            resultSet.getString("good"));
            }
            return products;
 
        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }

    public void addProduct(Product product) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                        "INSERT INTO Products(`good`, `price`, `category_name`) " +
                         "VALUES(?, ?, ?)")) {
            statement.setObject(1, product.good);
            statement.setObject(2, product.price);
            statement.setObject(3, product.category_name);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Products WHERE id = ?")) {
            statement.setObject(1, id);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}