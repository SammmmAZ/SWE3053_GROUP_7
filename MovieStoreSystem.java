package MovieStoreSystem;
import java.util.ArrayList;
import java.util.Scanner;

// R5: Define interface/ abstract class by which shared behaviour is supported across Movie & Member Class:
abstract class SortableInstances {
    //  serve as common abstraction for parametrization
    abstract public String getKey();
}
// R4: Class for movie titles with title stored as an instance variable
class Movie extends SortableInstances{
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getKey() {
        return title;
    }
}

// R4: Class for members with name stored as an instance variable
class Member extends SortableInstances{
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getKey() {
        return name;
    }
}

public class MovieStoreSystemRefactoredP3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- SECTION 1: MOVIES ---
        // R4: Using ArrayList of Movie objects instead of Strings
        ArrayList<Movie> movieTitles = new ArrayList<Movie>();
        System.out.println("Create the movies list by entering the movie titles one by one");
        System.out.println("Enter a movie title to be added to the movie store");
        
        String newMovieTitleStr = input.next();
        while (!(newMovieTitleStr.equals("end"))) {
            // R4: Creating Movie objects to add to the list
            movieTitles.add(new Movie(newMovieTitleStr));
            System.out.print("Enter a movie title to be added to the movie store");
            newMovieTitleStr = input.next();
        }

        System.out.println("The movie titles in the movie store before sorting are: ");
        printMovies(movieTitles);

        // R4: Use specific sort method for Movie objects
        sortMovies(movieTitles);

        System.out.println("The movie titles in the movie store after sorting are: ");
        printMovies(movieTitles);

        // --- SECTION 2: MEMBERS ---
        // R4: Using ArrayList of Member objects instead of Strings
        ArrayList<Member> memberNames = new ArrayList<Member>();
        System.out.println("\nCreate the members list by entering the member names one by one");
        System.out.println("Enter a member name to be added to the movie store system");
        
        String newMemberNameStr = input.next();
        while (!(newMemberNameStr.equals("end"))) {
            // R4: Creating Member objects to add to the list
            memberNames.add(new Member(newMemberNameStr));
            System.out.print("Enter a member name to be added to the movie store");
            newMemberNameStr = input.next();
        }

        System.out.println("The members in the movie store before sorting are: ");
        printMembers(memberNames);

        // R4: Use specific sort method for Member objects
        sortMembers(memberNames);

        System.out.println("The members in the movie store after sorting are: ");
        printMembers(memberNames);

        // --- SECTION 3: SEARCHING ---
        System.out.println("\nEnter a movie title to search for:");
        String movieToSearch = input.next();
        // R4: Use specific search method for Movie objects
        if (searchMovie(movieTitles, movieToSearch)) {
            System.out.println("The movie title is found");
        } else {
            System.out.println("The movie title is not found");
        }

        System.out.println("\nEnter a member name to search for:");
        String memberToSearch = input.next();
        // R4: Use specific search method for Member objects
        if (searchMember(memberNames, memberToSearch)) {
            System.out.println("The member is found");
        } else {
            System.out.println("The member is not found");
        }
    }

    // --- R4: SPECIFIC SORT AND SEARCH METHODS ---

    public static void sortMovies(ArrayList<Movie> list) {
        boolean isSorted = false;
        Movie temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                // Comparing titles retrieved from the Movie objects
                if (list.get(i).getTitle().compareToIgnoreCase(list.get(i + 1).getTitle()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
    }

    public static void sortMembers(ArrayList<Member> list) {
        boolean isSorted = false;
        Member temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                // Comparing names retrieved from the Member objects
                if (list.get(i).getName().compareToIgnoreCase(list.get(i + 1).getName()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
    }

    // Refactor 5
    // create Parametrized sort methods for both Members and Movie instances
    public static <T extends SortableInstances> void sortItems(ArrayList<T> list){
        boolean isSorted = false;
        T temp;

        // follow similar sort logic
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                // Comparing names retrieved from the child class of SortableInstance
                if (list.get(i).getKey().compareToIgnoreCase(list.get(i + 1).getKey()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
    }

    public static boolean searchMovie(ArrayList<Movie> list, String target) {
        for (Movie m : list) {
            if (m.getTitle().equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchMember(ArrayList<Member> list, String target) {
        for (Member m : list) {
            if (m.getName().equals(target)) {
                return true;
            }
        }
        return false;
    }

    // Refactor 5
    // created Parametrized search methods for both Members and Movie instances
    public static <T extends SortableInstance> void searchItems(ArrayList<T> list, String target){
        for (T item : list){
            if (item.getKey().equals(target)){
                return true;
            }
        }
        return false;
    }

    // --- R4: MODIFIED PRINT METHODS ---

    public static void printMovies(ArrayList<Movie> list) {
        for (Movie m : list) {
            System.out.println(m.getTitle());
        }
    }

    public static void printMembers(ArrayList<Member> list) {
        for (Member m : list) {
            System.out.println(m.getName());
        }
    }
}