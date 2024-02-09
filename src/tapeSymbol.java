public enum tapeSymbol {
    BLANK, ZERO, ONE, X, X_HAT,
    ;

    @Override
    public String toString() {
        return switch (this) {
            case BLANK -> "_";
            case ZERO -> "0";
            case ONE -> "1";
            case X -> "x";
            case X_HAT -> "x̂";
        };
    }
}
