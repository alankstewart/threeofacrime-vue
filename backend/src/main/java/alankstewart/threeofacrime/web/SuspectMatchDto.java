package alankstewart.threeofacrime.web;

import alankstewart.threeofacrime.model.Suspect;

import java.util.List;

public class SuspectMatchDto {

    private List<Suspect> suspects;
    private int matches;

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public void setSuspects(List<Suspect> suspects) {
        this.suspects = suspects;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
}
