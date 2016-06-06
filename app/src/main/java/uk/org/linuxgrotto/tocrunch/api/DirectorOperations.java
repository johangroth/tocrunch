package uk.org.linuxgrotto.tocrunch.api;

import java.util.Date;

import uk.org.linuxgrotto.tocrunch.api.model.Directors;

/**
 * Created by jgroth on 04/04/16.
 */
public interface DirectorOperations {
    Directors getDirectors();

    Directors getDirector(Date date);
}
