import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = { "programTitle", "programGenre", "programNetwork", "viewHomeTown", "numberOfViewers"})
public class ViewerModel {

    public String programTitle;
    public String programGenre;
    public String programNetwork;
    public String viewHomeTown;
    public String numberOfViewers;

    public ViewerModel() {

    }

    public ViewerModel(String programTitle, String programGenre, String programNetwork, String viewHomeTown, String numberOfViewers) {
        this.programTitle = programTitle;
        this.programGenre = programGenre;
        this.programNetwork = programNetwork;
        this.viewHomeTown = viewHomeTown;
        this.numberOfViewers = numberOfViewers;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getProgramGenre() {
        return programGenre;
    }

    public void setProgramGenre(String programGenre) {
        this.programGenre = programGenre;
    }

    public String getProgramNetwork() {
        return programNetwork;
    }

    public void setProgramNetwork(String programNetwork) {
        this.programNetwork = programNetwork;
    }

    public String getViewHomeTown() {
        return viewHomeTown;
    }

    public void setViewHomeTown(String viewHomeTown) {
        this.viewHomeTown = viewHomeTown;
    }

    public String getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(String numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }
}
