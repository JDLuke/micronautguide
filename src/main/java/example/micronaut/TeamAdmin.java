package example.micronaut;

import lombok.*;

@Getter
@AllArgsConstructor
public class TeamAdmin {
    public TeamAdmin() {}

    public String manager;
    public String coach;
    public String president;

    @NoArgsConstructor
    public static class Builder {
        public String manager;
        public String coach;
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
