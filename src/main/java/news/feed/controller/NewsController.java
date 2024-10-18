package news.feed.controller;


import news.feed.model.NewsAPIResponse;
import news.feed.services.NewsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public NewsAPIResponse getNews() {
        return newsService.getNews();
    }
    @GetMapping("/")
    public String getHome() {
        return "Home Page";
    }
}
