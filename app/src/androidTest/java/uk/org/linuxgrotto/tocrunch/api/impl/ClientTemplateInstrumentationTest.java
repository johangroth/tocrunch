package uk.org.linuxgrotto.tocrunch.api.impl;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import uk.org.linuxgrotto.tocrunch.activity.ToCrunchActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by jgroth on 07/06/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ClientTemplateInstrumentationTest {

    @Rule
    public ActivityTestRule<ToCrunchActivity> activityTestRule = new ActivityTestRule<>(ToCrunchActivity.class);

    @Test
    public void test() {
        onData(allOf(is(instanceOf(String[].class)), hasEntry(equalTo("STR"), is("Accounts")))).perform(click());

    }

}
