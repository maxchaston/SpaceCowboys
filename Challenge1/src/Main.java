import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email:");
        String emailToParse = sc.nextLine();
        sc.close();

        //
        String id = emailToParse.split("@")[0];
        Document doc = Jsoup.connect("https://ecs.soton.ac.uk/people/" + id).get();
        Element nameHtml = doc.select("[property='name']").first();
        if (nameHtml == null)
        {
            System.out.println("Cannot find person with id " + id);
        } else { //if nameHtml is not null, the person exists
            String name = nameHtml.ownText();
            System.out.println("Name: " + name);

            //tries to print phone number and email, throws to exception if values are Null (if no phone number or email is found in the webpage)
            try {
                String phone = doc.select("[property='telephone']").first().ownText();
                System.out.println("Phone: " + phone);
            }
            catch(Exception e) {
                System.out.println("No phone number found");
            }

            try {
                String email = doc.select("[property='email']").first().ownText();
                System.out.println("Email: " + email);
            }
            catch(Exception e) {
                System.out.println("No email found");
            }

        }
    }
}