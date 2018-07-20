import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CountryDAO countryDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        countryDAO = new CountryDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertCountry(request, response);
                break;
            case "/delete":
                deleteCountry(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateCountry(request, response);
                break;
            default:
                listCountry(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Country> listCountry = countryDAO.listAllCountry();
        request.setAttribute("listCountry", listCountry);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CountryList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CountryForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int country_id = Integer.parseInt(request.getParameter("country_id"));
        Country existingCountry = countryDAO.getCountry(country_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CountryForm.jsp");
        request.setAttribute("country", existingCountry);
        dispatcher.forward(request, response);
 
    }
 
    private void insertCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String country_name = request.getParameter("country_name");
        String country_abbr = request.getParameter("country_abbr");
         
        Country newCountry = new Country(country_name, country_abbr);
        countryDAO.insertCountry(newCountry);
        response.sendRedirect("list");
    }
 
    private void updateCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int country_id = Integer.parseInt(request.getParameter("country_id"));
        String country_name = request.getParameter("country_name");
        String country_abbr = request.getParameter("country_abbr");
         
        Country country = new Country(country_id, country_name, country_abbr);
        countryDAO.updateCountry(country);
        response.sendRedirect("list");
    }
 
    private void deleteCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int country_id = Integer.parseInt(request.getParameter("country_id"));
        Country country = new Country(country_id);
        countryDAO.deleteCountry(country);
        response.sendRedirect("list");
 
    }
}