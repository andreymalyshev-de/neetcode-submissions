class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return help(new ArrayList<>(), nums, 0);
    }

    private List<List<Integer>> help(List<Integer> list, int[] nums, int i) {
        List<Integer> l = new ArrayList<>(list);
        List<List<Integer>> res = new ArrayList<>();
        res.add(l);

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            l.add(nums[j]);
            res.addAll(help(l, nums, j + 1));
            l.remove(l.size() - 1);
        }

        return res;
    }
}