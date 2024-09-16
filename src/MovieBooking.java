import java.util.*;

public class MovieBooking
{

    public static void printAllMovies(String[] movieNames)
    {
        System.out.println("Blockbuster Movies near you \n***************************");
        for (int i = 0; i < movieNames.length; i++)
        {
            System.out.println((i + 1) + "." + " " + movieNames[i]);
        }
    }

    // Method to print movies of a specific theatre
    public static void printAllMovies(Movie[] movies)
    {
        System.out.println("Blockbuster movies near you");
        for (int i = 0; i < movies.length; i++)
        {
            System.out.println((i + 1) + "." + " " + movies[i].getMovieName());
        }
    }

    public static void printAllTheatres(String[] theatreNames)
    {
        System.out.println("Best Cinemas near you \n***************************");
        for (int i = 0; i < theatreNames.length; i++)
        {
            System.out.println((i + 1) + "." + " " + theatreNames[i]);
        }
    }

    // Method to print theatres of a specific movie
    public static void printAllTheatres(Theatre[] theatres, String movie)
    {
        System.out.println("Cinemas Showing your selected " + movie);
        for (int i = 0; i < theatres.length; i++)
        {
            System.out.println((i + 1) + "." + " " + theatres[i].getTheatreName());
        }
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        User user = new User("Yaseen Sidhik", 9633702159l, "sidhikyaseen@gmail.com");

        Theatre[] theatres = new Theatre[]
        {
                new Theatre("Cineplex", "Downtown", 9876543210L,
                        new String[]
                        {
                                "10:00 AM", "1:00 PM", "4:00 PM", "7:00 PM"
                        },
                        new Movie[]
                        {}, 150.0, 500),

                new Theatre("Galaxy", "Suburb", 8765432109L,
                        new String[]
                        {
                                "9:00 AM", "12:00 PM", "3:00 PM", "6:00 PM"
                        },
                        new Movie[]
                        {}, 250.50, 700),

                new Theatre("Starlight", "Eastside", 9123456780L,
                        new String[]
                        {
                                "11:00 AM", "2:00 PM", "5:00 PM", "8:00 PM"
                        },
                        new Movie[]
                        {}, 400.0, 1500),

                new Theatre("Grand Cinemas", "West End", 8987654321L,
                        new String[]
                        {
                                "10:30 AM", "1:30 PM", "4:30 PM", "7:30 PM"
                        },
                        new Movie[]
                        {}, 75.0, 300),

                new Theatre("Silver Screen", "City Center", 9871234567L,
                        new String[]
                        {
                                "11:15 AM", "2:15 PM", "5:15 PM", "8:15 PM"
                        },
                        new Movie[]
                        {}, 200, 600),
        };

        // Movies

        Movie[] movies = new Movie[]
        {
                new Movie("Inception", "Christopher Nolan", "PG-13", "Syncopy", 8.8,
                        "2010-07-16", new String[]
                        {
                                "Mind-bending masterpiece!", "A cinematic experience!"
                        },
                        new Theatre[]
                        {
                                theatres[0], theatres[1]
                        }),

                new Movie("The Dark Knight", "Christopher Nolan", "PG-13", "Warner Bros.", 9.0,
                        "2008-07-18", new String[]
                        {
                                "Best superhero movie ever!", "Masterpiece!"
                        },
                        new Theatre[]
                        {
                                theatres[2], theatres[3]
                        }),

                new Movie("Interstellar", "Christopher Nolan", "PG-13", "Paramount", 8.6,
                        "2014-11-07", new String[]
                        {
                                "Emotional and thought-provoking!", "Stunning visuals and story."
                        },
                        new Theatre[]
                        {
                                theatres[4], theatres[0]
                        }),

                new Movie("Avatar", "James Cameron", "PG-13", "20th Century Fox", 7.8,
                        "2009-12-18", new String[]
                        {
                                "Visually stunning!", "Groundbreaking VFX!"
                        },
                        new Theatre[]
                        {
                                theatres[4], theatres[3]
                        }),

                new Movie("Joker", "Todd Phillips", "R", "Warner Bros.", 8.5,
                        "2019-10-04", new String[]
                        {
                                "A haunting portrayal!", "Outstanding performance by Joaquin Phoenix!"
                        },
                        new Theatre[]
                        {
                                theatres[2], theatres[1]
                        }),
        };

        theatres[0].setShowingMovies(new Movie[]
        {
                movies[0], movies[1]
        });
        theatres[1].setShowingMovies(new Movie[]
        {
                movies[2], movies[3]
        });
        theatres[2].setShowingMovies(new Movie[]
        {
                movies[4], movies[0]
        });
        theatres[3].setShowingMovies(new Movie[]
        {
                movies[1], movies[4]
        });
        theatres[4].setShowingMovies(new Movie[]
        {
                movies[2], movies[3]
        });

        System.out.println(
                "How do you want to proceed ? \n \n Press 1 for Blockbuster Movies \n Press 2 for Nearest Cinemas");

        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                String[] movieNames = Movie.getAllMovieNames(movies);
                System.out.println("Please select a film");
                printAllMovies(movieNames);
                int movieChoice = sc.nextInt();
                Movie chosenMovie = movies[movieChoice - 1];
                Theatre[] availableTheatres = chosenMovie.getShowingTheatres();
                System.out.println("Please Choose a Theatre");
                printAllTheatres(availableTheatres, movieNames[movieChoice - 1]);
                int theatreChoice = sc.nextInt();
                System.out.println("Please enter the number of seats you want");
                int numberOfSeatsForUser = sc.nextInt();
                boolean isSeatAvailable = theatres[theatreChoice - 1].isSeatsAvailable(numberOfSeatsForUser);
                if (isSeatAvailable)
                {
                    System.out.println("Seat Selection Success, Proceed to payment");
                    double amountToBePaid = theatres[theatreChoice - 1].calculateTicketCost(numberOfSeatsForUser);
                    System.out.println("Amout to be paid Rs." + amountToBePaid);
                    System.out.println("Press 1 to proceed \nPress 2 to Cancel");
                    int proceed = sc.nextInt();
                    if (proceed == 1)
                    {
                        theatres[theatreChoice - 1].printTicket(chosenMovie, user, amountToBePaid);
                    } else
                    {
                        System.out.println("Please Visit again");
                        break;
                    }
                } else
                {
                    System.out.println("Selected number of seats are not available, thank you for choosing us");
                }
                break;
            case 2:
                String[] theatreNames = Theatre.getAllTheatreNames(theatres);
                System.out.println("Please Select a Theatre");
                printAllTheatres(theatreNames);
                int theatreChosen = sc.nextInt();
                Theatre usersChosenTheatre = theatres[theatreChosen - 1];
                Movie[] availableMoviesInTheatre = usersChosenTheatre.getShowingMovies();
                Movie[] availableMovies = usersChosenTheatre.getShowingMovies();
                printAllMovies(availableMovies);
                System.out.println("Please Select a movie");
                int movieTheatreChoice = sc.nextInt();
                Movie movieChosenFromTheatre = availableMoviesInTheatre[movieTheatreChoice - 1];
                System.out
                        .println("You have chosen " + movieChosenFromTheatre.getMovieName()
                                + "\nPlease Enter the number of seats you want");
                int numberOfSeatsTheatre = sc.nextInt();
                boolean theatreIsSeatAvailable = usersChosenTheatre.isSeatsAvailable(numberOfSeatsTheatre);
                if (theatreIsSeatAvailable)
                {
                    System.out.println("Seat Selection success");
                    double amountToBePaidTheatre = usersChosenTheatre.calculateTicketCost(numberOfSeatsTheatre);
                    System.out.println("Amount to paid Rs" + amountToBePaidTheatre);
                    System.out.println("Press 1 to Pay and Proceed \nPress 2 to Cancel");
                    int proceedTheatre = sc.nextInt();
                    if (proceedTheatre == 1)
                    {
                        usersChosenTheatre.printTicket(movieChosenFromTheatre, user, amountToBePaidTheatre);
                    } else
                    {
                        System.out.println("Please Visit again");
                        break;
                    }
                } else
                {
                    System.out.println("Selected number of seats are not available, thank you for choosing us");
                }
                break;
            default:
                System.out.println("Invalid Choice Try again");
        }

        sc.close();

    }

}
