class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        if (nums.length < 2) return false;

        HashSet<Integer> set = Arrays.stream(nums).distinct().boxed().collect(Collectors.toCollection(HashSet::new));

        if (set.size() < nums.length) return true;
        /* System.gc(); */

        return false;
    }
}