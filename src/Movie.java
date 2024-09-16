class Movie
{
    private String movieId;
    private String movieName;
    private String directorName;
    private String censorRating;
    private String productionName;
    private double movieRating;
    private String releaseDate;
    private String[] reviews;
    private static int counter;
    private Theatre[] showingTheatres;

    static
    {
        counter = 0;
    }

    // Constructor
    public Movie(String movieName, String directorName, String censoRating, String productionName, double movieRating,
            String releaseDate, String[] reviews, Theatre[] showingTheatres)
    {
        counter++;
        this.movieName = movieName;
        this.directorName = directorName;
        this.censorRating = censoRating;
        this.productionName = productionName;
        this.movieRating = movieRating;
        this.releaseDate = releaseDate;
        this.reviews = reviews;
        this.showingTheatres = showingTheatres;
        this.movieId = this.movieName.substring(0, 2).toUpperCase() + "00" + counter;
    }

    // Getters
    public String getMovieId()
    {
        return movieId;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public String getDirectorName()
    {
        return directorName;
    }

    public String getCensorRating()
    {
        return censorRating;
    }

    public String getProductionName()
    {
        return productionName;
    }

    public double getMovieRating()
    {
        return movieRating;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public String[] getReviews()
    {
        return reviews;
    }

    // Setters
    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    public void setDirectorName(String directorName)
    {
        this.directorName = directorName;
    }

    public void setCensorRating(String censorRating)
    {
        this.censorRating = censorRating;
    }

    public void setProductionName(String productionName)
    {
        this.productionName = productionName;
    }

    public void setMovieRating(double movieRating)
    {
        this.movieRating = movieRating;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public void setReviews(String[] reviews)
    {
        this.reviews = reviews;
    }

    public Theatre[] getShowingTheatres()
    {
        return this.showingTheatres;
    }

    public void setShowingTheatres(Theatre[] showingTheatres)
    {
        this.showingTheatres = showingTheatres;
    }

    // Method to print the movie Details
    public void printMovieDetails()
    {
        System.out.println("Movie ID: " + this.movieId);
        System.out.println("Movie Name: " + this.movieName);
        System.out.println("Censor Rating: " + this.censorRating);
        System.out.println("Movie Rating: " + this.movieRating);
        System.out.println("Director Name: " + this.directorName);
        System.out.println("Producded By: " + this.productionName);
        System.out.println("Producded By: " + this.productionName);
        if (this.reviews.length == 0)
        {
            System.out.println("No Reviews Yet");
        } else
        {
            for (int i = 0; i < this.reviews.length; i++)
            {
                System.out.println("Review No: " + (i + 1));
                System.out.println(this.reviews[i]);
            }
        }
    }

    public static String[] getAllMovieNames(Movie[] movies)
    {
        String[] movieNames = new String[movies.length];
        for (int i = 0; i < movies.length; i++)
        {
            movieNames[i] = movies[i].getMovieName();
        }
        return movieNames;
    }

}
