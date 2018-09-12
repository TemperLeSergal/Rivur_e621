import org.joda.time.LocalDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now().plusDays(1);
        LocalDateTime limit = LocalDateTime.now();
        System.out.println("Current time: " + dateTime);
        System.out.println("Token expires: " + limit);

        if (LocalDateTime.now().isEqual(limit) || LocalDateTime.now().isAfter(limit)) {
            System.out.println("Your token has expired...");
        } else {
            System.out.println("Token redeemed!");
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd || HH:mm:ss");
        Date date = new Date();

        /*DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss");
        TimeUnit.SECONDS.sleep(1);
        if (LocalTime.parse("15:58").isAfter(LocalTime.now())) {
            System.out.println("Not yet at the limit");
            System.out.println(LocalTime.now());
            System.out.println(LocalTime.parse( "15:58" ));
            System.out.println(LocalDate.now());
            System.out.println(LocalDate.parse("YYYY:mm:dd"));
        }else{
            System.out.println("Limit reached!");
            System.out.println(LocalDate.now());
            System.out.println(LocalDate.parse("YYYY mmm dd"));
        }*/
    }
}