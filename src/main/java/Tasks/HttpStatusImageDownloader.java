package Tasks;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    private HttpStatusChecker statusChecker;

    public HttpStatusImageDownloader() {
        this.statusChecker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws IOException {
        String imageUrl = statusChecker.getStatusImage(code);

        URL url = new URL(imageUrl);
        try (InputStream in = url.openStream()) {
            Path outputPath = Path.of(imageUrl.substring(imageUrl.lastIndexOf("/") + 1));
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Image downloaded successfully: " + outputPath.toAbsolutePath());
        }
    }
}
