package MovieStoreSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieStoreSystemRefactoredP1 {
	public static void main(String[] args) {
		
		// This code is to add movie titles to the movie store and sort them
		ArrayList<String> movieTitles = new ArrayList<String>(); // an array list of movie titles
		String newMovieTitle; //A variable to add a new movie title
		
		

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
		   for(String title: movieTitles){
				System.out.println(title);
			}


		 //bubble sor movies--------------------------------------------------
		   boolean isMoviesSorted = false;
		    String movieTemp = null;
		    while(!isMoviesSorted) {
		        isMoviesSorted = true;
		        for (int i = 0; i < movieTitles.size() - 1; i++) {		           
		        	if((movieTitles.get(i)).compareToIgnoreCase(movieTitles.get(i+1))>0) {
		                movieTemp = movieTitles.get(i);
		                movieTitles.set(i,movieTitles.get(i+1));
		                movieTitles.set(i+1,movieTemp);
		                isMoviesSorted = false;
		            }
		        }
		    }
		 //-------------------------------------------------------
		 System.out.println("The movie titles in the movie store after sorting are: ");
		   for(String title: movieTitles){
				System.out.println(title);
			}  	   


		 //This code is to add members to the movie store and sort them
			ArrayList<String> memberNames = new ArrayList<String>();// an array list of movie store members
			String newMemberName;//A variable to add a new member name

			System.out.println("Create the members list by entering the member names one by one");		
			System.out.println("Enter a member name to be added to the movie store system");
			
			newMemberName = input.next();		
			while (!(newMemberName.equals("end"))) {		
				memberNames.add(newMemberName);
				System.out.print("Enter a member name to be added to the movie store");
				newMemberName = input.next();			
				}

			System.out.println("The members in the movie store before sorting are: ");
			   for(String name: memberNames){
					System.out.println(name);
				}


			 //bubble sort member--------------------------------------------------
			   boolean isMemberSorted = false;
			   String memberTemp = null;
			    while(!isMemberSorted) {
			        isMemberSorted = true;
			        for (int i = 0; i < memberNames.size() - 1; i++) {		           
			        	if((memberNames.get(i)).compareToIgnoreCase(memberNames.get(i+1))>0) {
			                memberTemp = memberNames.get(i);
			                memberNames.set(i,memberNames.get(i+1));
			                memberNames.set(i+1,memberTemp);
			                isMemberSorted = false;
			            }
			        }
			    }


			 //-------------------------------------------------------
			 System.out.println("The members in the movie store after sorting are: ");
			   for(String name: memberNames){
					System.out.println(name);
				}		   
			  			   


			 //This code is to search for a specific movie title
		     System.out.println("Enter a movie title to search for:");
			   String movieToSearch = input.next();	
			   boolean isMovieFound = false;	
			   
		   //Linear Search----------------------------------------------
		   for (int index = 0; index < movieTitles.size(); index++) {
		        if (movieTitles.get(index).equals(movieToSearch)) 
		        	isMovieFound = true;     
		    }
		   //------------------------------------------------------------
		   if (isMovieFound == true)
		       System.out.println("The movie title is found");
		   else 
				System.out.println("The movie title is not found");
		   //--------------------------------------------------------------
		   
		 //This code is to search for a specific member
		     System.out.println("Enter a member name to search for:");
			   String memberToSearch = input.next();	
			   boolean isMemberFound = false;	
			   
		   //Linear Search----------------------------------------------
		   for (int index = 0; index < memberNames.size(); index++) {
		        if (memberNames.get(index).equals(memberToSearch)) 
		        	isMemberFound = true;     
		    }
		   //------------------------------------------------------------
		   if (isMemberFound == true)
		       System.out.println("The member is found");
		   else if (isMemberFound == false)
				   System.out.println("The member is not found");
		   //--------------------------------------------------------------
	}
}