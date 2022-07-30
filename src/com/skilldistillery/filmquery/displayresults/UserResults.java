package com.skilldistillery.filmquery.displayresults;

import java.util.ArrayList;

import com.skilldistillery.filmquery.entities.Film;

public class UserResults {

	public UserResults() {
		
	}
	
	public StringBuilder filmDetailsDisplay(Film film) {
		StringBuilder userFilmDetails = new StringBuilder();
		 
			 userFilmDetails.append(film.toCustomerString().replace("[", "").replace("]", ""));
		 
		return userFilmDetails;
	}


public StringBuilder filmDetailsDisplay(ArrayList<Film> filmList) {
	StringBuilder userFilmDetails = new StringBuilder();
	ArrayList<Film> usersMatches = filmList;
	int movieCounter = 1;
	//System.out.println(filmList);
	for (Film movie : usersMatches) {
		String eachMovie = movieCounter + ". " + movie.toCustomerString().replace("[", "").replace("]", "") + "\n";
		userFilmDetails.append(eachMovie);
		movieCounter++;
	}
	return userFilmDetails;
}
}
