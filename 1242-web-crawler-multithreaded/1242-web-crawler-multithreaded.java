/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    Set<String> result  = new HashSet<String>();
        
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {            
        crawl(startUrl, htmlParser, startUrl);
        List<String> finalResult = new ArrayList<String>();
        finalResult.addAll(result);
        return finalResult; 
    }
    
    private void crawl(String startUrl, HtmlParser htmlParser, String currentUrl) {
        result.add(currentUrl);
        List<String> childUrls = htmlParser.getUrls(currentUrl);
            
          Set<String> validChildren = new HashSet<String>();
            
           
        childUrls.parallelStream().filter( url ->          
              !result.contains(url) && getHostName(url).equals(getHostName(startUrl)) 
            ).forEach(url -> crawl(startUrl, htmlParser, url));
       
    }

    private String getHostName(String url){
        return url.split("http://")[1].split("/")[0];
    }
}