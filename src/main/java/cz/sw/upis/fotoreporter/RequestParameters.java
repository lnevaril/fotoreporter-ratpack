package cz.sw.upis.fotoreporter;

public enum RequestParameters {
	DEVICE_ID("deviceId"),
	TITLE("title"),
	DESCRIPTION("description"),
	GPS_LAT("gpsLat"),
	GPS_LON("gpsLon"),
	PHOTO_1("photo1"),
	PHOTO_2("photo2"),
	PHOTO_3("photo3");

	private String value;

	RequestParameters(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
