package api.factories;

import api.pojo.models.BookingDates;
import api.pojo.requests.PostBookingRequest;

public class BookingFactory {

    public static PostBookingRequest.PostBookingRequestBuilder createBookingBody() {
        return PostBookingRequest.builder()
                .firstname("DefaultFname")
                .lastname("DefaultLname")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin("2018-01-01")
                        .checkout("2019-01-01")
                        .build())
                .additionalneeds("Breakfast");
    }
}