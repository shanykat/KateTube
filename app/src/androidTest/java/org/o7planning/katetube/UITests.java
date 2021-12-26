package org.o7planning.katetube;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;
import androidx.test.rule.ActivityTestRule;


import junit.framework.TestCase;

@RunWith(AndroidJUnit4.class)

public class UITests extends TestCase {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private String nComm = "Красиво!!!";
    private String nComm1 = "Шикарный вид";
    private String nComm2 = "Я восхищен";

    @Test
    public void testSendComment(){

        onView(withId(R.id.comment)).perform(replaceText(nComm));

        closeSoftKeyboard();

        onView(withId(R.id.but_comment)).perform(click());

        onView(withId(R.id.comment)).perform(replaceText(nComm1));

        closeSoftKeyboard();

        onView(withId(R.id.but_comment)).perform(click());

        onView(withId(R.id.comment)).perform(replaceText(nComm2));

        closeSoftKeyboard();

        onView(withId(R.id.but_comment)).perform(click());

    }
    //    @Test
//    public void testButtonNext() {
//
//        onView(withId(R.id.but_next1)).perform(click());
//
//    }
    @Test
    public void testButtonBack() {

        onView(withId(R.id.but_back1)).perform(click());

    }

}