package Persistence;

import java.sql.*;
import domein.DomeinController;

public class ScoreMapper {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/coloretto?user=coloretto.user&password=Coloretto&serverTimezone=UTC&useSSL=false";
    public void scoreUploaden(DomeinController dc)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryScoreToevoegen = conn.prepareStatement("INSERT INTO colorettouserdata VALUES (?, ?)");

            queryScoreToevoegen.setString(2, dc.getSpelers().get(1).getNaam());
            queryScoreToevoegen.setInt(3, dc.getSpelers().get(1).getScore());
            queryScoreToevoegen.executeUpdate();

            queryScoreToevoegen.setString(2, dc.getSpelers().get(2).getNaam());
            queryScoreToevoegen.setInt(3, dc.getSpelers().get(2).getScore());
            queryScoreToevoegen.executeUpdate();
            
            queryScoreToevoegen.setString(2, dc.getSpelers().get(3).getNaam());
            queryScoreToevoegen.setInt(3, dc.getSpelers().get(3).getScore());
            queryScoreToevoegen.executeUpdate();
            
            queryScoreToevoegen.setString(2, dc.getSpelers().get(4).getNaam());
            queryScoreToevoegen.setInt(3,dc.getSpelers().get(4).getScore());
            queryScoreToevoegen.executeUpdate();
            
            if (dc.getSpelers().size() == 5) {
                queryScoreToevoegen.setString(2, dc.getSpelers().get(5).getNaam());
                queryScoreToevoegen.setInt(3,dc.getSpelers().get(5).getScore());
                queryScoreToevoegen.executeUpdate();
            }
        } catch (SQLException exception) {
            for (Throwable ex : exception) {
                ex.printStackTrace();
            }
        }
    }
}
