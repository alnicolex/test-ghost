package dto;

/**
 * Class with the form data
 */
public class FormDto {

    private String titlePage;
    private String descriptionPage;
    private String timeZone;
    private String twitter;

    public String getTitlePage() {
        return titlePage;
    }

    public void setTitlePage(String titlePage) {
        this.titlePage = titlePage;
    }

    public String getDescriptionPage() {
        return descriptionPage;
    }

    public void setDescriptionPage(String descriptionPage) {
        this.descriptionPage = descriptionPage;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

}
