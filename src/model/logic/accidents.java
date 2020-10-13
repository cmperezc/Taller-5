package model.logic;

import java.sql.Time;
import java.util.Date;

public class accidents {
	
	private	String	ID;
	private	String	Source;
	private	double	TMC;
	private	double	Severity;
	private Date	Start_Time;
	private	Date	End_Time;
	private	double	Start_Lat;
	private	double	Start_Lng;
	private	double	End_Lat;
	private	double	End_Lng;
	private	double	Distance;
	private	String	Description;
	private	double	Number;
	private	String	Street;
	private	String	Side;
	private	String	City;
	private	String	County;
	private	String	State;
	private	String	Zipcode;
	private	String	Country;
	private	String	Timezone;
	private	String	Airport_Code;
	private	String	Weather_Timestamp;
	private	double	Temperature;
	private	double	Wind_Chill;
	private	double	Humidity;
	private	double	Pressure;
	private	double	Visibility;
	private	String	Wind_Direction;
	private	double	Wind_Speed;
	private	double	Precipitation;
	private	String	Weather_Condition;
	private	Boolean	Amenity;
	private	Boolean	Bump;
	private	Boolean	Crossing;
	private	Boolean	Give_Way;
	private	Boolean	Junction;
	private	Boolean	No_Exit;
	private	Boolean	Railway;
	private	Boolean	Roundabout;
	private	Boolean	Station;
	private	Boolean	Stop;
	private	Boolean	Traffic_Calming;
	private	Boolean	Traffic_Signal;
	private	Boolean	Turning_Loop;
	private	String	Sunrise_Sunset;
	private	String	Civil_Twilight;
	private	String	Nautical_Twilight;
	private	String	Astronomical_Twilight;
	
