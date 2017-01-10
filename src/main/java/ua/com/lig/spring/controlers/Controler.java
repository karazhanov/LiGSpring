package ua.com.lig.spring.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.lig.spring.configs.beans.UserService;

/**
 * @author karazhanov on 10.01.17.
 */
@RestController
@RequestMapping("/user/")
public class Controler {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public TST test() throws Exception {
        userService.logUser();
        TST t = new TST();
        t.hello = "HELLO";
        t.id = 10;
        throw new Exception("! error !");
//        return t;
    }
}
