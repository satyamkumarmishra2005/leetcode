class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return solve(price, special, needs, 0);
    }

    public int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if (index >= special.size()) {
            int ans = 0;

            for (int i = 0; i < needs.size(); i++) {
                ans += needs.get(i) * price.get(i);
            }

            return ans;
        }

        if (canBuy(needs, special.get(index))) {
            List<Integer> updatedNeeds = new ArrayList<>();

            for (int i = 0; i < needs.size(); i++) {
                updatedNeeds.add(needs.get(i) - special.get(index).get(i));
            }

            // it is allowing to multiple buy from same offer so not needed (i+1)
            int take = special.get(index).get(special.get(index).size()-1) + solve(price, special, updatedNeeds, index);
            int notTake = solve(price, special, needs, index + 1);

            return Math.min(take,notTake);
        } else {
            return solve(price, special, needs, index + 1);
        }
    }

    public boolean canBuy(List<Integer> needs, List<Integer> offer) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < offer.get(i)) {
                return false;
            }
        }

        return true;
    }
}