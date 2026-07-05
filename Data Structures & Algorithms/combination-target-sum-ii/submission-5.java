class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return help(candidates, target, new ArrayList<>(), 0, 0);
    }

    private List<List<Integer>> help(int[] nums, int target, List<Integer> list, int sum, int i) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>(list);
        // FORSCHEN - OBJECT/MUTABILITY!!!
        if (sum == target) {
            res.add(l);
            //System.out.println(l);
            //System.out.println(res);
            return res;
        }

        for (int j = i; j < nums.length; j++) {
            //if (j > i && nums[j] == nums[j - 1]) continnue;
            if (sum + nums[j] > target) break;
            l.add(nums[j]);
            //System.out.println(l);
            sum += nums[j];
            res.addAll(help(nums, target, l, sum, j + 1));
            //System.out.println(res);
            sum -= nums[j];
            l.remove(l.size() - 1);
            while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
        }

        return res;
    }
}
