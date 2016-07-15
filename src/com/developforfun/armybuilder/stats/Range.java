package com.developforfun.armybuilder.stats;

public class Range extends FixedRangeCharacteristic {
    // templates
    public static final int FLAMER = -1;

    public static final int MAX = 100; // I haven't seen anything in any Codex greater than this so far
    public static final int MIN = Range.FLAMER;

    public Range(int inches) throws StatOutOfRangeException {
        super("Range", inches);

        if(!isValid()) {
//            FIXME: need a better way to represent stuff like Flamer, because having
//            a range between -N and N is a bit awkward and exposes some implementation details
            throw new StatOutOfRangeException(Range.MIN, Range.MAX);
        }
    }

    @Override
    protected boolean isValid() {
        boolean isOK = true;
        // Max range is ignored
        // min bounds checking is a bit inconsistant with other classes
        if (getValue() < Range.FLAMER) {
            isOK = false;
        }
        return isOK;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (getValue() < 0) {
            str.append("Template");
        } else if (getValue() == 0) {
            str.append("-");
        } else {
            str.append(getValue());
            str.append("\"");
        }

        return str.toString().trim();
    }
}
