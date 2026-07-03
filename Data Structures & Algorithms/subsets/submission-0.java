class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //res.add(new ArrayList<>());
        for (int i: nums) {
            int len = res.size();
            for (int j = len - 1; j >= 0; j--) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                for (int h = 0; h < res.get(j).size(); h++) {
                    l.add(res.get(j).get(h));
                }
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
