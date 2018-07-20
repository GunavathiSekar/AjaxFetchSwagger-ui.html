import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table Country
 * in the database.
 * @author www.codejava.net
 *
 */
public class CountryDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public CountryDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = "jdbc:mysql://localhost:3306/country";
        this.jdbcUsername = "root";
        this.jdbcPassword = "";
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertCountry(Country country) throws SQLException {
        String sql = "INSERT INTO country (country_name, country_abbr) VALUES (?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, country.getCountry_name());
        statement.setString(2, country.getCountry_abbr());
                
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Country> listAllCountry() throws SQLException {
        List<Country> listCountry = new ArrayList<>();
         
        String sql = "SELECT * FROM country";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int country_id = resultSet.getInt("country_id");
            String country_name = resultSet.getString("country_name");
            String country_abbr = resultSet.getString("country_abbr");
            
             
            Country country = new Country(country_id, country_name, country_abbr);
            listCountry.add(country);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCountry;
    }
     
    public boolean deleteCountry(Country country) throws SQLException {
        String sql = "DELETE FROM country where country_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, country.getCountry_id());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateCountry(Country country) throws SQLException {
        String sql = "UPDATE country SET country_name = ?, country_abbr = ?";
        sql += " WHERE country_country_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, country.getCountry_name());
        statement.setString(2, country.getCountry_abbr());
        statement.setInt(3, country.getCountry_id());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Country getCountry(int country_id) throws SQLException {
        Country country = null;
        String sql = "SELECT * FROM country WHERE country_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, country_id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String country_name = resultSet.getString("country_name");
            String country_abbr = resultSet.getString("country_abbr");
            
             
            country = new Country(country_id, country_name, country_abbr);
        }
         
        resultSet.close();
        statement.close();
         
        return country;
    }
}