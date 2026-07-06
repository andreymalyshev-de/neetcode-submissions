class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.stream(nums).boxed().toList());
        res.addAll(help(Arrays.stream(nums).boxed().toList(), nums, 0));
        return res;
    }

    private List<List<Integer>> help(List<Integer> list, int[] nums, int i) {
        List<List<Integer>> res = new ArrayList<>();

        for (i = i; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> l = new ArrayList<>(list);
                int tmp = l.get(i);
                l.set(i, list.get(j));
                l.set(j, tmp);
                res.add(l);
                res.addAll(help(l, nums, i + 1));
            }
        }

        return res;
    }
}
