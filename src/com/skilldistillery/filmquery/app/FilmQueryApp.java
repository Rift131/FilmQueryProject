package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.displayresults.UserResults;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//  private void test() throws SQLException {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//  }

	private void launch() throws SQLException {

		startUserInterface();

		input.close();
		System.out.println("...Program successfully closed.");
		System.exit(0);
	}

	private void startUserInterface() throws SQLException {
		// print menu allowing user to make choices (lookup film by id, lookup by
		// keyword (appears in title or description), and exit the app
		// NOTE: the scanner closes in main, don't close it or change this
		// NOTE: ensure a message prints film not found (null) when appropriate (test
		// this)

		System.out.println("*******************************************");
		System.out.println("**************** Film Query ***************");
		System.out.println("**                                       **");
		System.out.println("** 1. Look Up A Film By Its ID           **");
		System.out.println("** 2. Look Up A Film By A Search Keyword **");
		System.out.println("** 3. Exit The Application               **");
		System.out.println("**                                       **");
		System.out.println("**          Enter the number             **");
		System.out.println("**         matching your choice.         **");
		System.out.println("**                                       **");
		System.out.println("*******************************************");

		int menuChoice;

		try {
			menuChoice = input.nextInt();
			input.nextLine();

			switch (menuChoice) {
			case 1:
				lookUpFilmByIdMenu();
				break;
			case 2:
				lookUpFilmByKeywordMenu();
				break;
			case 3:
				System.out.println("Exiting Program. Have a nice day!");
				break;
			default:
				System.out.println("Unrecognized Entry. Enter 1, 2 or 3 as presented by the menu.");
				startUserInterface();

			}

		} catch (IllegalArgumentException e) {
			System.out.println("EXCEPTION: Unrecognized Entry. Enter 1, 2 or 3 as presented by the menu.");
			input.next();
			launch();
		} catch (InputMismatchException e) {

			System.out.println("EXCEPTION: Unrecognized Entry. Enter 1, 2 or 3 as presented by the menu.");
			input.next();
			launch();
		}

	}

	public void lookUpFilmByIdMenu() throws SQLException {
		System.out.println("\n");
		System.out.println("*******************************************");
		System.out.println("**************** Film Query ***************");
		System.out.println("**                                       **");
		System.out.println("**  Please enter the ID no. of the film  **");
		System.out.println("**            you're looking for.        **");
		System.out.println("**                                       **");
		System.out.println("**                                       **");
		System.out.println("*******************************************");

		try {
			int menuChoice = input.nextInt();
			input.nextLine();

			Film userResult = db.findFilmById(menuChoice);
			UserResults uR = new UserResults();
			System.out.println(uR.filmDetailsDisplay(userResult));

			launch();

		} catch (NullPointerException e) {
			System.out.println("Sorry, no film was found matching that ID number.");
			launch();
		} catch (InputMismatchException e) {
			System.out.println("Sorry, ERROR due to not entering a number.");
			input.next();
			launch();
		}
	}

	public void lookUpFilmByKeywordMenu() throws SQLException {
		System.out.println("*******************************************");
		System.out.println("**************** Film Query ***************");
		System.out.println("**                                       **");
		System.out.println("**            Please enter what          **");
		System.out.println("**            you're looking for.        **");
		System.out.println("**                                       **");
		System.out.println("*******************************************");

		try {
			String menuChoice = input.nextLine();
			ArrayList<Film> userResult = db.findFilmByKeyword(menuChoice);

			UserResults uR = new UserResults();
			System.out.println("\nMovies whose title and/or description match\n your entry include...\n");
			System.out.println(uR.filmDetailsDisplay(userResult));
			launch();

		} catch (IllegalArgumentException e) {
			System.out.println("Sorry, unrecognized Entry");
			launch();
		} catch (NullPointerException e) {
			System.out.println("Sorry, no matches found.");
			launch();
		} catch (Exception e) {
			System.out.println("Sorry, unrecognized Entry");
			launch();
		}
	}

}
