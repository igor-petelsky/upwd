package api.services;

import api.pojo.requests.PostBookingRequest;
import api.pojo.responses.GetBookingResponse;
import api.pojo.responses.PostBookingResponse;
import base.BaseApi;

public class BookingService extends BaseApi {

    public PostBookingResponse postBooking(PostBookingRequest bookingBody) {
        return request()
                .body(bookingBody)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract()
                .as(PostBookingResponse.class);
    }

    public GetBookingResponse getBookingById(int bookingId) {
        return request()
                .pathParam("id", bookingId)
                .when()
                .get("/booking/{id}")
                .then()
                .statusCode(200)
                .extract()
                .as(GetBookingResponse.class);
    }
}