class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        List<int[]> filteredRestaurants = new ArrayList<>();
        for(int [] restaurant:restaurants){
            int id=restaurant[0];
            int rating = restaurant[1];
            int isVeganFriendly= restaurant[2];
            int price= restaurant[3];
            int distance = restaurant[4];
            if ((veganFriendly == 0 || isVeganFriendly == veganFriendly) &&
                price <= maxPrice && distance <= maxDistance) {
                filteredRestaurants.add(restaurant);
            }
        }
        filteredRestaurants.sort((a,b) -> {
            if(b[1] != a[1]){
                return b[1]-a[1];
            }else{
                return b[0]-a[0];
            }
        });
        List<Integer> result = new ArrayList<>();
        for (int[] restaurant : filteredRestaurants) {
            result.add(restaurant[0]);
        }

        return result;
    }
}