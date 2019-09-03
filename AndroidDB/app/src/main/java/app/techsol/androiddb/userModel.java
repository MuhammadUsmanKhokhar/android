package app.techsol.androiddb;

public class userModel {
    String Name;
    String email;
    String password;
    String contactno;
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getContactno(){
        return contactno;
    }
    public void setContactno(String contactno){
        this.contactno=contactno;
    }

}
