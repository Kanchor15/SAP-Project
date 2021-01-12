package Okan.Project.entities;

import javax.persistence.*;

@Entity
public class Representative
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    /*public Representative()
    {

    }
    public Representative(Long id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    */

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}