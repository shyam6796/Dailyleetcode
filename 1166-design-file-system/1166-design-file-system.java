class FileSystem {
    HashMap<String,Integer> map ;
    public FileSystem() {
        map =new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(path.equals("") || path.equals("/") || map.containsKey(path)) return false;
        String tokens [] = path.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        
        for(int i=1; i<tokens.length-1; i++){
            sb.append(tokens[i]);
            if(!map.containsKey(sb.toString())) return false;
            sb.append("/");
        }
        
        map.put(path,value);
        return true;
    }
    
    public int get(String path) {
      return map.containsKey(path) ? map.get(path) : -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */