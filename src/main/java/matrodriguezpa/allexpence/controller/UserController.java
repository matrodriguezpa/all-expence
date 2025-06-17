package matrodriguezpa.allexpence.controller;

import java.util.List;
import matrodriguezpa.allexpence.model.User;
import matrodriguezpa.allexpence.dao.UserDAO;

public class UserController {

    private UserDAO userDAO;
    
    

    public void addBook(String name, String author) {
        User user = new User();
        user.setName(name);
        this.userDAO.saveOrUpdate(user);
    }

    public List<User> GetAllusers() {
        return userDAO.findAll();
    }
}
