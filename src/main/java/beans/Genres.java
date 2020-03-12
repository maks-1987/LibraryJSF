package beans;

import db.Database;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@ApplicationScoped
public class Genres implements Serializable {
    private ArrayList<Genre> genreArrayList = new ArrayList<>();

    private ArrayList<Genre> getGenreArrayList() { // метод для получения списка жанров
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = Database.getConnection();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("select * from library.genre order by name");

            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setName(resultSet.getString("name"));
                genre.setId(resultSet.getLong("id"));
//                Genre genre = new Genre(resultSet.getString("name"), resultSet.getLong("id"));
                genreArrayList.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return genreArrayList;
    }

    public ArrayList<Genre> getGenreList() {
        if (genreArrayList.isEmpty()) {
            return genreArrayList;
        } else {
            return getGenreArrayList();
        }
    }

}
