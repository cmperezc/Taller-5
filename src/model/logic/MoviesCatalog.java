package model.logic;

import java.util.Date;

public class MoviesCatalog {
	

	private int id;
	
	private String actor1_name;
	private int actor1_gender;

	private String actor2_name;
	private int actor2_gender;
	
	private String actor3_name;
	private int actor3_gender;
	
	private String actor4_name;
	private int actor4_gender;
	
	private String actor5_name;
	private int actor5_gender;
	
	private int actor_number;
	
	private String director_name;
	private int director_gender;
	private int director_number;

	private String producer_name;
	private int producer_number;
	
	private String screeplay_name;
	private String editor_name;
	
	private int budget;

	private String genres;

	private String imdb_id;

	private String original_language;

	private String original_title;

	private String overview;

	private double popularity;

	private String production_companies;

	private String production_countries;

	private Date release_date;

	private int revenue;

	private int runtime;

	private String spoken_languages;

	private String status;

	private String tagline;
	
	private String title;

	private double vote_average;

	private int vote_count;

	private int production_companies_number;
	
	private int production_countries_number;
	
	private int spoken_languages_number;
	

	public MoviesCatalog(int id, String actor1_name, int actor1_gender, String actor2_name, int actor2_gender,
			String actor3_name, int actor3_gender, String actor4_name, int actor4_gender, String actor5_name,
			int actor5_gender, int actor_number, String director_name, int director_gender, int director_number,
			String producer_name, int producer_number, String screeplay_name, String editor_name, int budget,
			String genres, String imdb_id, String original_language, String original_title, String overview,
			double popularity, String production_companies, String production_countries, Date release_date, int revenue,
			int runtime, String spoken_languages, String status, String tagline, String title, double vote_average,
			int vote_count, int production_companies_number, int production_countries_number,
			int spoken_languages_number) {
		super();
		this.id = id;
		this.actor1_name = actor1_name;
		this.actor1_gender = actor1_gender;
		this.actor2_name = actor2_name;
		this.actor2_gender = actor2_gender;
		this.actor3_name = actor3_name;
		this.actor3_gender = actor3_gender;
		this.actor4_name = actor4_name;
		this.actor4_gender = actor4_gender;
		this.actor5_name = actor5_name;
		this.actor5_gender = actor5_gender;
		this.actor_number = actor_number;
		this.director_name = director_name;
		this.director_gender = director_gender;
		this.director_number = director_number;
		this.producer_name = producer_name;
		this.producer_number = producer_number;
		this.screeplay_name = screeplay_name;
		this.editor_name = editor_name;
		this.budget = budget;
		this.genres = genres;
		this.imdb_id = imdb_id;
		this.original_language = original_language;
		this.original_title = original_title;
		this.overview = overview;
		this.popularity = popularity;
		this.production_companies = production_companies;
		this.production_countries = production_countries;
		this.release_date = release_date;
		this.revenue = revenue;
		this.runtime = runtime;
		this.spoken_languages = spoken_languages;
		this.status = status;
		this.tagline = tagline;
		this.title = title;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.production_companies_number = production_companies_number;
		this.production_countries_number = production_countries_number;
		this.spoken_languages_number = spoken_languages_number;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getActor1_name() {
		return actor1_name;
	}


	public void setActor1_name(String actor1_name) {
		this.actor1_name = actor1_name;
	}


	public int getActor1_gender() {
		return actor1_gender;
	}


	public void setActor1_gender(int actor1_gender) {
		this.actor1_gender = actor1_gender;
	}


	public String getActor2_name() {
		return actor2_name;
	}


	public void setActor2_name(String actor2_name) {
		this.actor2_name = actor2_name;
	}


	public int getActor2_gender() {
		return actor2_gender;
	}


	public void setActor2_gender(int actor2_gender) {
		this.actor2_gender = actor2_gender;
	}


	public String getActor3_name() {
		return actor3_name;
	}


	public void setActor3_name(String actor3_name) {
		this.actor3_name = actor3_name;
	}


	public int getActor3_gender() {
		return actor3_gender;
	}


	public void setActor3_gender(int actor3_gender) {
		this.actor3_gender = actor3_gender;
	}


	public String getActor4_name() {
		return actor4_name;
	}


	public void setActor4_name(String actor4_name) {
		this.actor4_name = actor4_name;
	}


	public int getActor4_gender() {
		return actor4_gender;
	}


	public void setActor4_gender(int actor4_gender) {
		this.actor4_gender = actor4_gender;
	}


	public String getActor5_name() {
		return actor5_name;
	}


	public void setActor5_name(String actor5_name) {
		this.actor5_name = actor5_name;
	}


	public int getActor5_gender() {
		return actor5_gender;
	}


	public void setActor5_gender(int actor5_gender) {
		this.actor5_gender = actor5_gender;
	}


	public int getActor_number() {
		return actor_number;
	}


	public void setActor_number(int actor_number) {
		this.actor_number = actor_number;
	}


	public String getDirector_name() {
		return director_name;
	}


	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}


