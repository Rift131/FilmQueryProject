package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.FilmInventoryStatus;
import com.skilldistillery.filmquery.entities.FilmLanguage;

class DatabaseAccessorObjectTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }
  
  @Test
  void test_getFilmById_returns_film_with_id_and_verifies_expected_title() throws SQLException {
    ArrayList<Film> f = db.findFilmById(1);
    assertNotNull(f);
    assertEquals("ACADEMY DINOSAUR", f.get(1).getTitle());
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() throws SQLException {
    ArrayList<Film> f = db.findFilmById(-42);
    assertNull(f);
  }
  
  @Test
  void test_findActorById_with_invalid_id_returns_null() throws SQLException {
	  Actor f = db.findActorById(-151);
	  assertNull(f);
  }
  
  @Test
  void test_findActorById_with_valid_id_and_verifies_expected_last_name() throws SQLException {
	  Actor f = db.findActorById(1);
	  assertNotNull(f);
	  assertEquals("Guiness", f.getLastName());
  }
  
  @Test
  void test_findActorsByFilmId_with_invalid_id_returns_null() throws SQLException {
	  List<Actor> f = db.findActorsByFilmId(-151);
	  assertNull(f);
  }
  
  @Test
  void test_findActorsByFilmId_with_valid_id_and_verifies_expected_last_name() throws SQLException {
	  List<Actor> f = db.findActorsByFilmId(1);
	  assertNotNull(f);
	  assertEquals("Dukakis", f.get(1).getLastName());
  }
  
  @Test
  void test_findLanguageById_with_invalid_id_returns_null() throws SQLException {
	  FilmLanguage f = db.findLanguageById(-151);
	  assertNull(f);
  }
  
  @Test
  void test_findLanguageById_with_valid_id_and_verifies_expected_language() throws SQLException {
	  FilmLanguage f = db.findLanguageById(1);
	  assertNotNull(f);
	  assertEquals("Japanese", f.getLanguageName());
  }
  
  @Test
  void test_findFilmByKeyword_with_non_exsistant_input_returns_null() throws SQLException {
	  List<Film> f = db.findFilmByKeyword("golf");
	  assertNull(f);
  }
  
  @Test
  void test_findFilmByKeyword_with_valid_id_and_verifies_expected_last_name() throws SQLException {
	  List<Actor> f = db.findActorsByFilmId(1);
	  assertNotNull(f);
	  assertEquals("Dukakis", f.get(1).getLastName());
  }
  
  @Test
  void test_findFilmCategoryById_with_invalid_id_returns_null() throws SQLException {
	  Category f = db.findFilmCategoryById(-151);
	  assertNull(f);
  }
  
  @Test
  void test_findFilmCategoryById_with_valid_id_and_verifies_expected_language() throws SQLException {
	  Category f = db.findFilmCategoryById(1);
	  assertNotNull(f);
	  assertEquals("Documentary", f.getName());
  }
  
  @Test
  void test_findFilmInventoryStatusById_with_invalid_id_returns_null() throws SQLException {
	  FilmInventoryStatus f = db.findFilmInventoryStatusById(-151);
	  assertNull(f);
  }
  
  @Test
  void test_findFilmInventoryStatusById_with_valid_id_and_verifies_expected_language() throws SQLException {
	  FilmInventoryStatus f = db.findFilmInventoryStatusById(1);
	  assertNotNull(f);
	  assertEquals("Used", f.getFilmCondition());
  }
}
