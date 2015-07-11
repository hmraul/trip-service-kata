package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TripServiceTest {

    private static final User A_NOT_LOGGED_USER = null;
    private User A_LOGGED_USER = null;
    private User A_USER = null;


    @Test (expected = UserNotLoggedInException.class)
    public void should_throw_UserNotLoggedInException_when_not_logged() {

        TripServiceTesteable tripService = new TripServiceTesteable();
        tripService.getTripsByUser(A_USER);

    }

    @Test
    public void should_return_an_empty_list_if_users_are_not_friends() {
        A_LOGGED_USER = new User();
        A_USER = new User();

        TripServiceTesteable tripService = new TripServiceTesteable();
        List<Trip> trips = tripService.getTripsByUser(A_USER);

        assertThat(trips.size(), is(0));
    }


    public class TripServiceTesteable extends TripService {

        @Override
        protected User getLoggedUser() {
            return A_LOGGED_USER;
        }
    }
	
}
