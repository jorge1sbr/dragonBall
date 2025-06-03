package daoDragonBall;

import modelo.Inventario;
import modelo.Item;
import modelo.Protagonista; // Necesitamos el ID del protagonista
import java.sql.*;
import java.util.Map;

public class DaoInventario {

    private Connection conn;
    private static DaoInventario instance = null;

    // Constructor privado para el patrón Singleton
    private DaoInventario() throws SQLException {
        conn = DBConnection.getConnection();
    }

    // Método para obtener la única instancia de DaoInventario
    public static DaoInventario getInstance() throws SQLException {
        if (instance == null) {
            instance = new DaoInventario();
        }
        return instance;
    }

    public void guardarInventario(int protagonistaId, Inventario inventario) throws SQLException {
        // 1. Borrar el inventario existente para este protagonista
        String deleteSql = "DELETE FROM inventario WHERE personaje_id = ?";
        try (PreparedStatement deleteStatement = conn.prepareStatement(deleteSql)) {
            deleteStatement.setInt(1, protagonistaId);
            deleteStatement.executeUpdate();
            System.out.println("Inventario anterior del protagonista " + protagonistaId + " borrado.");
        }

        // 2. Insertar cada ítem del inventario actual
        String insertSql = "INSERT INTO inventario (personaje_id, item_id, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
            for (Map.Entry<Item, Integer> entry : inventario.getItems().entrySet()) {
                Item item = entry.getKey();
                int cantidad = entry.getValue();

                insertStatement.setInt(1, protagonistaId);
                insertStatement.setInt(2, item.getId()); 
                insertStatement.setInt(3, cantidad);
                insertStatement.addBatch();
            }
            insertStatement.executeBatch(); // Ejecuta todas las inserciones en un solo viaje a la DB
            System.out.println("Inventario del protagonista " + protagonistaId + " guardado exitosamente.");
        }
    }

    
    public Inventario cargarInventario(int protagonistaId) throws SQLException {
        Inventario inventario = new Inventario();
        DaoItem daoItem = DaoItem.getInstance();

        String sql = "SELECT item_id, cantidad FROM inventario WHERE personaje_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, protagonistaId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int itemId = rs.getInt("item_id");
                int cantidad = rs.getInt("cantidad");

                Item item = daoItem.obtenerItemPorId(itemId); // Obtenemos el objeto Item completo
                if (item != null) {
                    // Agregamos el ítem al inventario. Usamos el método interno de Inventario.
                    inventario.agregarItem(item, cantidad);
                } else {
                    System.err.println("Advertencia: Item con ID " + itemId + " no encontrado en la base de datos. No se pudo cargar en el inventario.");
                }
            }
            System.out.println("Inventario del protagonista " + protagonistaId + " cargado exitosamente.");
        }
        return inventario;
    }
}