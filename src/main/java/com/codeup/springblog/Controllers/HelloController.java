package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){return  "<h1>hello from spring!<h1>";}

    @RequestMapping(path = "hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String HelloToYou(@PathVariable String name){return String.format("Nice to meet you %s",name);}
String fizzBuzzEval(int num){
        if(num % 3 == 0 && num % 5 == 0){
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";

        } else if (num % 5 == 0) {
            return "Buzz";

        } else {
            return String.format("%d",num);
        }
}
    @GetMapping("/number/{num}")
    @ResponseBody
    public String reportNumber(@PathVariable int num){
        String intro = String.format("Here are some truths about %d",num);
        String isEven = String.format("The number %d is even: %b",num, num % 2 == 0);
        String numSquared = String.format("The number %d is %d",num, (int) Math.pow(num,2));
        String fizzBuzzEval = String.format("The number %d when run through fizzbuzz would print %s",num,fizzBuzzEval(num));
        return String.format("<h3>%s</h3><ul><li>%s</li><li>%s</li><li>%s</li></ul>",intro,isEven,numSquared,fizzBuzzEval);

    }


}
