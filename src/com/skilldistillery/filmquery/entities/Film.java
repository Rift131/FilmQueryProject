package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private int year;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private ArrayList<Actor> filmCast;
	private FilmLanguage language;
	private Category filmCategory;
	private FilmInventoryStatus filmInventoryStatus;

	public Film() {
		super();
	}

	public Film(int id, String title, String description, int year, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			ArrayList<Actor> filmCast, FilmLanguage language, Category filmCategory, FilmInventoryStatus filmInventoryStatus) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.year = year;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.filmCast = filmCast;
		this.language = language;
		this.filmCategory = filmCategory;
		this.filmInventoryStatus = filmInventoryStatus;
	}


	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film ID: ").append(id).append(", Title: ").append(title).append("\n").append("Description: ")
				.append(description).append("\n").append("Year: ").append(year).append(", Language Id Number: ").append(languageId).append(", Language: ").append(language).append("\n")
				.append("Rental Duration: ").append(rentalDuration).append(", Rental Rate: ").append(rentalRate)
				.append(", Length: ").append(length).append(", Replacement Cost: ").append(replacementCost).append("\n")
				.append("Rating: ").append(rating).append(", Special Features: ").append(specialFeatures).append("\n")
				.append("Film Cast: ").append(filmCast).append("Film Category: ")
				.append(filmCategory).append(", Film Inventory Status: ").append(filmInventoryStatus).append(".\n");
		return builder.toString();
	}

	public String toCustomerString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Title: ").append(title).append(", Category: ").append(filmCategory).append(", Year: ").append(year).append(", Rating: ").append(rating).append("\n").append("Language: ").append(language).append(", Film Condition: ").append(filmInventoryStatus).append("\n").append("Description: ")
				.append(description).append(".\n").append("Film Cast: ").append(filmCast).append(".\n");
		return builder.toString();
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(description, filmCast, filmCategory, filmInventoryStatus, id, language, languageId, length,
				rating, rentalDuration, rentalRate, replacementCost, specialFeatures, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && Objects.equals(filmCast, other.filmCast)
				&& Objects.equals(filmCategory, other.filmCategory)
				&& Objects.equals(filmInventoryStatus, other.filmInventoryStatus) && id == other.id
				&& Objects.equals(language, other.language) && languageId == other.languageId && length == other.length
				&& Objects.equals(rating, other.rating) && rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title)
				&& year == other.year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public ArrayList<Actor> getFilmCast() {
		return filmCast;
	}

	public void setFilmCast(List<Actor> list) {
		this.filmCast = (ArrayList<Actor>) list;
	}

	public FilmLanguage getLanguage() {
		return language;
	}

	public void setLanguage(FilmLanguage language) {
		this.language = language;
	}

	public Category getFilmCategory() {
		return filmCategory;
	}

	public void setFilmCategory(Category filmCategory) {
		this.filmCategory = filmCategory;
	}

	public FilmInventoryStatus getFilmInventoryStatus() {
		return filmInventoryStatus;
	}

	public void setFilmInventoryStatus(FilmInventoryStatus filmInventoryStatus) {
		this.filmInventoryStatus = filmInventoryStatus;
	}

	
}
