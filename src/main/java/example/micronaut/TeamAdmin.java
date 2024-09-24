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
    public String manager;
    /**
     * Name of the coach.
     */
    public String coach;
    /**
     * Name of the president.
     */
    public String president;

    @NoArgsConstructor
    public static class Builder {
        /**
         * Name of the manager.
         */
        public String manager;
        /**
         * Name of the coach.
         */
        public String coach;
        /**
         * Name of the president.
         */
        public String president;

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

        public TeamAdmin build() {
            TeamAdmin teamAdmin = new TeamAdmin();
            teamAdmin.manager = this.manager;
            teamAdmin.coach = this.coach;
            teamAdmin.president = this.president;
            return teamAdmin;
        }
    }

}
