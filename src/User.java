class User
{
    private String userId;
    private String userName;
    private long userPhone;
    private String userEmail;
    private static int counter;

    static
    {
        counter = 0;
    }

    // Constructor
    public User(String userName, long userPhone, String userEmail)
    {
        counter++;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userId = "U00" + counter;
    }

    // Getters
    public String getUserId()
    {
        return this.userId;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public long getUserPhone()
    {
        return this.userPhone;
    }

    public String getUserEmail()
    {
        return this.userEmail;
    }

    // Setters
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setUserPhone(long userPhone)
    {
        this.userPhone = userPhone;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    // Method to Print User Details
    public void printUserDetails()
    {
        System.out.println("User ID: " + this.userId);
        System.out.println("User Name: " + this.userName);
        System.out.println("User Phone: " + this.userPhone);
        System.out.println("User Email: " + this.userEmail);
    }

}
