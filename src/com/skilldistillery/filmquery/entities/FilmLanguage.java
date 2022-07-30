package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class FilmLanguage {

	private int languageId;
	private String languageName;
	
	public FilmLanguage() {
		super();
	}

	public FilmLanguage(int languageId, String languageName) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilmLanguage [languageId=").append(languageId).append(", languageName=").append(languageName)
				.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(languageId, languageName);
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
		FilmLanguage other = (FilmLanguage) obj;
		return languageId == other.languageId && Objects.equals(languageName, other.languageName);
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
}
