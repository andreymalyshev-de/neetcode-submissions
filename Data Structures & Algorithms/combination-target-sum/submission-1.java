class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        Set<List<Integer>> res2 = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            res.addAll(help(new ArrayList<>(), Arrays.copyOfRange(nums, i, nums.length), target));
        }

        Iterator<List<Integer>> it = res.iterator();
        while(it.hasNext()) {
            List<Integer> l = it.next();
            Collections.sort(l);
            res2.add(l);
        }

        List<List<Integer>> res3 = new ArrayList<>(res2);

        return res3;
    }

    private Set<List<Integer>> help(List<Integer> set, int[] nums, int target) {
        List<Integer> l = new ArrayList<>(set);
        Set<List<Integer>> res = new HashSet<>();
        //System.out.println(l);
        int sum = 0;

        for (int i: l) {
            sum += i;
        }

        if (sum == target) {
            res.add(l);
            
            return res;
        }
        else if (sum > target) {
            return res;
        }
        else {
            for (int i: nums) {
                if (sum + i > target) break;
                List<Integer> tmp = new ArrayList<>(l);
                l.add(i);
                res.addAll(help(l, nums, target));
                l = tmp;
                //System.out.println(res);
            }
        }

        return res;
    }
}
