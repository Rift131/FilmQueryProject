package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class FilmCategory {

	private int id;
	private int catId;
	
	public FilmCategory() {
		super();
	}

	public FilmCategory(int id, int catId) {
		super();
		this.id = id;
		this.catId = catId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film Category: ").append(catId);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, catId);
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
		FilmCategory other = (FilmCategory) obj;
		return id == other.id && Objects.equals(catId, other.catId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getcatId() {
		return catId;
	}

	public void setcatId(int catId) {
		this.catId = catId;
	}
	
	
}
