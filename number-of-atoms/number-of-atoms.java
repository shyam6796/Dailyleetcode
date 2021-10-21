class Solution {
    public class AtomCount{
        public String atom;
        public int count;
        
        public AtomCount(String atom, int count){
            this.atom = atom;
            this.count = count;
        }
        public boolean isParnthes(){
            return atom.equals("(");
        }
    }
    
    public String countOfAtoms(String formula) {
      Stack<AtomCount> stack = new Stack<>();
      int index=0;
      while(index <formula.length()){
          char c =formula.charAt(index);
          if(c=='('){
              stack.add(new AtomCount("(",0));
              index++;
          }else if(c==')'){
              List<AtomCount> list = new ArrayList<>();
              while(!stack.isEmpty()){
                    AtomCount atom = stack.pop();
                    if(atom.isParnthes()){
                        break;
                    }
                  list.add(atom);
              }
             index++;
             int count =1;
             if(index <formula.length() && Character.isDigit(formula.charAt(index))){
                  String countStr =getCount(formula,index);
                  index +=countStr.length();
                 count = Integer.parseInt(countStr);
                }
            for(AtomCount item :list){
                item.count *=count;
                stack.add(item);
            }
        }else{
              String atom = getAtom(formula,index);
              index +=atom.length();
              int count =1;
               if(index <formula.length() && Character.isDigit(formula.charAt(index))){
                  String countStr =getCount(formula,index);
                  index +=countStr.length();
                 count = Integer.parseInt(countStr);
                }
              
              stack.add(new AtomCount(atom,count));
          }       
      }
       return stackToString(stack); 
    }
    
    public String getCount(String formula, int idx){
        StringBuilder sb = new StringBuilder();
       
        while(idx <formula.length()){
            if(!Character.isDigit(formula.charAt(idx))){
                break;
            }
            sb.append(formula.charAt(idx));
            idx++;
            
        }
        return sb.toString();
    }
    
    public String getAtom(String formula, int idx){
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(idx));
        idx++;
          while(idx <formula.length()){
            if(!Character.isAlphabetic(formula.charAt(idx))){
                break;
            }
            if(Character.isUpperCase(formula.charAt(idx))){
                break;
            }
            sb.append(formula.charAt(idx));
            idx++;  
          }
        return sb.toString();
    }
               
     public String stackToString(Stack<AtomCount> stack){
        TreeMap<String,Integer> map = new TreeMap<>();
         while(!stack.isEmpty()){
             AtomCount item =stack.pop();
             map.put(item.atom, map.getOrDefault(item.atom,0)+item.count);
         }
         
         StringBuilder sb = new StringBuilder();
         
         for(String s : map.keySet()){
             sb.append(s);
             if(map.get(s)==1){
                 continue;
             }
             sb.append(Integer.toString(map.get(s)));
         }

        return sb.toString();        
     }          
               
}