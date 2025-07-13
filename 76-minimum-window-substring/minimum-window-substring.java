 class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int k=0;k<t.length();k++)
        {
            char c=t.charAt(k);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=map.size();
        
        while(j<s.length())
        {
            char c=s.charAt(j);
            if(!map.containsKey(c))
            {
                j++;
                continue;
            }
            else if(map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    count--;
            }
            if(count==0)
            {
                if(min>j-i+1)
                {
                    ans=s.substring(i,j+1);
                    min=Math.min(min,j-i+1);
                }
                while(count==0)
                {
                    char c1=s.charAt(i);
                    if(!map.containsKey(c1))
                        i++;
                    else{
                        map.put(c1,map.get(c1)+1);
                        if(map.get(c1)>0)
                            count++;
                        i++;
                    }
                    if(count==0)
                    {
                        if(min>j-i+1)
                        {
                            ans=s.substring(i,j+1);
                            min=j-i+1;
                        }
                    }
                }
            }
            j++;
        }
        return ans;
    }
}