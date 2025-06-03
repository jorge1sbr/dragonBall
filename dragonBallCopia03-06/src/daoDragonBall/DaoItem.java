package daoDragonBall;

import modelo.Item;
import java.sql.*;
import java.util.ArrayList;

public class DaoItem {

    private Connection conn;
    private static DaoItem instance = null;

    // Constructor privado para el patrón Singleton
    private DaoItem() throws SQLException {
        conn = DBConnection.getConnection();
    }

    // Método para obtener la única instancia de DaoItem
    public static DaoItem getInstance() throws SQLException {
        if (instance == null) {
            instance = new DaoItem();
        }
        return instance;
    }

    //Obtiene un Item por su ID desde la base de datos.
 
    
    public Item obtenerItemPorId(int id) throws SQLException {
        Item item = null;
        String sql = "SELECT id, nombre, descripcion, tipo, valor_efecto FROM items WHERE id = ?";
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String tipo = rs.getString("tipo");
                int valorEfecto = rs.getInt("valor_efecto");
                item = new Item(id, nombre, descripcion, tipo, valorEfecto);
            }
        } 

        return item;
    }

    //Obtiene un Item por su nombre desde la base de datos.

    public Item obtenerItemPorNombre(String nombre) throws SQLException {
        Item item = null;
        String sql = "SELECT id, nombre, descripcion, tipo, valor_efecto FROM items WHERE nombre = ?";
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nombre);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                String tipo = rs.getString("tipo");
                int valorEfecto = rs.getInt("valor_efecto");
                item = new Item(id, nombre, descripcion, tipo, valorEfecto);
            }
        }

        return item;
    }

    //Obtiene todos los Items disponibles en la base de datos.
    
    public ArrayList<Item> obtenerTodosItems() throws SQLException {
        ArrayList<Item> listaItems = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcion, tipo, valor_efecto FROM items";
        
        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String tipo = rs.getString("tipo");
                int valorEfecto = rs.getInt("valor_efecto");
                listaItems.add(new Item(id, nombre, descripcion, tipo, valorEfecto));
            }
        }
        return listaItems;
    }
}