class TrieNode{

    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        children=new TrieNode[26];
        isWord=false;
    }
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root=new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr=root;

        for(int i=0;i<word.length();i++){

            char ch=word.charAt(i);
            int index=ch-'a';

            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            }

            curr=curr.children[index];
        }

        curr.isWord=true;
    }

    public boolean search(String word) {

        TrieNode curr=root;

        for(int i=0;i<word.length();i++){

            char ch=word.charAt(i);
            int index=ch-'a';

            if(curr.children[index]==null){
                return false;
            }

            curr=curr.children[index];
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr=root;

        for(int i=0;i<prefix.length();i++){

            char ch=prefix.charAt(i);
            int index=ch-'a';

            if(curr.children[index]==null){
                return false;
            }

            curr=curr.children[index];
        }

        return true;
    }
}