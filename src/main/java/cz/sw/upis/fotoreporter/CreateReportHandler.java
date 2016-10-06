package cz.sw.upis.fotoreporter;

import org.mongodb.morphia.Datastore;

import io.netty.handler.codec.http.HttpResponseStatus;
import ratpack.form.Form;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class CreateReportHandler implements Handler {

	@Override
	public void handle(Context ctx) throws Exception {
		ctx.parse(Form.class).then(form -> {
			form.files();
//			if (!hasAllRequiredParams(form)) {
//				ctx.getResponse().status(HttpResponseStatus.BAD_REQUEST.code()).send();
//				return;
//			}
			Report report = createReportFromForm(form);
			Datastore datastore = ctx.get(Datastore.class);
			datastore.save(report);
			ctx.getResponse().status(HttpResponseStatus.OK.code()).send();
		});
	}

	private Report createReportFromForm(Form form) {
		final Report report = new Report();
		report.setTitle(form.get(RequestParameters.TITLE.getValue()));
		report.setDescription(form.get(RequestParameters.DESCRIPTION.getValue()));

		String s = form.get(RequestParameters.GPS_LAT.getValue());
		if (s != null) {
			try {
				report.setGpsLat(Double.parseDouble(s));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException();
			}
		}
		return report;
	}

	private boolean hasAllRequiredParams(Form form) {
		return form.containsKey(RequestParameters.DEVICE_ID) &&
				form.containsKey(RequestParameters.TITLE.getValue()) &&
				form.containsKey(RequestParameters.DESCRIPTION.getValue()) &&
				form.containsKey(RequestParameters.GPS_LAT.getValue()) &&
				form.containsKey(RequestParameters.GPS_LON.getValue()) &&
				form.containsKey(RequestParameters.PHOTO_1.getValue());
	}

	private boolean isInPermittedZone(double lat, double lon) {
		return true;
	}

	private boolean hasExceededLimit() {
		return false;
	}

}
