package se.fortnox.mvc_thymelaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

/**
 *
 * @author #JavaInspires
 *
 *         Controller Class
 */
@Controller
public class UserController {



    // Autowire jdbc template
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping(path = "addbox")
    public String addUser(User user) {


        // insert query
        String insert_query = "insert into boxuser (username,weight,color,country)"
                + " values(?,?,?,?);";

        //returns no of rows inserted = 1
        int rows = jdbcTemplate.update(insert_query,
                user.getUsername(),
                user.getWeight(),
                user.getColor(),
                user.getCountry());

        if (rows == 1) {
            return "success";
        } else {
            return "error";
        }

    }
}
