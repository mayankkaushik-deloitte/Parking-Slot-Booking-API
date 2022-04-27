public class data {
    private String email;
    private String password;
    private String accesstoken;
    public data(String email,String password) {
        this.email = email;
        this.password = password;
    }
    public data(String accesstoken)
    {
        this.accesstoken=accesstoken;
    }
    public String getAccesstoken(String accesstoken)
    {
        return accesstoken;
    }
    public void setAccesstoken()
    {
        this.accesstoken=accesstoken;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
