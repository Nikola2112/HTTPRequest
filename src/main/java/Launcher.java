import Tasks.HttpImageStatusCli;
import Tasks.HttpStatusChecker;
import Tasks.HttpStatusImageDownloader;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        // Пример использования класса HttpStatusChecker
        HttpStatusChecker checker = new HttpStatusChecker();
        String image200 = checker.getStatusImage(200);
        System.out.println("Image for status code 200: " + image200);

        // Пример использования класса HttpStatusImageDownloader
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        downloader.downloadStatusImage(200);

        // Пример использования класса HttpImageStatusCli
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}


