import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();

        LinkedHashMap<String, String> book = new LinkedHashMap<>();


//        Pattern pattern1 = Pattern.compile("([A-Z][a-zA-Z]*)[^A-Za-z+]*?(\\+?[0-9]+[0-9\\-()\\/. ]*)");
        Pattern pattern1 = Pattern.compile("([A-Z][A-Za-z]*)[^0-9A-Za-z+]*([+]?[0-9]+[0-9\\- \\.\\/\\)\\(]*[0-9]+)");

        Pattern pattern2 = Pattern.compile("([\\-()\\/. ]+)");

        
        String line = "";
        while(!"END".equals(line = sc.nextLine())){
            stringBuilder.append(line.trim());
        }

        Matcher matcher = pattern1.matcher(stringBuilder.toString());


        matcher.toMatchResult();



        while(matcher.find()){
            String name = matcher.group(1);
            String number = matcher.group(2);
            Matcher matcher2 = pattern2.matcher(number);
            number = matcher2.replaceAll("");
            book.put(name,number);
        }

        if(book.isEmpty()){
            System.out.println("<p>No matches!</p>");
        } else{
            System.out.print("<ol>");
            for (Map.Entry<String, String> entry :
                    book.entrySet()) {
                System.out.print(String.format("<li><b>%s:</b> %s</li>", entry.getKey(), entry.getValue()));
            }
            System.out.print("</ol>");
        }

    }
}
