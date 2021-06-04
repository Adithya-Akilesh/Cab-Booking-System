public class Customer 
{
    private String name;
    private String username;
    private String password;


    Customer(String name,String username,String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
    }


    @Override
    public String toString()
    {
        return "Name: "+this.name+" Username: "+this.username+" Pass: "+this.password;
    }


    @Override
    public int hashCode()
    {
        return this.username.hashCode()*this.password.hashCode();
    }


    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Customer)
        {
            Customer object = (Customer)obj;
            if(this.username.equals(object.username) && this.password.equals(object.password) && this.name.equals(object.name))
                return true;
            else
                return false;
        }
        else    
            return false;
    }


    public String getUsername()
    {
        return this.username;
    }


    public String getPassword()
    {
        return this.password;
    }


    public String getName()
    {
        return this.name;
    }

}
