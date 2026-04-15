class Solution {
    public List<Integer> diffWaysToCompute(String expression) {

        return solve(expression);

    }

        public List<Integer> solve(String s){

            List<Integer> result = new ArrayList<>();

            for(int i =0 ; i< s.length(); i++){

                char c = s.charAt(i);

                if(c=='+' || c=='-' || c=='*'){

                    List<Integer> leftresult = solve(s.substring(0,i));

                    List<Integer> rightresult = solve(s.substring(i+1));


                    for(int x : leftresult){

                        for(int y : rightresult){

                            if(c=='+'){

                                result.add(x+y);
                            }

                            else if(c=='-'){
                                result.add(x-y);
                            }

                            else{
                                result.add(x*y);
                            }
                        }
                    }
                }


                



            }


            if(result.isEmpty()){
                    result.add(Integer.parseInt(s));
                }


                return result;

        }

    }
