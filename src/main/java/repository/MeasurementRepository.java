package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MeasurementRepository {

    public void save(double value, String unit) {
        String query = "INSERT INTO measurements (value, unit) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, value);
            stmt.setString(2, unit);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}