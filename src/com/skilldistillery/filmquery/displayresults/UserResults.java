package com.skilldistillery.filmquery.displayresults;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Film;

public class UserResults {

	public UserResults() {
		
	}
	
	public StringBuilder filmDetailsDisplay(Film film) {
		StringBuilder userFilmDetails = new StringBuilder();
		 
			 userFilmDetails.append(film.getTitle());
			 userFilmDetails.append(", ");
			 userFilmDetails.append(film.getYear());
			 userFilmDetails.append(", ");
			 userFilmDetails.append(film.getRating());
			 userFilmDetails.append(", ");
			 userFilmDetails.append(film.getLanguage());
			 userFilmDetails.append(", ");
			 userFilmDetails.append(film.getDescription());
			 userFilmDetails.append(", ");
			 userFilmDetails.append(film.getFilmCast());
		 
		return userFilmDetails;
	}


public StringBuilder filmDetailsDisplay(ArrayList<Film> filmList) {
	StringBuilder userFilmDetails = new StringBuilder();
	ArrayList<Film> usersMatches = filmList;
	int movieCounter = 1;
	
	for (Film movie : usersMatches) {
		userFilmDetails.append(movieCounter + ". ");
		 userFilmDetails.append(movie.getTitle());
		 userFilmDetails.append(", ");
		 userFilmDetails.append(movie.getYear());
		 userFilmDetails.append(", ");
		 userFilmDetails.append(movie.getRating());
		 userFilmDetails.append(", ");
		 userFilmDetails.append(movie.getLanguage());
		 userFilmDetails.append(",\n ");
		 userFilmDetails.append(movie.getDescription());
		 userFilmDetails.append(",\n ");
		 userFilmDetails.append(movie.getFilmCast());
		 userFilmDetails.append("/n");
		 userFilmDetails.append("/n");
		 movieCounter++;
	}
	return userFilmDetails;
}
}
