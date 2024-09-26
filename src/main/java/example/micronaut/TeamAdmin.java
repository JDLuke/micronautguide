package example.micronaut;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamAdmin {
    /**
     * Name of the manager.
     */
    private String manager;

    /**
     * @return String containing name of manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets the name of the team manager.
     *
     * @param newManager
     */
    public void setManager(final String newManager) {
        this.manager = newManager;
    }
    /**
     * Name of the coach.
     */
    private String coach;

    /**
     * Sets the name of the team coach.
     * @param newCoach
     */
    public void setCoach(final String newCoach) {
        this.coach = newCoach;
    }
    /**
     * @return String name of coach
     */
    public String getCoach() {
        return coach;
    }
    /**
     * Name of the president.
     */
    private String president;

    /**
     * Sets the name of the team president.
     * @param newPresident
     */
    public void setPresident(final String newPresident) {
        this.president = newPresident;
    }

    /**
     * @return String name of president
     */
    public String getPresident() {
        return president;
    }

    @NoArgsConstructor
    public static class Builder {
        /**
         * Sets the name of the manager of the administration we will build.
         *
         * @param theManager - String name of the manager for the new team admin
         * @return A builder object for the TeamAdmin that includes the
         * manager's name.
         */
        public Builder withManager(final String theManager) {
            this.manager = theManager;
            return this;
        }

        /**
         * Sets the name of the coach of the administration we will build.
         * @param theCoach - Name of the coach
         * @return Builder object with coach populated
         */
        public Builder withCoach(final String theCoach) {
            this.coach = theCoach;
            return this;
        }

        /**
         * Sets the name of the president of the administration we will build.
         *
         * @param thePresident - Name of the president
         * @return Builder object with president populated
         */
        public Builder withPresident(final String thePresident) {
            this.president = thePresident;
            return this;
        }
        /**
         * Name of the manager.
         */
        private String manager;

        /**
         * @return String name of manager
         */
        public String getManager() {
            return manager;
        }

        /**
         * Name of the coach.
         */
        private String coach;

        /**
         * @return String name of coach
         */
        public String getCoach() {
            return coach;
        }
        /**
         * Name of the president.
         */
        private String president;

        /**
         * @return String name of president
         */
        public String getPresident() {
            return president;
        }


/*
        public Builder withManager(final String manager) {
            this.manager = manager;
            return this;
        }
        public Builder withCoach(final String coach) {
            this.coach = coach;
            return this;
        }
        public Builder withPresident(final String president) {
            this.president = president;
            return this;
        }
*/
        /**
         * @return A new TeamAdmin object
         */
        public TeamAdmin build() {
            TeamAdmin teamAdmin = new TeamAdmin();
            teamAdmin.manager = this.manager;
            teamAdmin.coach = this.coach;
            teamAdmin.president = this.president;
            return teamAdmin;
        }
    }

}
