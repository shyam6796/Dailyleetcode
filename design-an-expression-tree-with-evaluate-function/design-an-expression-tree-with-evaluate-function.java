class Node {
    String val;
    Node left;
    Node right;
    
    public Node (String val) {
        
        this.val = val;
        left = null;
        right = null;
    }
    
    public int evaluate() {
        
        if (val.equals ("/")) {
            return left.evaluate () / right.evaluate ();
        }
        else if (val.equals ("*")) {
            return left.evaluate () * right.evaluate ();
        }
        else if (val.equals ("+")) {
            return left.evaluate () + right.evaluate ();
        }
        else if (val.equals ("-")) {
            return left.evaluate () - right.evaluate ();
        }
        
        return Integer.parseInt (val);
    }
};

class TreeBuilder {
    
    Stack<Node> stack = new Stack<> ();
    
    Node buildTree(String[] postfix) {
        
        for (String s : postfix) {
            Node node = new Node (s);
            if (s.equals ("/") || s.equals ("*") || s.equals ("+") || s.equals ("-")) {
                node.right = stack.pop ();
                node.left = stack.pop ();
            }
            
            stack.push (node);
        }
        
        return stack.pop ();
    }
};