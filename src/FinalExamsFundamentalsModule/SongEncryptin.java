package FinalExamsFundamentalsModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryptin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern artist = Pattern.compile("^[A-Z][a-z' ]+$");
        Pattern song = Pattern.compile("^[A-Z ]+$");
        List<String> list = new ArrayList<>();

        while (true) {
            String str = input.nextLine();
            if (str.equals("end")) {
                break;
            }
            String[] strings = str.split(":");
            String art = strings[0];
            String son = strings[1];
            Matcher a = artist.matcher(art);
            Matcher s = song.matcher(son);
            if (a.find() && s.find()) {
                int key = a.group().length();
                StringBuilder sb = new StringBuilder();
                String artists = a.group();
                String songs = s.group();
                for (int i = 0; i < artists.length(); i++) {
                    char current = artists.charAt(i);
                    char newChar = 0;
                    key = a.group().length();
                    if (Character.isAlphabetic(current)) {
                        while (key != 0) {
                            if (current  == 'z') {
                                newChar = 'a';
                                current = newChar;

                                key--;
                                continue;
                            }
                            if (current  == 'Z') {
                                newChar = 'A';
                                current = newChar;
                                key--;
                                continue;
                            }
                            newChar = (char) (current + 1);
                            current = newChar;


                            key--;
                        }

                    } else {
                        sb.append(current);
                        continue;
                    }
                    sb.append(newChar);
                }
                sb.append("@");
                for (int i = 0; i < songs.length(); i++) {
                    char current = songs.charAt(i);
                    char newChar = 0;
                    key = a.group().length();
                    if (Character.isAlphabetic(current)) {
                        while (key != 0) {
                            if (current  == 'z') {
                                newChar = 'a';
                                current = newChar;
                                key--;
                                continue;
                            }
                            if (current  == 'Z') {
                                newChar = 'A';
                                current = newChar;
                                key--;
                                continue;
                            }
                            newChar = (char) (current + 1);
                            current = newChar;


                            key--;
                        }

                    } else {
                        sb.append(current);
                    }
                    sb.append(newChar);

                }
                System.out.printf("Successful encryption: %s%n",sb.toString());

            } else {
                System.out.println("Invalid input!");
            }
        }

    }

}

