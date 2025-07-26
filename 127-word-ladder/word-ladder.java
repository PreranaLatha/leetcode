class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> wordSet=new HashSet<>(wordList);
       if(!wordSet.contains(endWord))return 0; 

       Queue<String> q=new LinkedList<>();
       q.offer(beginWord);
       int s=1;

       while(!q.isEmpty()){
        int size=q.size();
        while(size-->0){
            String word=q.poll();
            if(word.equals(endWord))return s;

            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char[] chs=word.toCharArray();
                    chs[i]=c;
                    String ns=new String(chs);

                    if(wordSet.contains(ns)){
                        q.offer(ns);
                        wordSet.remove(ns);
                    }
                }
            }
        }s++;
       }return 0;
    }
}