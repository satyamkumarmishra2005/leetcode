class Solution {
    public boolean makesquare(int[] matchsticks) {

        int perimeter=0;

        for(int num: matchsticks){
            perimeter = perimeter+ num;
        }

        if(perimeter%4!=0){
            return false;
        }

        int side = perimeter/4;


    boolean[] visited = new boolean[matchsticks.length];

    return backtrack(matchsticks, side, 0,0,0, visited);
        
    }

    public boolean backtrack(int[] matchsticks, int side , int currside, int count, int indx, boolean[] visited){

        
        if(count==4){
            return true;
        }

        if(side==currside){
            return backtrack(matchsticks, side , 0, count+1,0, visited);
        }


        for(int i= indx; i< matchsticks.length; i++ ){

            if(visited[i]){
                continue;
            }

            if(currside + matchsticks[i] > side){
                continue;
            }


            visited[i] = true;

            if(backtrack(matchsticks,side,currside+matchsticks[i],count,i+1,visited)){
                return true;
            }

            visited[i]= false;
        }

        return false;
    }
}