class FileSystem {
    Map<String,Integer> map;
    public FileSystem() {
        map =new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(path.equals("") ||path.equals("/") ||map.containsKey(path)) return false;
        
        String dict[] =path.split("/");
        StringBuilder sb =new StringBuilder("/");
        
        for(int i=1; i<dict.length-1; i++){
            String token =dict[i];
            sb.append(token);
           
            if(!map.containsKey(sb.toString())) return false; 
            sb.append("/");
        }
        map.put(path,value);
        return true;
    }
    
    public int get(String path) {
     if(map.containsKey(path))return map.get(path);
    
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */