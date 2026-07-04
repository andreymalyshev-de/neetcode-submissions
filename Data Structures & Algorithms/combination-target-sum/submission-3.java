class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        //for (int i = 0; i < nums.length; i++) {
            res.addAll(help(new ArrayList<>(), nums, target, 0, 0));
        //}

        return res;
    }

    private List<List<Integer>> help(List<Integer> set, int[] nums, int target, int sum, int j) {
        List<Integer> l = new ArrayList<>(set);
        List<List<Integer>> res = new ArrayList<>();
        //System.out.println(l);
        if (sum == target) {
            res.add(l);
            return res;
        }

        else {
            for (int i = j; i < nums.length;) {
                sum += nums[i];
                if (sum > target) break;
                l.add(nums[i]);
                res.addAll(help(l, nums, target, sum, i));
                l.remove(l.size() - 1);
                sum -= nums[i];
                i++;
                //System.out.println(res);
            }
        }

        return res;
    }
}
