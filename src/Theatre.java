public class Theatre
{
    private String theatreId;
    private String theatreName;
    private String theatreLocation;
    private long theatreContact;
    private String[] showTimings;
    private static int counter;
    private Movie[] showingMovies;
    private double ticketCost;
    private int numberOfSeats;

    static
    {
        counter = 0;
    }

    // Constructor
    public Theatre(String theatreName, String theatreLocation, long theatreContact, String[] showTimings,
            Movie[] showingMovies, double ticketCost, int numberOfSeats)
    {
        counter++;
        this.theatreName = theatreName;
        this.theatreLocation = theatreLocation;
        this.theatreContact = theatreContact;
        this.showTimings = showTimings;
        this.showingMovies = showingMovies;
        this.theatreId = theatreName.substring(0, 2).toUpperCase() + "00" + counter;
        this.ticketCost = ticketCost;
        this.numberOfSeats = numberOfSeats;
    }

    // Getters
    public String getTheatreId()
    {
        return theatreId;
    }

    public String getTheatreName()
    {
        return theatreName;
    }

    public String getTheatreLocation()
    {
        return theatreLocation;
    }

    public long getTheatreContact()
    {
        return theatreContact;
    }

    public String[] getShowTimings()
    {
        return showTimings;
    }

    public Movie[] getShowingMovies()
    {
        return showingMovies;
    }

    // Setters
    public void setTheatreName(String theatreName)
    {
        this.theatreName = theatreName;
    }

    public void setTheatreLocation(String theatreLocation)
    {
        this.theatreLocation = theatreLocation;
    }

    public void setTheatreContact(long theatreContact)
    {
        this.theatreContact = theatreContact;
    }

    public void setShowTimings(String[] showTimings)
    {
        this.showTimings = showTimings;
    }

    public void setShowingMovies(Movie[] showingMovies)
    {
        this.showingMovies = showingMovies;
    }

    public double getTicketCost()
    {
        return this.ticketCost;
    }

    public void setTicketCost(double ticketCost)
    {
        this.ticketCost = ticketCost;
    }

    public int getNumberOfSeats()
    {
        return this.numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }

    // Print details
    public void printDetails()
    {
        System.out.println("Theatre ID: " + theatreId);
        System.out.println("Theatre Name: " + theatreName);
        System.out.println("Theatre Location: " + theatreLocation);
        System.out.println("Theatre Contact: " + theatreContact);
    }

    public double calculateTicketCost(int numberOfSeats)
    {
        double cost = numberOfSeats * ticketCost;
        return Math.round(cost * 100.0) / 100.0;
    }

    public boolean isSeatsAvailable(int seatsUserWants)
    {
        if (seatsUserWants > this.numberOfSeats)
        {
            return false;
        }
        return true;
    }

    public void printTicket(Movie chosenMovie, User user, double amountToBePaid)
    {
        System.out.println("Thank you for booking with us, " + user.getUserName());
        System.out.println("Your ticket has been confirmed");
        printBarcode();
        System.out.println("Amount Paid: " + amountToBePaid);
        System.out.println("Movie Name: " + chosenMovie.getMovieName());
        System.out.println("Directed By: " + chosenMovie.getDirectorName());
        System.out.println("Production: " + chosenMovie.getProductionName());
        System.out.println("Censor Rating: " + chosenMovie.getCensorRating());
        if (chosenMovie.getCensorRating() == "R")
        {
            System.out.println("Your chosen film is 'R' rated, do not bring anyone under 18");
        }
        System.out.println("Release Date: " + chosenMovie.getReleaseDate());
        System.out.println("**************************************");
        System.out.println("Than you for choosing " + this.theatreName);
    }

    public static String[] getAllTheatreNames(Theatre[] theatres)
    {
        String[] theatreNames = new String[theatres.length];
        for (int i = 0; i < theatres.length; i++)
        {
            theatreNames[i] = theatres[i].getTheatreName();
        }
        return theatreNames;
    }

    public static void printBarcode()
    {
        System.out.println("|**|**|**|**|**|**|**|**|**|**|");
        System.out.println("|**|  |**|**|**|  |**|**|  |**|**|");
        System.out.println("|**|**|**|**|  |**|**|**|**|**|**|");
        System.out.println("|**|  |**|**|**|**|  |**|**|**|**|");
        System.out.println("|**|**|  |**|**|**|**|**|**|**|**|");
        System.out.println("|**|**|**|  |**|**|**|  |**|**|**|");
        System.out.println("|**|**|**|**|**|**|**|**|**|**|**|");
    }
}
