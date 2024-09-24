package example.micronaut;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamAdmin {
    /**
     * Name of the manager.
     */
    @Setter
    private String manager;

    /**
     * @return String containing name of manager
     */
    public String getManager() {
        return manager;
    }
    /**
     * Name of the coach.
     */
    @Setter
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
    @Setter
    private String president;

    /**
     * @return String name of president
     */
    public String getPresident() {
        return president;
    }

    @NoArgsConstructor
    public static class Builder {
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
