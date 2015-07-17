/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductResource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import DatabaseConnection.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 *
 * @author c0652863
 */
@Path("product")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    Connection connection;

    Product p = new Product();
    ArrayList<Product> products = new ArrayList<>();

    public GenericResource() {

    }

    /**
     * Retrieves representation of an instance of
     * com.assignment4.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/products")
    @Produces("application/json")
    public ArrayList<Product> getJson() throws SQLException {

        connection = DatabaseConnectivity.getConnection();
        String query = "select * from product";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {

            Product pnew = new Product(rs.getInt("ProductID"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"));
            products.add(pnew);

        }

        return products;
    }

    @GET
    @Path("/products/{productid}")
    @Produces("application/json")
    public ArrayList<Product> getJsonOne(@PathParam("productid") int productid) throws SQLException {

        connection = DatabaseConnectivity.getConnection();
        String query = "";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from product where ProductID=" + productid);

        while (rs.next()) {

            Product newProduct = new Product(rs.getInt("ProductID"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"));
            products.add(newProduct);

        }

        return products;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Path("/products1")
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public void postJson(String content) throws ParseException, SQLException {

        JSONParser jsonpraser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonpraser.parse(content);

        Object objectId = jsonObject.get("id");
        String ProductID = objectId.toString();
        int id = Integer.parseInt(ProductID);

        Object objectName = jsonObject.get("name");
        String name = objectName.toString();

        Object objectDescription = jsonObject.get("description");
        String description = objectDescription.toString();

        Object objectQuantity = jsonObject.get("quantity");
        String quantity_new = objectQuantity.toString();
        int quantity = Integer.parseInt(quantity_new);

        connection = DatabaseConnectivity.getConnection();

        String query = "insert into product(ProductID, name, description, quantity) values('" + id + "','" + name + "','" + description + "','" + quantity + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }

    @PUT
    @Path("/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public void putProduct(String content) throws SQLException, ParseException {

        JSONParser jsonparser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonparser.parse(content);

        Object objectId = jsonObject.get("id");
        String ProductID = objectId.toString();
        int id = Integer.parseInt(ProductID);

        Object objectName = jsonObject.get("name");
        String name = objectName.toString();

        Object objectDescription = jsonObject.get("description");
        String description = objectDescription.toString();

        Object objectQuantity = jsonObject.get("quantity");
        String quantity_new = objectQuantity.toString();
        int quantity = Integer.parseInt(quantity_new);

        connection = DatabaseConnectivity.getConnection();

        String query = "insert into product(ProductID, name, description, quantity) values('" + id + "','" + name + "','" + description + "','" + quantity + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }

    @DELETE
    @Path("/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public void deleteProduct(String content) throws SQLException, ParseException {

        JSONParser jsonparser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonparser.parse(content);

        Object objectId = jsonObject.get("id");
        String ProductID = objectId.toString();
        int id = Integer.parseInt(ProductID);

        Object objectName = jsonObject.get("name");
        String name = objectName.toString();

        Object objectDescription = jsonObject.get("description");
        String description = objectDescription.toString();

        Object objectQuantity = jsonObject.get("quantity");
        String quantity_new = objectQuantity.toString();
        int quantity = Integer.parseInt(quantity_new);

        connection = DatabaseConnectivity.getConnection();

        String query = "insert into product(ProductID, name, description, quantity) values('" + id + "','" + name + "','" + description + "','" + quantity + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
