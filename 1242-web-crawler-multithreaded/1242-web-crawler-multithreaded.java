/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    class Crawler implements Runnable{
        public String startUrl;
        public String hostName;
        public HtmlParser htmlParser;
        public static Set<String> set;
        public static ExecutorService pool;
        
        public Crawler( String startUrl, String hostName, HtmlParser htmlParser){
            this.startUrl =startUrl;
            this.hostName =hostName;
            this.htmlParser =htmlParser;
        }
        
        @Override
        public void run(){
            if(startUrl.startsWith(hostName) && !set.contains(startUrl)){
                set.add(startUrl);
                List<Future<?>> list =new ArrayList<>();
                for(String url :htmlParser.getUrls(startUrl)){
                    Crawler crawler = new Crawler(url, hostName,htmlParser);
                    list.add(pool.submit(crawler));
                }
                
                for(Future<?> T : list){
                    joinThread(T);
                }
            }
        }
        
        public static void joinThread(Future<?> task){
            try{
               task.get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
    }  
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        int index =startUrl.indexOf('/',7);
        String hostName = index == -1 ?startUrl : startUrl.substring(0,index);
        
        Crawler crawler = new Crawler(startUrl,hostName, htmlParser);
        ConcurrentHashMap<String,Boolean> map = new ConcurrentHashMap<>();
        crawler.set =map.newKeySet();
            
        ExecutorService pool =  Executors.newFixedThreadPool(500);
        crawler.pool =pool;
        
        Future<?> task = pool.submit(crawler);
        crawler.joinThread(task);
        pool.shutdown();
        
        
        return new ArrayList<>(crawler.set);
        
        
    }
}