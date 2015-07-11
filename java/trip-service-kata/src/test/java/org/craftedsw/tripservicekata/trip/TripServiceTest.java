package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripServiceTest {

    private static final User A_USER = null;

    @Test (expected = UserNotLoggedInException.class)
    public void should_throw_UserNotLoggedInException_when_not_logged() {

        TripServiceTesteable tripService = new TripServiceTesteable();
        tripService.getTripsByUser(A_USER);

    }


    public class TripServiceTesteable extends TripService {

        @Override
        protected User getLoggedUser() {
            return null;
        }
    }
	
}
