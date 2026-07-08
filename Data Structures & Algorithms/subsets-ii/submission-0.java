class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(help(new ArrayList<>(), nums, 0));
    }

    private Set<List<Integer>> help(List<Integer> list, int[] nums, int i) {
        List<Integer> l = new ArrayList<>(list);
        Set<List<Integer>> res = new HashSet<>();
        res.add(l);

        for (int j = i; j < nums.length; j++) {
            l.add(nums[j]);
            res.addAll(help(l, nums, j + 1));
            l.remove(l.size() - 1);
        }

        return res;
    }
}
