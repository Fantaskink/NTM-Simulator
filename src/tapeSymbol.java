public enum tapeSymbol {
    BLANK, ZERO, ONE, X, Y,
    ;

    @Override
    public String toString() {
        return switch (this) {
            case BLANK -> "_";
            case ZERO -> "0";
            case ONE -> "1";
            case X -> "X";
            case Y -> "Y";
        };
    }
}
