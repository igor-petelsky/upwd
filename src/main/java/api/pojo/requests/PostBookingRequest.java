package api.pojo.requests;

import api.pojo.models.BookingDates;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostBookingRequest {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}

