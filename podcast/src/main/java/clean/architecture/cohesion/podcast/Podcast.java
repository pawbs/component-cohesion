package clean.architecture.cohesion.podcast;

import java.util.List;

public class Podcast {
    private List<String> audioContent;

    public Podcast(List<String> audioContent) {
        this.audioContent = audioContent;
    }

    public String transcribeSubtitles() {
        //some calculation here
        return "";
    }

}
