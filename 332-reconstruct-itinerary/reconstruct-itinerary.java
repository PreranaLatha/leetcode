class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,List<String>> h=new HashMap<>();
        for(List<String> t:tickets){
            h.computeIfAbsent(t.get(0), k -> new ArrayList<>()).add(t.get(1));
        }

        for(List<String> dest:h.values()){
            Collections.sort(dest);
        }

        LinkedList<String> itenary=new LinkedList<>();
        dfs("JFK",h,itenary);
        return itenary;
    }

    private void dfs(String s, HashMap<String,List<String>> h,LinkedList<String> itenary){
        List<String> destination=h.get(s);

        while(destination!=null && !destination.isEmpty()){
             String next=destination.remove(0);
            dfs(next,h,itenary);
        }
        itenary.addFirst(s);
    }
}
