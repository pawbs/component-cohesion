package clean.architecture.cohesion;

import clean.architecture.cohesion.podcast.Podcast;

import java.util.Date;
import java.util.List;

public class Media {
    private String contentType;

    private String title;
    private Date DateCreated;
    private String author;
    private Integer issueNo;
    private String episodeCode;
    private String channel;

    private String metadata;

    private String content;
    private List<String> imageContent;
    private List<String> audioContent;
    private List<String> movieContent;

    private DatabaseConnection dbConnection;

    public Media getNovelFromFile(String fileName) {
        Media result = new Media();

        /*
            some code here to parse file into result object
            result.title = readTitle(fileName)
            result.DateCreated = readDate(fileName)
            result.author = readAuthor(fileName)
            result.content = readFile(fileName)
         */

        result.metadata = processNovelMetadata(result);
        return result;
    }

    public Media getMagazineIssueFromFile(String fileName) {
        Media result = new Media();

        /*
            some code here to parse file into result object
            result.title = readTitle(fileName)
            result.DateCreated = readDate(fileName)
            result.issue = readIssue(fileName)

            result.content = readFile(fileName)
            result.imageFiles = readImageFiles(fileName)
         */

        result.metadata = processMagazineMetadata(result);
        return result;
    }

    public Media getPodcastFromFile(String fileName) {
        Media result = new Media();
        /*
            some code here to parse file into result object
            result.title = readTitle(fileName)
            result.DateCreated = readDate(fileName)
            result.channel = readChannel(fileName)

            result.audioFiles = readAudioFiles(fileName)
         */

        Podcast podcast = new Podcast(result.audioContent);
        result.content = podcast.transcribeSubtitles();

        result.metadata = processPodcastMetadata(result);
        return result;
    }

    public Media getTelevisionEpisodeFromFile(String fileName) {
        Media result = new Media();

        /*
            some code here to parse file into result object
            result.title = readTitle(fileName)
            result.DateCreated = readDate(fileName)
            result.episodeCode = readEpisodeCode(fileName)

            result.movieFiles = readMovieFiles(fileName)
         */

        result.metadata = processTelevisionMetadata(result);
        return result;
    }

    public void saveNovelToDatabase(Media novel) {
        if (!novel.contentType.equals("novel")) {
            throw new RuntimeException("wrong contentType");
        }

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase("user", "pass", "hostnameAndPort");
        databaseConnection.saveContent(novel.content, null,  null, null);
    }

    public void saveMagazineToDatabase(Media magazine) {
        if (!magazine.contentType.equals("magazine")) {
            throw new RuntimeException("wrong contentType");
        }

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase("user", "pass", "hostnameAndPort");
        databaseConnection.saveContent(magazine.content, magazine.imageContent, null, null);
    }

    public void savePodcastToDatabase(Media podcast) {
        if (!podcast.contentType.equals("magazine")) {
            throw new RuntimeException("wrong contentType");
        }

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase("user", "pass", "hostnameAndPort");
        databaseConnection.saveContent(podcast.content, null, podcast.imageContent, null);
    }

    public void saveTelevisionEpisodeToDatabase(Media televisionEpisode) {
        if (!televisionEpisode.contentType.equals("televisionEpisode")) {
            throw new RuntimeException("wrong contentType");
        }

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase("user", "pass", "hostnameAndPort");
        databaseConnection.saveContent(televisionEpisode.content, null, null, televisionEpisode.movieContent);
    }

    private String processNovelMetadata(Media media) {
        //do some processing on the novel media here
        return "";
    }

    private String processMagazineMetadata(Media media) {
        //do some processing on the magazine here
        return "";
    }

    private String processPodcastMetadata(Media media) {
        //do some processing on the podcast data here
        return "";
    }

    private String processTelevisionMetadata(Media media) {
        //do some processing on television here
        return "";
    }

}
