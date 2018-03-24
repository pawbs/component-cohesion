package clean.architecture.cohesion;

import java.util.List;

public class DatabaseConnection {

    private Boolean initialized;

    public void connectToDatabase(String username, String password, String hostnameAndPort) {
        //connect to db
        initialized = true;
    }

    public void saveContent(String content, List<String> imageContent, List<String> audioContent, List<String> movieContent) {
        //persist content to db
    }

}