	public int getDirector_gender() {
		return director_gender;
	}


	public void setDirector_gender(int director_gender) {
		this.director_gender = director_gender;
	}


	public int getDirector_number() {
		return director_number;
	}


	public void setDirector_number(int director_number) {
		this.director_number = director_number;
	}


	public String getProducer_name() {
		return producer_name;
	}


	public void setProducer_name(String producer_name) {
		this.producer_name = producer_name;
	}


	public int getProducer_number() {
		return producer_number;
	}


	public void setProducer_number(int producer_number) {
		this.producer_number = producer_number;
	}


	public String getScreeplay_name() {
		return screeplay_name;
	}


	public void setScreeplay_name(String screeplay_name) {
		this.screeplay_name = screeplay_name;
	}


	public String getEditor_name() {
		return editor_name;
	}


	public void setEditor_name(String editor_name) {
		this.editor_name = editor_name;
	}


	public int getBudget() {
		return budget;
	}


	public void setBudget(int budget) {
		this.budget = budget;
	}


	public String getGenres() {
		return genres;
	}


	public void setGenres(String genres) {
		this.genres = genres;
	}


	public String getImdb_id() {
		return imdb_id;
	}


	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}


	public String getOriginal_language() {
		return original_language;
	}


	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}


	public String getOriginal_title() {
		return original_title;
	}


	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public double getPopularity() {
		return popularity;
	}


	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}


	public String getProduction_companies() {
		return production_companies;
	}


	public void setProduction_companies(String production_companies) {
		this.production_companies = production_companies;
	}


	public String getProduction_countries() {
		return production_countries;
	}


	public void setProduction_countries(String production_countries) {
		this.production_countries = production_countries;
	}


	public Date getRelease_date() {
		return release_date;
	}


	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}


	public int getRevenue() {
		return revenue;
	}


	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}


	public int getRuntime() {
		return runtime;
	}


	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}


	public String getSpoken_languages() {
		return spoken_languages;
	}


	public void setSpoken_languages(String spoken_languages) {
		this.spoken_languages = spoken_languages;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTagline() {
		return tagline;
	}


	public void setTagline(String tagline) {
		this.tagline = tagline;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getVote_average() {
		return vote_average;
	}


	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}


	public int getVote_count() {
		return vote_count;
	}


	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}


	public int getProduction_companies_number() {
		return production_companies_number;
	}


	public void setProduction_companies_number(int production_companies_number) {
		this.production_companies_number = production_companies_number;
	}


	public int getProduction_countries_number() {
		return production_countries_number;
	}


	public void setProduction_countries_number(int production_countries_number) {
		this.production_countries_number = production_countries_number;
	}


	public int getSpoken_languages_number() {
		return spoken_languages_number;
	}


	public void setSpoken_languages_number(int spoken_languages_number) {
		this.spoken_languages_number = spoken_languages_number;
	}

	

	

}
