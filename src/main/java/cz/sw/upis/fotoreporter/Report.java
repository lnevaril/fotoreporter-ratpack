package cz.sw.upis.fotoreporter;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

@Entity("reports")
public class Report {

	private ObjectId id;

	private String deviceId;

	private Date date;

	private String title;

	private String description;

	private double gpsLat;

	private double gpsLon;

	private List<String> photosPaths;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public double getGpsLat() {
		return gpsLat;
	}

	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}

	public double getGpsLon() {
		return gpsLon;
	}

	public void setGpsLon(double gpsLon) {
		this.gpsLon = gpsLon;
	}

	public List<String> getPhotosPaths() {
		return photosPaths;
	}

	public void setPhotosPaths(List<String> photosPaths) {
		this.photosPaths = photosPaths;
	}

}
