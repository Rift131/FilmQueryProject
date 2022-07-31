package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.FilmInventoryStatus;
import com.skilldistillery.filmquery.entities.FilmLanguage;

// 
public class DatabaseAccessorObject implements DatabaseAccessor {

	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Film> findFilmById(int filmId) throws SQLException {
		// TODO: connection, Prepared Statement, execute Query, Result set, create Film
		Film film = null;
		ArrayList<Film> allCopies = new ArrayList<Film>();
		// Log in to the DB
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);

		// Query Code
		String sqltext;
		sqltext = "SELECT * FROM film flm JOIN inventory_item ii ON flm.id = ii.film_id WHERE ii.film_id = ?;";

		// Prepared Statement
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmId);

		ResultSet foundFilm = stmt.executeQuery();

		while (foundFilm.next()) {

			film = new Film();
			film.setId(foundFilm.getInt("id"));
			film.setTitle(foundFilm.getString("title"));
			film.setDescription(foundFilm.getString("description"));
			film.setYear(foundFilm.getInt("release_year"));
			film.setLanguageId(foundFilm.getInt("language_id"));
			film.setRentalDuration(foundFilm.getInt("rental_duration"));
			film.setRentalRate(foundFilm.getDouble("rental_rate"));
			film.setLength(foundFilm.getInt("length"));
			film.setReplacementCost(foundFilm.getDouble("replacement_cost"));
			film.setRating(foundFilm.getString("rating"));
			film.setSpecialFeatures(foundFilm.getString("special_features"));
			film.setFilmCast(findActorsByFilmId(filmId));
			film.setLanguage(findLanguageById(filmId));
			film.setFilmCategory(findFilmCategoryById(filmId));
			film.setFilmInventoryStatus(findFilmInventoryStatusById(filmId));

			allCopies.add(film);
		}

		foundFilm.close();
		stmt.close();
		conn.close();

		if (allCopies.size() > 0) {
			return allCopies;
		}
		return null;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		// TODO Auto-generated method stub
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);

		String sqltext;
		sqltext = "SELECT * FROM actor WHERE id = ?;";

		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, actorId);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(rs.getInt("id"));
			actor.setLastName(rs.getString("last_name"));
			actor.setFirstName(rs.getString("first_name"));
		}

		rs.close();
		stmt.close();
		conn.close();

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		// TODO Auto-generated method stub

		ArrayList<Actor> movieActors = new ArrayList<>();
		Actor actor = new Actor();

		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);

		String sqltext;
		sqltext = "SELECT *\n" + "FROM actor act JOIN film_actor fa ON act.id = fa.actor_id\n"
				+ "               JOIN film flm ON fa.film_id = flm.id\n" + "WHERE flm.id = ?\n"
				+ "ORDER BY act.last_name;";

		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();
		// iterate over the contents and populate the array

		while (rs.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(rs.getInt("id"));
			actor.setLastName(rs.getString("last_name"));
			actor.setFirstName(rs.getString("first_name"));
			movieActors.add(actor);
		}

		rs.close();
		stmt.close();
		conn.close();

		if (movieActors.size() > 0) {
			return movieActors;
		}

		return null;
	}

	// NEW DATABASE METHODS THAT RETURN SPECIFIC OBJECTS

	@Override
	public FilmLanguage findLanguageById(int filmId) throws SQLException {
		FilmLanguage filmLang = null;

		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);

		String sqltext;
		sqltext = "SELECT *\n" + "FROM language lang JOIN film flm ON lang.id = flm.language_id\n"
				+ "WHERE flm.id = ?;";

		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			filmLang = new FilmLanguage();

			filmLang.setLanguageId(rs.getInt("id"));
			filmLang.setLanguageName(rs.getString("name"));

		}

		rs.close();
		stmt.close();
		conn.close();

		return filmLang;
	}

	@Override
	public ArrayList<Film> findFilmByKeyword(String userInput) throws SQLException {
		// TODO: connection, Prepared Statement, execute Query, Result set, create Film
		ArrayList<Film> filmMatches = new ArrayList<>();
		Film film = null;
		// Log in to the DB
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);

		// Query Code
		String sqltext;
		sqltext = "SELECT *\n" + "FROM film flm JOIN inventory_item ii ON flm.id = ii.film_id \n"
				+ "WHERE flm.title LIKE ? OR flm.description LIKE ?;";
		// Prepared Statement
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		String keyword = "%" + userInput + "%";
		stmt.setString(1, keyword); // Problem point
		stmt.setString(2, keyword);

		ResultSet foundFilm = stmt.executeQuery();

		while (foundFilm.next()) {

			film = new Film();
			film.setId(foundFilm.getInt("id"));
			film.setTitle(foundFilm.getString("title"));
			film.setDescription(foundFilm.getString("description"));
			film.setYear(foundFilm.getInt("release_year"));
			film.setLanguageId(foundFilm.getInt("language_id"));
			film.setRentalDuration(foundFilm.getInt("rental_duration"));
			film.setRentalRate(foundFilm.getDouble("rental_rate"));
			film.setLength(foundFilm.getInt("length"));
			film.setReplacementCost(foundFilm.getDouble("replacement_cost"));
			film.setRating(foundFilm.getString("rating"));
			film.setSpecialFeatures(foundFilm.getString("special_features"));
			film.setFilmCast(findActorsByFilmId(foundFilm.getInt("id")));
			film.setLanguage(findLanguageById(foundFilm.getInt("id")));
			film.setFilmCategory(findFilmCategoryById(foundFilm.getInt("id")));
			film.setFilmInventoryStatus(findFilmInventoryStatusById(foundFilm.getInt("id")));
			filmMatches.add(film);
		}

		foundFilm.close();
		stmt.close();
		conn.close();

		if (filmMatches.size() > 0) {
			return filmMatches;
		}
		return null;
	}

	@Override
	public Category findFilmCategoryById(int filmID) throws SQLException {
		Category flmCat = null;
		// TODO Auto-generated method stub
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);

		String sqltext;
		sqltext = "SELECT cat.name\n" + "FROM film flm JOIN film_category fc ON flm.id = fc.film_id\n"
				+ "              JOIN category cat ON fc.category_id = cat.id\n" + "WHERE flm.id = ?;";

		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmID);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			flmCat = new Category(); // Create the object
			// Here is our mapping of query columns to our object fields:
			flmCat.setName(rs.getString("name"));
		}

		rs.close();
		stmt.close();
		conn.close();

		return flmCat;
	}

	@Override
	public FilmInventoryStatus findFilmInventoryStatusById(int filmID) throws SQLException {
		FilmInventoryStatus status = null;
		// TODO Auto-generated method stub
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);

		String sqltext;
		sqltext = "SELECT * FROM inventory_item WHERE id = ?;";

		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmID);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			status = new FilmInventoryStatus(); // Create the object
			// Here is our mapping of query columns to our object fields:
			status.setId(rs.getInt("id"));
			status.setFilmId(rs.getInt("film_id"));
			status.setStoreId(rs.getInt("store_id"));
			status.setFilmCondition(rs.getString("media_condition"));
			status.setDateAndTimestamp(rs.getString("last_update"));
		}

		rs.close();
		stmt.close();
		conn.close();

		return status;
	}
}
