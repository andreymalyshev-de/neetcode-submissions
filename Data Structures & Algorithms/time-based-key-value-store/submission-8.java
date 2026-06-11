class TimeMap {

    private HashMap<String, List<Pair<String, Integer>>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<String, Integer> pair = new Pair(value, timestamp);
        List<Pair<String, Integer>> l = new ArrayList<>();

        if (hm.containsKey(key)) {
            l = hm.get(key);
            l.add(pair);
        }

        else {
            l.add(pair);
            hm.put(key, l);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) return "";

        List<Pair<String, Integer>> list = hm.get(key);
        int l = 0;
        int r = list.size() - 1;
        int i = 0;

        while (l <= r) {
            i = l + (r - l) / 2;
            int ts = list.get(i).getT();
            System.out.println(ts);

            if (timestamp == ts) return list.get(i).getV();
            else if (timestamp < ts) {
                r = i - 1;
            }
            else {
                l = i + 1;
            }
        }

        int ts = r >= 0 ? list.get(r).getT() : Integer.MAX_VALUE;
        //System.out.println(ts);
        return r >= 0 ? list.get(r).getV() : "";
    }

    class Pair<T, U> {
        private T t;
        private U u;

        public Pair(T t, U u) {
            this.t = t;
            this.u = u;
        }

        public T getV() {
            return t;
        }

        public U getT() {
            return u;
        }
    }
}
