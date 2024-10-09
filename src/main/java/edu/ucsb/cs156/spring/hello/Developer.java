package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Cameron";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "cameronbyrne4";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("f24-01");
        team.addMember("Vincent");
        team.addMember("Viraj");
        team.addMember("Scott");
        team.addMember("Raymond");
        team.addMember("Jun");
        team.addMember("Cameron");
        return team;
    }
}
