package kr.hs.emirim.nmb2017.springmvc4.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired private Twitter twitter;
 @RequestMapping("/") 
 public String twitter(@RequestParam(defaultValue="������") String search, Model model ) {
	 
	 SearchResults searchResults = twitter.searchOperations().search(search);

	 List<String> tweets = searchResults.getTweets()             
			  .stream().map(Tweet::getText).collect(Collectors.toList()); 
			  model.addAttribute("tweets", tweets);
			  return "tweets";
			 }
			}
//	@ResponseBody
//	public String Hello() {
//		return "Hello World"; 
//	}

