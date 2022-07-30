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
	
	public Film() {
		super();
	}

	public Film(int id, String title, String description, int year, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			ArrayList<Actor> filmCast, FilmLanguage language) {
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
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=").append(id).append(", title=").append(title).append(", description=")
				.append(description).append(", year=").append(year).append(", languageId=").append(languageId)
				.append(", rentalDuration=").append(rentalDuration).append(", rentalRate=").append(rentalRate)
				.append(", length=").append(length).append(", replacementCost=").append(replacementCost)
				.append(", rating=").append(rating).append(", specialFeatures=").append(specialFeatures)
				.append(", filmCast=").append(filmCast).append(", language=").append(language).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, filmCast, id, language, languageId, length, rating, rentalDuration, rentalRate,
				replacementCost, specialFeatures, title, year);
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
				&& id == other.id && Objects.equals(language, other.language) && languageId == other.languageId
				&& length == other.length && Objects.equals(rating, other.rating)
				&& rentalDuration == other.rentalDuration
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

	public void setLanguage(FilmLanguage filmLanguage) {
		this.language = filmLanguage;
	}
	
	
}
