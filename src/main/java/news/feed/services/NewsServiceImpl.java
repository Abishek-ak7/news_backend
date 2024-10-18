package news.feed.services;

import news.feed.model.NewsAPIResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsServiceImpl implements NewsService {

    private final String API_KEY = "31ecf2f2f2ea44ea890edea9c1733419";
    private final String URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY;
    private final RestTemplate restTemplate;

    // Constructor injection for RestTemplate
    public NewsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public NewsAPIResponse getNews() {
        try {
            return restTemplate.getForObject(URL, NewsAPIResponse.class);
        }catch (Exception e) {
            return new NewsAPIResponse();
        }
    }
}
