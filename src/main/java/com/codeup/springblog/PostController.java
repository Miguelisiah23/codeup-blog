package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String all(){
        return "<h1>Here are all the posts</h1>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable int id){

        return String.format("<h1>Here is the post with the id of %d</h1>",id);
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String creatForm(){
        return "<h1>Here is a create ad form</h1>" +
                "<form action='/posts/create' method='post'>" +
                "<button type='submit'>Submit</button>" +
                "</form>";
    }

    @RequestMapping(path = "/posts/create",method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "this is the post you created";
    }

}
