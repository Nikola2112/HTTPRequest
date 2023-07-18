package Tasks;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader imageDownloader;

    public HttpImageStatusCli() {
        this.imageDownloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        int statusCode = 0;
        boolean isValidInput = false;

        do {
            try {
                System.out.print("Enter HTTP status code: ");
                statusCode = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        } while (!isValidInput);

        try {
            imageDownloader.downloadStatusImage(statusCode);
        } catch (IOException e) {
            System.out.println("There is no image for HTTP status " + statusCode);
        } finally {
            scanner.close();
        }
    }
    }

