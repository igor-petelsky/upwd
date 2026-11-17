package api;

import api.factories.BookingFactory;
import api.pojo.requests.PostBookingRequest;
import api.pojo.responses.GetBookingResponse;
import api.pojo.responses.PostBookingResponse;
import api.services.BookingService;
import base.BaseApi;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingTests extends BaseApi {

    private final BookingService bookingService = new BookingService();

    @Test
    public void createAndGetBookingTest() {

        PostBookingRequest bookingBody = BookingFactory.createBookingBody()
                .firstname("Fname")
                .lastname("Lname")
                .build();

        PostBookingResponse postResponse = bookingService.postBooking(bookingBody);

        int bookingId = postResponse.getBookingid();

        assertTrue(bookingId > 0, "Booking ID should be greater than 0");

        GetBookingResponse getResponse = bookingService.getBookingById(bookingId);

        assertEquals(getResponse.getFirstname(), bookingBody.getFirstname(), "Firstname mismatch");
        assertEquals(getResponse.getLastname(), bookingBody.getLastname(), "Lastname mismatch");
        assertEquals(getResponse.getTotalprice(), bookingBody.getTotalprice(), "Total price mismatch");
        assertEquals(getResponse.isDepositpaid(), bookingBody.isDepositpaid(), "Deposit paid mismatch");
        assertEquals(getResponse.getBookingdates().getCheckin(), bookingBody.getBookingdates().getCheckin(), "Check-in date mismatch");
        assertEquals(getResponse.getBookingdates().getCheckout(), bookingBody.getBookingdates().getCheckout(), "Check-out date mismatch");
        assertEquals(getResponse.getAdditionalneeds(), bookingBody.getAdditionalneeds(), "Additional needs mismatch");
    }
}