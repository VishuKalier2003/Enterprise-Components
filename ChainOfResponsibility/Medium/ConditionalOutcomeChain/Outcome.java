public enum Outcome implements Output {
    PASS {
        public String output = null;
        @Override
        public void updateOutcome(String outcome) {
            this.output = outcome;
        }
    }, FAIL {
        public String output = null;
        @Override
        public void updateOutcome(String outcome) {
            this.output = outcome;
        }
    }
}
