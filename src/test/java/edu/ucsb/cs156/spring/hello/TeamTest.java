package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // Case 1 of equals()
    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team), "A team should be equal to itself");
    }

    // Case 2 of equals()
    @Test
    public void equals_different_class() {
        assertFalse(team.equals("not a team"), "A team should not be equal to an object of a different class");
    }

    // ALL VARIATIONS of Case 3 of equals()
    @Test // FT
    public void equals_different_name_same_members() {
        Team otherTeam = new Team("different-name");
        otherTeam.setMembers(team.getMembers());
        assertFalse(team.equals(otherTeam), "Teams with different names should not be equal");
    }

    @Test // TF
    public void equals_same_name_different_members() {
        Team otherTeam = new Team("test-team");
        otherTeam.addMember("different-member");
        assertFalse(team.equals(otherTeam), "Teams with the same name but different members should not be equal");
    }

    @Test // TT
    public void equals_same_name_same_members() {
        Team otherTeam = new Team("test-team");
        assertTrue(team.equals(otherTeam), "Teams with the same name and members should be equal");
    }

    @Test // FF
    public void equals_different_name_different_members() {
        Team otherTeam = new Team("different-name");
        otherTeam.addMember("different-member");
        assertFalse(team.equals(otherTeam), "Teams with different names and different members should not be equal");
    }

    // Two tests for Hashing:
    // This first test would usually be okay if not for the weird error brought up!
    @Test
    public void hashCode_same_content() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode(), "Teams with the same content should have the same hash code");
    }

    @Test
    public void hashCode_particular() {
        Team t = new Team("specific-name");
        t.addMember("specific-member"); // Not sure if we need this too but whatever
        int result = t.hashCode();
        int expectedResult = -76632074; // Replace with the actual value from the first test run
        assertEquals(expectedResult, result, "Hash code should match the expected value");
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
