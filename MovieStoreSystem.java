package MovieStoreSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieStoreSystemRefactoredP2 {
    public static void main(String[] args) {

        // This code is to add movie titles to the movie store and sort them
        ArrayList<String> movieTitles = new ArrayList<String>();
        String newMovieTitle;

        System.out.println("Create the movies list by entering the movie titles one by one");
        System.out.println("Enter a movie title to be added to the movie store");
        Scanner input = new Scanner(System.in);
        newMovieTitle = input.next();
        while (!(newMovieTitle.equals("end"))) {
            movieTitles.add(newMovieTitle);
            System.out.print("Enter a movie title to be added to the movie store");
            newMovieTitle = input.next();
        }

        System.out.println("The movie titles in the movie store before sorting are: ");
        for (String title : movieTitles) {
            System.out.println(title);
        }

        // R3: Using Extracted Method for sorting movies
        sortElements(movieTitles);

        System.out.println("The movie titles in the movie store after sorting are: ");
        for (String title : movieTitles) {
            System.out.println(title);
        }

        // This code is to add members to the movie store and sort them
        ArrayList<String> memberNames = new ArrayList<String>();
        String newMemberName;

        System.out.println("Create the members list by entering the member names one by one");
        System.out.println("Enter a member name to be added to the movie store system");
        newMemberName = input.next();
        while (!(newMemberName.equals("end"))) {
            memberNames.add(newMemberName);
            System.out.print("Enter a member name to be added to the movie store");
            newMemberName = input.next();
        }

        System.out.println("The members in the movie store before sorting are: ");
        for (String name : memberNames) {
            System.out.println(name);
        }

        // R3: Using Extracted Method for sorting members
        sortElements(memberNames);

        System.out.println("The members in the movie store after sorting are: ");
        for (String name : memberNames) {
            System.out.println(name);
        }

        // This code is to search for a specific movie title
        System.out.println("Enter a movie title to search for:");
        String movieToSearch = input.next();
        
        // R3: Using Extracted Method for searching movies
        boolean isMovieFound = searchElement(movieTitles, movieToSearch);

        if (isMovieFound)
            System.out.println("The movie title is found");
        else
            System.out.println("The movie title is not found");

        // This code is to search for a specific member
        System.out.println("Enter a member name to search for:");
        String memberToSearch = input.next();
        
        // R3: Using Extracted Method for searching members
        boolean isMemberFound = searchElement(memberNames, memberToSearch);

        if (isMemberFound)
            System.out.println("The member is found");
        else
            System.out.println("The member is not found");
    }

    /**
     * R3: Extracted Method for sorting elements
     */
    public static void sortElements(ArrayList<String> list) {
        boolean isSorted = false;
        String temp = null;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if ((list.get(i)).compareToIgnoreCase(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
    }

    /**
     * R3: Extracted Method for searching for a specific element
     */
    public static boolean searchElement(ArrayList<String> list, String elementToSearch) {
        boolean found = false;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).equals(elementToSearch))
                found = true;
        }
        return found;
    }
}