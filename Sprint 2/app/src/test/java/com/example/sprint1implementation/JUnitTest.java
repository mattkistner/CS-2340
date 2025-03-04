package com.example.sprint1implementation;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class JUnitTest {

    @Before
    public void setUp() throws Exception {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Zone river = new river(false, 3, "blue");
        Zone road = new road(false, 10, "FF3380");
        Player player = new player();
        Zone safeZone = new safeZone(20, 20, "B3A369");
    }

    @Test
    public void testUseAppContext() {
        // Context of the app under test.
        assertEquals("com.example.sprint1implementation", appContext.getPackageName());
    }

    @Test
    public void testRiverSafe() {
        //makes sure river is not set as safe, which will be used in future sprints
        assertEquals("River is not safe, good job", false, river.getSafe());
    }

    @Test
    public void testRoadSafety() {
        //tests all aspects of road constructor
        assertEquals("Safety check", false, road.getSafe());
    }

    @Test
    public void testRoadHeight() {
        assertEquals("height check", 10, road.getHeight());
    }

    @Test
    public void testRoadWidth() {
        assertEquals("width check", 1000, road.getWidth());
    }

    @Test
    public void testPlayerName() {
        //tests creation of player object without input from gameplay
        assertEquals("Name", "default", player.getName());
    }

    @Test
    public void testPlayerLives() {
        assertEquals("Lives", 3, player.getLives());
    }

    @Test
    public void testRiverName() {
        assertEquals("Skiles Walkway", river.getName());
    }

    @Test
    public void testRoadName() {
        assertEquals("Bobby Dodd Way", road.getName())
    }

    @Test
    public void testSafeZoneName() {
        assertEquals("Tech Green", safeZone.getName());
    }
}