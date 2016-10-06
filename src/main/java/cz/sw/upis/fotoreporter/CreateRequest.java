package cz.sw.upis.fotoreporter;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("reports")
public class CreateRequest {

	@Id
	private ObjectId id;

	private String deviceId;

	private String title;

	private String description;

	private double gpsLat;

	private double gpsLon;

	public CreateRequest() {
		// no code
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

}
