package com.cbmu.covidmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller // This means that this class is a Controller
@RequestMapping(path="/nyt-counts") // This means URL's start with /demo (after Application path)
public class NytCountsController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private NytCountsRepository nytCountsRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<NytCounts> getAllNationalCounts() {
        // This returns a JSON or XML with the users
        return nytCountsRepository.findAll();
    }

    @GetMapping(path = "/date/{date}")
    public @ResponseBody Iterable<NytCounts> getAllByDate(@PathVariable Date date) {
        return nytCountsRepository.findAllByDate(date);
    }


}
