public enum tapeSymbol {
    BLANK, ZERO, ONE, X, Y, X_HAT,
    ;

    @Override
    public String toString() {
        return switch (this) {
            case BLANK -> "_";
            case ZERO -> "0";
            case ONE -> "1";
            case X -> "X";
            case Y -> "Y";
            case X_HAT -> "X̂";
        };
    }
}