	public accidents(String iD, String source, double tMC, double severity, Date start_Time, Date end_Time,
			double start_Lat, double start_Lng, double end_Lat, double end_Lng, double distance, String description,
			double number, String street, String side, String city, String county, String state, String zipcode,
			String country, String timezone, String airport_Code, String weather_Timestamp, double temperature,
			double wind_Chill, double humidity, double pressure, double visibility, String wind_Direction,
			double wind_Speed, double precipitation, String weather_Condition, Boolean amenity, Boolean bump,
			Boolean crossing, Boolean give_Way, Boolean junction, Boolean no_Exit, Boolean railway, Boolean roundabout,
			Boolean station, Boolean stop, Boolean traffic_Calming, Boolean traffic_Signal, Boolean turning_Loop,
			String sunrise_Sunset, String civil_Twilight, String nautical_Twilight, String astronomical_Twilight) {
		super();
		ID = iD;
		Source = source;
		TMC = tMC;
		Severity = severity;
		Start_Time = start_Time;
		End_Time = end_Time;
		Start_Lat = start_Lat;
		Start_Lng = start_Lng;
		End_Lat = end_Lat;
		End_Lng = end_Lng;
		Distance = distance;
		Description = description;
		Number = number;
		Street = street;
		Side = side;
		City = city;
		County = county;
		State = state;
		Zipcode = zipcode;
		Country = country;
		Timezone = timezone;
		Airport_Code = airport_Code;
		Weather_Timestamp = weather_Timestamp;
		Temperature = temperature;
		Wind_Chill = wind_Chill;
		Humidity = humidity;
		Pressure = pressure;
		Visibility = visibility;
		Wind_Direction = wind_Direction;
		Wind_Speed = wind_Speed;
		Precipitation = precipitation;
		Weather_Condition = weather_Condition;
		Amenity = amenity;
		Bump = bump;
		Crossing = crossing;
		Give_Way = give_Way;
		Junction = junction;
		No_Exit = no_Exit;
		Railway = railway;
		Roundabout = roundabout;
		Station = station;
		Stop = stop;
		Traffic_Calming = traffic_Calming;
		Traffic_Signal = traffic_Signal;
		Turning_Loop = turning_Loop;
		Sunrise_Sunset = sunrise_Sunset;
		Civil_Twilight = civil_Twilight;
		Nautical_Twilight = nautical_Twilight;
		Astronomical_Twilight = astronomical_Twilight;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public double getTMC() {
		return TMC;
	}

	public void setTMC(double tMC) {
		TMC = tMC;
	}

	public double getSeverity() {
		return Severity;
	}

	public void setSeverity(double severity) {
		Severity = severity;
	}

	public Date getStart_Time() {
		return Start_Time;
	}

	public void setStart_Time(Date start_Time) {
		Start_Time = start_Time;
	}

	public Date getEnd_Time() {
		return End_Time;
	}

	public void setEnd_Time(Date end_Time) {
		End_Time = end_Time;
	}

	public double getStart_Lat() {
		return Start_Lat;
	}

	public void setStart_Lat(double start_Lat) {
		Start_Lat = start_Lat;
	}

	public double getStart_Lng() {
		return Start_Lng;
	}

	public void setStart_Lng(double start_Lng) {
		Start_Lng = start_Lng;
	}

	public double getEnd_Lat() {
		return End_Lat;
	}

	public void setEnd_Lat(double end_Lat) {
		End_Lat = end_Lat;
	}

	public double getEnd_Lng() {
		return End_Lng;
	}

	public void setEnd_Lng(double end_Lng) {
		End_Lng = end_Lng;
	}

	public double getDistance() {
		return Distance;
	}

	public void setDistance(double distance) {
		Distance = distance;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getNumber() {
		return Number;
	}

	public void setNumber(double number) {
		Number = number;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getSide() {
		return Side;
	}

	public void setSide(String side) {
		Side = side;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCounty() {
		return County;
	}

	public void setCounty(String county) {
		County = county;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getTimezone() {
		return Timezone;
	}

	public void setTimezone(String timezone) {
		Timezone = timezone;
	}

	public String getAirport_Code() {
		return Airport_Code;
	}

	public void setAirport_Code(String airport_Code) {
		Airport_Code = airport_Code;
	}

	public String getWeather_Timestamp() {
		return Weather_Timestamp;
	}

	public void setWeather_Timestamp(String weather_Timestamp) {
		Weather_Timestamp = weather_Timestamp;
	}

	public double getTemperature() {
		return Temperature;
	}

	public void setTemperature(double temperature) {
		Temperature = temperature;
	}

	public double getWind_Chill() {
		return Wind_Chill;
	}

	public void setWind_Chill(double wind_Chill) {
		Wind_Chill = wind_Chill;
	}

	public double getHumidity() {
		return Humidity;
	}

	public void setHumidity(double humidity) {
		Humidity = humidity;
	}

	public double getPressure() {
		return Pressure;
	}

	public void setPressure(double pressure) {
		Pressure = pressure;
	}

	public double getVisibility() {
		return Visibility;
	}

	public void setVisibility(double visibility) {
		Visibility = visibility;
	}

	public String getWind_Direction() {
		return Wind_Direction;
	}

	public void setWind_Direction(String wind_Direction) {
		Wind_Direction = wind_Direction;
	}

	public double getWind_Speed() {
		return Wind_Speed;
	}

	public void setWind_Speed(double wind_Speed) {
		Wind_Speed = wind_Speed;
	}

	public double getPrecipitation() {
		return Precipitation;
	}

	public void setPrecipitation(double precipitation) {
		Precipitation = precipitation;
	}

	public String getWeather_Condition() {
		return Weather_Condition;
	}

	public void setWeather_Condition(String weather_Condition) {
		Weather_Condition = weather_Condition;
	}

	public Boolean getAmenity() {
		return Amenity;
	}

	public void setAmenity(Boolean amenity) {
		Amenity = amenity;
	}

	public Boolean getBump() {
		return Bump;
	}

	public void setBump(Boolean bump) {
		Bump = bump;
	}

	public Boolean getCrossing() {
		return Crossing;
	}

	public void setCrossing(Boolean crossing) {
		Crossing = crossing;
	}

	public Boolean getGive_Way() {
		return Give_Way;
	}

	public void setGive_Way(Boolean give_Way) {
		Give_Way = give_Way;
	}

	public Boolean getJunction() {
		return Junction;
	}

	public void setJunction(Boolean junction) {
		Junction = junction;
	}

	public Boolean getNo_Exit() {
		return No_Exit;
	}

	public void setNo_Exit(Boolean no_Exit) {
		No_Exit = no_Exit;
	}

	public Boolean getRailway() {
		return Railway;
	}

	public void setRailway(Boolean railway) {
		Railway = railway;
	}

	public Boolean getRoundabout() {
		return Roundabout;
	}

	public void setRoundabout(Boolean roundabout) {
		Roundabout = roundabout;
	}

	public Boolean getStation() {
		return Station;
	}

	public void setStation(Boolean station) {
		Station = station;
	}

	public Boolean getStop() {
		return Stop;
	}

	public void setStop(Boolean stop) {
		Stop = stop;
	}

	public Boolean getTraffic_Calming() {
		return Traffic_Calming;
	}

	public void setTraffic_Calming(Boolean traffic_Calming) {
		Traffic_Calming = traffic_Calming;
	}

	public Boolean getTraffic_Signal() {
		return Traffic_Signal;
	}

	public void setTraffic_Signal(Boolean traffic_Signal) {
		Traffic_Signal = traffic_Signal;
	}

	public Boolean getTurning_Loop() {
		return Turning_Loop;
	}

	public void setTurning_Loop(Boolean turning_Loop) {
		Turning_Loop = turning_Loop;
	}

	public String getSunrise_Sunset() {
		return Sunrise_Sunset;
	}

	public void setSunrise_Sunset(String sunrise_Sunset) {
		Sunrise_Sunset = sunrise_Sunset;
	}

	public String getCivil_Twilight() {
		return Civil_Twilight;
	}

	public void setCivil_Twilight(String civil_Twilight) {
		Civil_Twilight = civil_Twilight;
	}

	public String getNautical_Twilight() {
		return Nautical_Twilight;
	}

	public void setNautical_Twilight(String nautical_Twilight) {
		Nautical_Twilight = nautical_Twilight;
	}

	public String getAstronomical_Twilight() {
		return Astronomical_Twilight;
	}

	public void setAstronomical_Twilight(String astronomical_Twilight) {
		Astronomical_Twilight = astronomical_Twilight;
	}


}
