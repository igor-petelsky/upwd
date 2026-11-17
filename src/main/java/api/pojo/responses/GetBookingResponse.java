package api.pojo.responses;

import api.pojo.models.BookingDates;
import lombok.Data;

@Data
public class GetBookingResponse {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}