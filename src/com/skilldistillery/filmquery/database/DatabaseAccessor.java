package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.FilmCategory;
import com.skilldistillery.filmquery.entities.FilmInventoryStatus;
import com.skilldistillery.filmquery.entities.FilmLanguage;

public interface DatabaseAccessor {
	public ArrayList<Film> findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;

	public FilmLanguage findLanguageById(int langId) throws SQLException;

	public ArrayList<Film> findFilmByKeyword(String userInput) throws SQLException;

	public Category findFilmCategoryById(int filmID) throws SQLException;

	public FilmInventoryStatus findFilmInventoryStatusById(int filmID) throws SQLException;

	

}
