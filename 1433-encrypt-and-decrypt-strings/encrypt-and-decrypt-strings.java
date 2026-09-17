class Encrypter {
    class TrieNode{
        int count;
        TrieNode[] letter;
        public TrieNode(){
            letter=new TrieNode[26];
            count=0;
        }
        
        public void add(String s){
            TrieNode p=this;
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(p.letter[ch-97]==null){
                    p.letter[ch-97]=new TrieNode();
                }
                p=p.letter[ch-97];
            }
            p.count++;
        }
        
    }
    Map<Character,String> charMap;
    TrieNode root;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        charMap=new HashMap<>();
        root=new TrieNode();
        for(int i=0;i<keys.length;i++){
            charMap.put(keys[i],values[i]);
        }
        for(String word:dictionary){
            String encrypted=encrypt(word);
            if(null!=encrypted)
                root.add(encrypted);
        }
    }
    public String encrypt(String word1) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word1.length();i++){
            if(charMap.get(word1.charAt(i))==null)
                return null;
            sb.append(charMap.get(word1.charAt(i)));
        }
        return sb.toString();
    }
    public int decrypt(String word2) {
        TrieNode p=root;
        for(int i=0;i<word2.length();i++){
            p=p.letter[word2.charAt(i)-97];
            if(p==null)
                return 0;
        }
        return p.count;
    }
}
/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */