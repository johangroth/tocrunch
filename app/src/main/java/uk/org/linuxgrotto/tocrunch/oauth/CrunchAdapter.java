package uk.org.linuxgrotto.tocrunch.oauth;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchAdapter implements ApiAdapter<Crunch> {
    @Override
    public boolean test(Crunch api) {
        return false;
    }

    @Override
    public void setConnectionValues(Crunch api, ConnectionValues values) {

    }

    @Override
    public UserProfile fetchUserProfile(Crunch api) {
        return null;
    }

    @Override
    public void updateStatus(Crunch api, String message) {

    }
}
