package Tasks;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader imageDownloader;

    public HttpImageStatusCli() {
        this.imageDownloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter HTTP status code: ");
            String input = scanner.nextLine();

            int statusCode;
            try {
                statusCode = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                return;
            }

            try {
                imageDownloader.downloadStatusImage(statusCode);
            } catch (IOException e) {
                System.out.println("There is no image for HTTP status " + statusCode);
            }
        } finally {
            scanner.close();
        }
    }
}
