class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //res.add(new ArrayList<>());
        for (int i: nums) {
            int len = res.size();
            for (int j = len - 1; j >= 0; j--) {
                List<Integer> l = new ArrayList<>(res.get(j));
                l.add(i);
                res.add(l);
            }
            List<Integer> num = new ArrayList<>();
            num.add(i);
            res.add(num);
        }
        res.add(new ArrayList<>());
        return res;
    }

}
