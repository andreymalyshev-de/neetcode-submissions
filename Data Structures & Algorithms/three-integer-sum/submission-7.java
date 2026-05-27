class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       // sort the array and then hold one element while simultanuoulsy 
        // going through the array with two pointers

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        System.out.println(0 + " " + (0 + 1) + " " + (nums.length - 1));

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
            while (j < k) {

                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> l = new ArrayList(List.of(nums[i], nums[j], nums[k]));
                    if (!list.contains(l)) list.add(l);
                    j++; k--;
                }
                else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                else k--;

            }
        }
        return list;
    }
}
