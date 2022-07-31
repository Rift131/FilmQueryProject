package com.skilldistillery.filmquery.entities;
import java.util.Objects;
public class FilmInventoryStatus {

	private int id;
	private int filmId;
	private int storeId;
	private String filmCondition;
	private String dateAndTimeStamp;
	
	public FilmInventoryStatus() {
		super();
	}
	
	public FilmInventoryStatus(int id, int filmId, int storeId, String filmCondition, String dateAndTimestamp) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.storeId = storeId;
		this.filmCondition = filmCondition;
		this.dateAndTimeStamp = dateAndTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(filmCondition);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateAndTimeStamp, filmCondition, filmId, id, storeId);
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
		FilmInventoryStatus other = (FilmInventoryStatus) obj;
		return Objects.equals(dateAndTimeStamp, other.dateAndTimeStamp)
				&& Objects.equals(filmCondition, other.filmCondition) && filmId == other.filmId && id == other.id
				&& storeId == other.storeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getFilmCondition() {
		return filmCondition;
	}

	public void setFilmCondition(String filmCondition) {
		this.filmCondition = filmCondition;
	}

	public String getDateAndTimestamp() {
		return dateAndTimeStamp;
	}

	public void setDateAndTimestamp(String dateAndTimeStamp) {
		this.dateAndTimeStamp = dateAndTimeStamp;
	}

	
	
	
}
