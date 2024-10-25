class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        boolean[] freq = new boolean[nums.length]; 
        getPermutations(nums, freq, res, new ArrayList<>());
        return res;
    }

    static void getPermutations(int[] arr, boolean[] freq, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds)); 
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (freq[i]) continue;
           
            if (i > 0 && arr[i] == arr[i - 1] && !freq[i - 1]) continue;

            freq[i] = true; 
            ds.add(arr[i]);
            getPermutations(arr, freq, ans, ds);
            ds.remove(ds.size() - 1); 
            freq[i] = false;
    }
}}
