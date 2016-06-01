package uk.org.linuxgrotto.tocrunch.connect;

import android.util.Log;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import uk.org.linuxgrotto.tocrunch.api.Crunch;
import uk.org.linuxgrotto.tocrunch.api.model.Director;

/**
 * Created by jgroth on 04/04/16.
 */
public class CrunchAdapter implements ApiAdapter<Crunch> {
    private static final String TAG = CrunchAdapter.class.getSimpleName();
    @Override
    public boolean test(Crunch crunch) {
        try {
            crunch.clientOperations().getClients(0, 1);
            return true;
        } catch (ApiException e) {
            Log.e(TAG, "Could not access Crunch api getClients()");
            return false;
        }
    }

    @Override
    public void setConnectionValues(Crunch crunch, ConnectionValues values) {
        Director director = crunch.currentUserOperations().getCurrentUser();
        values.setDisplayName(director.getValue());
    }

    @Override
    public UserProfile fetchUserProfile(Crunch crunch) {
        Director director = crunch.currentUserOperations().getCurrentUser();
        return new UserProfileBuilder().setEmail(director.getDirectorEmail()).setName(director.getValue()).build();
    }

    @Override
    public void updateStatus(Crunch crunch, String message) {

    }
}
